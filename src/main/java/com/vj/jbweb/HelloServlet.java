package com.vj.jbweb;

import com.vj.jbweb.service.DBVersionService;
import com.vj.jbweb.task.TestTask;

import java.io.*;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.logging.Level;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    private final static Logger LOGGER = Logger.getLogger(HelloServlet.class.getName());

    String version = DBVersionService.getMySQLVersion();


    @Resource(name="java:comp/DefaultManagedExecutorService")
    ManagedExecutorService mExecService;

    @Resource(name="java:comp/DefaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService sExecService;


    public void init() {

        message = "Hello World Servlet New Setup!";
        LOGGER.log(Level.INFO, "Servlet Initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        mExecService.submit(new TestTask());
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + version + "</h1>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}