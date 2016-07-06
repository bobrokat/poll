package com.fujitsu.fs.javalab.poll.webapp.controller;

import com.fujitsu.fs.javalab.poll.webapp.model.PollChoice;
import com.fujitsu.fs.javalab.poll.webapp.hsqldb.ConfigSingletone;
import com.fujitsu.fs.javalab.poll.webapp.hsqldb.PollRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ekaterina on 01.05.2016.
 */
public class PollResultController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Configuration cfg = ConfigSingletone.getConfig(getServletContext());
        Template tmp = cfg.getTemplate("pollresult.ftl");
        HashMap<String, Object> root = new HashMap<>();
        HttpSession session = req.getSession();
        Long pollid = (Long) session.getAttribute("pollid");
        try {
            ArrayList<PollChoice> pollChoices = PollRepository.getPollChoices(pollid);
            root.put("pollChoices", pollChoices);
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
