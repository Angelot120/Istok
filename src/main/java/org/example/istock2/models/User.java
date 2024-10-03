package org.example.istock2.models;

import org.example.istock2.DBConnection.IDBConfig;
import org.example.istock2.interfaces.AuthInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User implements AuthInterface {

    private int id;
    private String username;
    private String password;
    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public void regster(User user) throws SQLException {

        System.out.println("Register button clicked");

        this.connection = IDBConfig.getConnection();

        if (this.connection != null) {

            String req = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(req);

            preparedStatement.setString(1, getUsername());
            preparedStatement.setString(1, getPassword());

            preparedStatement.executeUpdate();

            System.out.println("Client registered successfully");

            connection.close();
            preparedStatement.close();


        }

    }

    @Override
    public void singIn(User user) {

    }
}
