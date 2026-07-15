package com.naresh.day004.controller;

import com.naresh.day004.dao.impl.UserDAOImpl;
import com.naresh.day004.dto.LoginRequest;
import com.naresh.day004.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDAOImpl userDAO = new UserDAOImpl();

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> response = new HashMap<>();
        
        // Aapka purana authentication logic call ho raha hai yahan
        User user = userDAO.authenticateUser(request.getUsername(), request.getPassword());

        if (user != null) {
            response.put("status", "SUCCESSFUL");
            response.put("message", "Login Successful");
            response.put("user", user);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "FAILED");
            response.put("message", "Invalid Username or Password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
