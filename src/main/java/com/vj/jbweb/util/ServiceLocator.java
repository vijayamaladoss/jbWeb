package com.vj.jbweb.util;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

    public static DataSource getDataSource(String jndiName) {

        Context ctx = null;
        DataSource ds = null;

        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(jndiName);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ds;
    }
}