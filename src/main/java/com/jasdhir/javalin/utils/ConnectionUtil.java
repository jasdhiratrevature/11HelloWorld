package com.jasdhir.javalin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;







public class ConnectionUtil {



    public static Connection createConnection() {

        try {
            //jdbc:postgresql://35.226.135.224:5432/ToDoDB?user=user&password=password
            Connection conn = DriverManager.getConnection(System.getenv("DB_URL"));
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
         
            return null;
        }

    }
}

