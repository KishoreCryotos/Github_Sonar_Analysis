package com.example.javamavenjunithelloworld;

import java.sql.Connection;
import java.sql.Statement;

public class TestVuln {

    String awsKey = "AKIA123456789TESTKEY";
    String password = "admin123";

    public void run(String input, Connection conn) throws Exception {

        Runtime.getRuntime().exec(input);

        Statement stmt = conn.createStatement();
        stmt.executeQuery("SELECT * FROM users WHERE id=" + input);
    }
}
