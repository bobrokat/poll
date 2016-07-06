package com.fujitsu.fs.javalab.poll.webapp.controller;

import com.fujitsu.fs.javalab.poll.webapp.model.Poll;
import com.fujitsu.fs.javalab.poll.webapp.hsqldb.ConfigSingletone;
import com.fujitsu.fs.javalab.poll.webapp.hsqldb.PollRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PollsController extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//        } catch (ClassNotFoundException e) {
//            throw new ServletException("HSQLD driver was not found", e);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            ArrayList<Poll> polls = PollRepository.getPolls();
            Configuration cfg = ConfigSingletone.getConfig(getServletContext());
            Template tmp = cfg.getTemplate("polls.ftl");
            HashMap<String, Object> root = new HashMap<>();
            root.put("polls", polls);
            tmp.process(root, resp.getWriter());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }


    }
}
