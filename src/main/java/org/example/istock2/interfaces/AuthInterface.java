package org.example.istock2.interfaces;

import org.example.istock2.models.User;

import java.sql.SQLException;

public interface AuthInterface {

    void regster(User user) throws SQLException;

    void singIn(User user);
    
}
