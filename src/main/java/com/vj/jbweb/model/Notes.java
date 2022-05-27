package com.vj.jbweb.model;

public class Notes {

    private String note;

    private boolean completed;

    public Notes(String note, boolean completed) {
        this.note = note;
        this.completed = completed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "note='" + note + '\'' +
                ", completed=" + completed +
                '}';
    }
}
