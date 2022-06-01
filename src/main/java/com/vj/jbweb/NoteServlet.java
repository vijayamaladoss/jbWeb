package com.vj.jbweb;

import com.vj.jbweb.model.Notes;
import com.vj.jbweb.task.InsertNotesTask;
import com.vj.jbweb.task.TestTask;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "notesServlet", value = "/notes-servlet")
public class NoteServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(NoteServlet.class.getName());


    @Resource(name = "java:comp/DefaultManagedExecutorService")
    ManagedExecutorService mExecService;


    public void init() {

        LOGGER.log(Level.INFO, "Notes Servlet Initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int numUpdates = -1;
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        Notes note = new Notes("Test Note", true);
        //mExecService.submit(new InsertNotesTask(note));
        try {

            Future<Integer> future = mExecService.submit(
                    new InsertNotesTask(note));
            numUpdates = future.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception ex) {
            out.println("<h5>" + ex.getMessage() + "</h5>");
        }

        out.println("<h1>Notes Servlet</h1>");
        out.println("<h2>" + numUpdates + "</h2>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}
