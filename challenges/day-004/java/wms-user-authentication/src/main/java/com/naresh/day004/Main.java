package com.naresh.day004;

import com.naresh.day004.dao.UserDAO;
import com.naresh.day004.dao.impl.UserDAOImpl;
import com.naresh.day004.model.User;
import com.naresh.day004.model.User;
import com.naresh.day004.service.LoginService;
import com.naresh.day004.service.impl.LoginServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

User user = new User();

user.setEmployeeId("EMP002");
user.setUsername("amit");
user.setPasswordHash("hash123");
user.setFirstName("Amit");
user.setLastName("Sharma");
user.setEmail("amit@wms.com");
user.setPhone("9999999999");
user.setStatus("ACTIVE");


UserDAO userDAO = new UserDAOImpl();

boolean result = userDAO.createUser(user);


if(result) {
    System.out.println("==============================");
    System.out.println("USER CREATED SUCCESSFULLY");
    System.out.println("==============================");
}
else {
    System.out.println("USER CREATION FAILED");
}


        Scanner scanner = new Scanner(System.in);

        LoginService loginService = new LoginServiceImpl();

        System.out.println("===========================================");
        System.out.println("      WMS USER AUTHENTICATION SYSTEM");
        System.out.println("===========================================");

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
    }
}
