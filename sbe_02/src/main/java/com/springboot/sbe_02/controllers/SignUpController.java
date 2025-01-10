package com.springboot.sbe_02.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    record Usuario(String id, String username) {}
    record HeaderInfo(String name, String authorization) {}

    @GetMapping("/users")
    public ResponseEntity<Object> signUp() {
        List<Usuario> userList = new ArrayList<Usuario>();
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "brbr109br");
        try {
            // this is very ugly iknow but it's only for research
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CursoJava", props);
            final String SQL_QUERY = "SELECT * FROM users";
            InsertValuesInDbMock.insert(connection);
            PreparedStatement pst = connection.prepareStatement(SQL_QUERY);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                userList.add(new Usuario(rst.getString("id"), rst.getString("name")));
            }
            return ResponseEntity.ok().body(userList);
        }catch(SQLException ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Internal Server Error.");
        }catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body("Internal Server Error.");
        }
    }

    @GetMapping("/get")
    public String getSomething(@PathVariable String id) {
        return id;
    }

    @GetMapping("/getAll")
    public String getSomethings(@RequestParam Map<String, String> req) {
        return String.format("%s valores", req.entrySet());
    }

    @PostMapping("/post")
    public Usuario postSomething(@RequestBody Usuario usuario) {
        return usuario;
    }

    @PostMapping("/sla")
    public String returnJWT(@RequestHeader  Map<String, String> headerInfo) {
        return String.valueOf(headerInfo.entrySet());
    }

    @GetMapping("/response")
    public ResponseEntity<Usuario> metodoResponse() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Usuario("any_id", "any_name"));
    }
}