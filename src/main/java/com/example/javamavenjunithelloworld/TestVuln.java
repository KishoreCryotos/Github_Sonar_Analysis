package com.example.javamavenjunithelloworld;

import java.sql.Connection;
import java.sql.Statement;

public class TestVuln {

    String awsKey = "AKIA123456789TESTKEY";
    String password = "admin123";

    String githubToken = "ghp_1234567890abcdefghijklmnop";
    String apiKey = "sk_test_ABC123SECRETXYZ";
    String dbPassword = "root@123";

     String awsKey3 = "AKIA987654321TESKEYS";

    // New secret for extra Gitleaks finding
    String awsKey2 = "AKIA999999999NEWTEST";

    public void run(String input, Connection conn) throws Exception {

        Runtime.getRuntime().exec(input);

        Runtime.getRuntime().exec("cmd /c " + input);

        // New Semgrep finding
        Runtime.getRuntime().exec("powershell " + input);

        Statement stmt = conn.createStatement();

        stmt.executeQuery("SELECT * FROM users WHERE id=" + input);

        stmt.executeQuery("DELETE FROM users WHERE name='" + input + "'");

        String query = "UPDATE users SET role='admin' WHERE id=" + input;
        stmt.executeQuery(query);
    }
}
