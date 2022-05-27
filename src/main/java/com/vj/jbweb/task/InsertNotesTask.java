package com.vj.jbweb.task;

import com.vj.jbweb.dao.InsertNotesDao;
import com.vj.jbweb.model.Notes;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class InsertNotesTask implements Callable<Integer>, Serializable {

    private final Notes note;
    InsertNotesDao notesDao = new InsertNotesDao();

    public InsertNotesTask(Notes note) {
        this.note = note;
    }


    @Override
    public Integer call() throws Exception {
        return notesDao.insertNotes(note);
    }
}
