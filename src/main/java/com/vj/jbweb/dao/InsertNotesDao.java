package com.vj.jbweb.dao;

import com.vj.jbweb.model.Notes;
import com.vj.jbweb.service.DBVersionService;
import com.vj.jbweb.util.ServiceLocator;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class InsertNotesDao {
    private final static Logger LOGGER = Logger.getLogger(InsertNotesDao.class.getName());

    public Integer insertNotes(Notes note) {
        try {
            DataSource ds = (DataSource) new InitialContext().lookup(
                    "java:/MariaDB");
            Connection con = ds.getConnection();
            try {
                PreparedStatement stmt = con.prepareStatement(
                        "INSERT INTO NOTES(note, completed) VALUES(?,?)");
                stmt.setString(1, note.getNote());
                stmt.setBoolean(2, note.isCompleted());
                return stmt.executeUpdate();
            } finally {
                con.close();
            }
        } catch (NamingException x) {
            throw new RuntimeException(x);
        } catch (SQLException x) {
            throw new RuntimeException(x);
        }
    }

}
