package org.example.view;

import org.example.model.Admin;
import org.example.service.AuthService;

import java.util.Scanner;

public class AuthView {
    private AuthService authService;
    public AuthView(AuthService authService) {
        this.authService = authService;
    }
    public void start(){
        System.out.println("Welcome to LIBRITECH");
        System.out.println("Log In");
        System.out.println("Please enter your username and password");
        System.out.println("username");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        authService.check(new Admin(username, password));
    }
}
