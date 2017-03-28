package com.equalinformation.car.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by bpupadhyaya on 3/28/17.
 */
public class DBUtil {
    private static int CONNCOUNT = 0;
    Connection connection = null;

    public Connection getConnection() {
        if (CONNCOUNT == 0) {
            createConnection();
            ++CONNCOUNT;
        }

        return connection;
    }

    private Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/"; // Your DB details
        String dbName = "tesla";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "****";
        String password = "******";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url+dbName,userName,password);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
