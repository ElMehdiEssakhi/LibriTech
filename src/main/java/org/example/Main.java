package org.example;

import org.example.dao.AuthDAO;
import org.example.model.Admin;
import org.example.service.AuthService;
import org.example.view.AuthView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AuthDAO authDAO = new AuthDAO();
        AuthService authService = new AuthService(authDAO);
        AuthView view = new AuthView(authService);
        view.start();

    }

}
