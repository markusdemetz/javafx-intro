package com.example.javafx.dal.postgres;

import java.sql.*;

public class PostgresDB {
    private String connectionString;
    private String user = "username"; // put into config file
    private String pass = "password"; // put into config file

    public PostgresDB(String connectionString) {
        this.connectionString = connectionString;
        // this.user = someProperties.get("username");
        // this.pass = someProperties.get("password");
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionString, "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Long insert(String sqlString /*, params, values */) {
        // INSERT INTO tour (name, description) VALUES (?, ?, ?);

        // TRY WITH RESOURCES
        try(Connection conn = createConnection();) {
            PreparedStatement stmt = conn.prepareStatement(sqlString);

            stmt.setString(1, "Tour Name");
            stmt.setString(2, "Tour Description");
            ResultSet resultSet = stmt.executeQuery();

        } catch(SQLException e) {

        }

        throw new UnsupportedOperationException("To implement!");
    }


}
