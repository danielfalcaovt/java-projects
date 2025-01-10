package com.springboot.sbe_02.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class InsertValuesInDbMock {
    static void insert(Connection connection) throws Exception {
        PreparedStatement insertMock = connection.prepareStatement("INSERT INTO users(id, name, email, password) VALUES(?, ?, ?, ?)");
        insertMock.setString(1, String.valueOf(UUID.randomUUID()));
        insertMock.setString(2, "nome aleatório");
        insertMock.setString(3, "email aleatório");
        insertMock.setString(4, "senha aleatória");
        insertMock.execute();
    }
}
