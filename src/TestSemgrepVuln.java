package com.example.vuln;

import java.sql.Connection;
import java.sql.Statement;

public class TestSemgrepVuln {

    public void test(String input, Connection conn) throws Exception {

        // 🔴 Command Injection (HIGH)
        Runtime.getRuntime().exec(input);

        // 🔴 Command Injection (variant)
        Runtime.getRuntime().exec("sh -c " + input);

        // 🔴 SQL Injection (HIGH)
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE id=" + input;
        stmt.executeQuery(query);

        // 🔴 Hardcoded credential
        String password = "SuperSecret123";

        // 🔴 Insecure random
        java.util.Random rand = new java.util.Random();
        int value = rand.nextInt();

        System.out.println(value);
    }
}
