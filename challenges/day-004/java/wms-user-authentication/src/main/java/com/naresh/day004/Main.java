package com.naresh.day004;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.naresh.day004.dao.impl.UserDAOImpl;
import com.naresh.day004.model.User;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        // Port 8080 par ek build-in HTTP server start kar rahe hain
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Yeh endpoint Rest Assured script ke liye request sunega
        server.createContext("/api/users/login", new LoginHandler());
        
        server.setExecutor(null); 
        System.out.println("===========================================");
        System.out.println("🚀 WMS REST API SERVER STARTED ON PORT 8080");
        System.out.println("===========================================");
<<<<<<< HEAD

        System.out.print("Enter Username : ");
        String username = scanner.nextLine();

        System.out.print("Enter Password : ");
        String password = scanner.nextLine();

        User loggedInUser = loginService.login(username, password);

        if (loggedInUser != null) {

            System.out.println("\n===========================================");
            System.out.println("          LOGIN SUCCESSFUL");
            System.out.println("===========================================");
            System.out.println(loggedInUser);

        } else {

            System.out.println("\n❌ Invalid Username or Password.");

        }

        scanner.close();
=======
        server.start();
>>>>>>> d171523 (SCRUM-45: Add SDET-007 Order Analytics System using Java JDBC MySQL DAO Pattern)
    }

    static class LoginHandler implements HttpHandler {
        private final UserDAOImpl userDAO = new UserDAOImpl();

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                String body = new String(exchange.getRequestBody().readAllBytes());
                
                // Rest Assured ke input body se username aur password extract karne ke liye safe check
                String username = body.contains("\"username\"") ? 
                        body.split("\"username\"\\s*:\\s*\"")[1].split("\"")[0] : "";
                String password = body.contains("\"password\"") ? 
                        body.split("\"password\"\\s*:\\s*\"")[1].split("\"")[0] : "";

                User user = userDAO.authenticateUser(username, password);
                String response;
                int statusCode;

                if (user != null) {
                    statusCode = 200;
                    response = "{\"status\":\"SUCCESSFUL\",\"message\":\"Login Successful\",\"user\":{\"username\":\"" + username + "\"}}";
                } else {
                    statusCode = 401;
                    response = "{\"status\":\"FAILED\",\"message\":\"Invalid Username or Password\"}";
                }

                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(statusCode, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); 
            }
        }
    }
}