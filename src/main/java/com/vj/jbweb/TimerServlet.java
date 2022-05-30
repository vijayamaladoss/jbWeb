package com.vj.jbweb;

import com.vj.jbweb.task.TestTask;
import com.vj.jbweb.task.TestTimerTask;

import java.io.*;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.logging.Level;

@WebServlet(name = "timerServlet", value = "/timer-servlet")
public class TimerServlet extends HttpServlet {
    private String message;

    private final static Logger LOGGER = Logger.getLogger(TimerServlet.class.getName());


    @Resource(name="java:comp/DefaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService sExecService;


    public void init() {

        message = "Hello World Servlet New Setup!";
        LOGGER.log(Level.INFO, "Servlet Initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ScheduledFuture<?> future = sExecService.scheduleWithFixedDelay(
                new TestTimerTask(), 5, 5, TimeUnit.SECONDS);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}