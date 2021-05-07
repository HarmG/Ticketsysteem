package Note;

import User.User;

import java.time.LocalDateTime;

public class Note {
    private String note;
    private User user;
    private final LocalDateTime timeOfNotation;

    public Note(String note, User user) {
        this.user = user;
        this.note = note;
        this.timeOfNotation = LocalDateTime.now();
    }

    public final String getNote() {
        return note;
    }

    public User getUser() {
        return user;
    }

    public final LocalDateTime getTimeOfNotation() {
        return timeOfNotation;
    }
}
