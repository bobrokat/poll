package com.fujitsu.fs.javalab.poll.webapp.hsqldb;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

/**
 * Created by Ekaterina on 09.10.2015.
 */
public class ConfigSingletone {
    private static Configuration cfg = null;
    public static Configuration getConfig(ServletContext servletContext) {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_22);
            cfg.setServletContextForTemplateLoading(servletContext, "/WEB-INF/templates");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        }
        return cfg;
    }
}
