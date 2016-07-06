package com.fujitsu.fs.javalab.poll.webapp.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ekaterina on 01.05.2016.
 */
public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\Ekaterina\\Desktop\\Fujitsu\\databases\\poll", "SA", "");

        return conn;
    }
}
