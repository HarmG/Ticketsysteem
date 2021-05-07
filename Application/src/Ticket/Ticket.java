package Ticket;

import Application.Application;
import Note.Note;
import User.FuctionRole;
import User.User;
import Prioritize.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Ticket {
    private int id;
    private final User caller;
    private Application application;
    private String description;
    private final LocalDateTime reportTime;
    private LocalDateTime endTime;
    // impact en urgency zijn protected zodat deze vanuit de subclasse deze gevalideerd kunnen worden
    protected PriorityLevel impact;
    protected PriorityLevel urgency;
    private State state;
    private User assignedTo;
    private User resolvedBy;
    // Prioritization heb ik protected gemaakt omdat wanneer ik deze in de superclass aanmaak de impact en urgency niet goed worden mee gegeven.
    // Nu ik de Priorityzation in de sub aanmaak gaat het wel goed.
    protected Prioritization prioritization;
    private String closeNote;
    private ArrayList<Note> userVisibleNote = new ArrayList<>();
    private ArrayList<Note> worknotes = new ArrayList<>();
    private ArrayList<Note> intakeAnsweres = new ArrayList<>();

    public Ticket(User caller, String description, Application application, PriorityLevel impact, PriorityLevel urgency) {
        this.impact = impact;
        this.urgency = urgency;
        this.caller = caller;
        this.description = description;
        this.application = application;
        this.reportTime = LocalDateTime.now();
        this.state = State.NEW;
        this.prioritization = new Prioritization(this);
    }

    //Opmerkingen kunnen door zowel IT-medewerkers worden toegevoegd als de indiener
    public final void addUserVisibleNote(String opmerking, User user) {
        Note note = new Note(opmerking, user);
        userVisibleNote.add(note);
    }

    // Werknotities zijn alleen toe tevoegen door IT-Medewerkers
    public final boolean addWorkNote(String notation, User user) {
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            Note note = new Note(notation, user);
            worknotes.add(note);
            setStateToAssign(State.ASSIGNED, user);
            return true;
        }
    }

    public PriorityLevel getImpact() {
        return impact;
    }

    public PriorityLevel getUrgency() {
        return urgency;
    }

    public void setImpact(PriorityLevel impact) {
        this.impact = impact;
        prioritization.reCalc(this);
    }

    //wanneer urgentie word aangepast moet de prio en oplostijd meeveranderen
    public void setUrgency(PriorityLevel urgency) {
        this.urgency = urgency;
        prioritization.reCalc(this);
    }

    private final LocalDateTime setEndTime() {
        return LocalDateTime.now();
    }

    public final boolean setStateToAssign(State state, User user) {
        //Staat van de ticket kan alleen worden aangepast door een gebruiker met de rol IT-Medewerker
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else if (state != State.RESOLVED) {
            this.state = state;
            this.assignedTo = user;
            return true;
            //Om een ticket op te lossen moet er een note bij gezet worden. Dit kan in de volgende methode.
        } else {
            return false;
        }
    }

    public boolean resolveTicket(User user, String closeNote) {
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else {
            this.state = State.RESOLVED;
            this.closeNote = closeNote;
            this.endTime = setEndTime();
            this.resolvedBy = user;
            return true;
        }
    }

    public final boolean setApplication(Application application, User user) {
        //Mag alleen door een IT-Medewerker worden aangepast.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return false;
        } else if (application.getCriticalApp() != true) {
            this.application = application;
            setStateToAssign(State.ASSIGNED, user);
            return true;
            //wanneer de applicatie critical is moet dit doorgevoerd worden in de prio
        } else {
            this.application = application;
            setUrgency(PriorityLevel.HIGH);
            setImpact(PriorityLevel.HIGH);
            setStateToAssign(State.ASSIGNED, user);
            return true;
        }
    }

    public void setIntakeAnsweres(String intake, User user) {
        Note intakeAnswer = new Note(intake, user);
        intakeAnsweres.add(intakeAnswer);
    }

    public final ArrayList<Note> getWorkNotes(User user) {
        //Werknotities mogen alleen worden ingezien doot IT-Medewerkers.
        if (user.getFunctionRole() != FuctionRole.ADMINISTRATOR) {
            return null;
        } else {
            return worknotes;
        }
    }

    public final int getId() {
        return id;
    }

    public final User getCaller() {
        return caller;
    }

    public final String getDescription() {
        return description;
    }

    public final LocalDateTime getReportTime() {
        return reportTime;
    }

    public final LocalDateTime getEndTime() {
        return endTime;
    }

    public final State getState() {
        return state;
    }

    public final Application getApplication() {
        return application;
    }

    public final Prioritization getPrioritization() {
        return prioritization;
    }

    public String getCloseNote() {
        return closeNote;
    }

    public ArrayList<Note> getIntakeAnsweres() {
        return intakeAnsweres;
    }

    public final ArrayList<Note> getUserVisibleNote() {
        return userVisibleNote;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public User getResolvedBy() {
        return resolvedBy;
    }
}