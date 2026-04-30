package com.example.javamavenjunithelloworld;

import java.sql.Connection;
import java.sql.Statement;

public class TestVuln {

    // One Gitleaks finding only
    String awsKey = "AKIA2026NEWTESTKEY12";
    String awsKey = "AKIA2026OLDTESTKEY23";
    String awsKey = "AKIA2026NODTESTKEY43";

    public void run(String input, Connection conn) throws Exception {

        Statement stmt = conn.createStatement();

        // One Semgrep finding only  
        stmt.executeQuery("SELECT * FROM users WHERE id=" + input);

        // Semgrep Finding 2 (Command Injection)
        Runtime.getRuntime().exec(input);

         // ✅ NEW Semgrep Finding 3 (SQL Injection - INSERT)
        stmt.executeQuery("INSERT INTO users(name) VALUES('" + input + "')");
    }
}
