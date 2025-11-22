package org.example.service;

import org.example.dao.AuthDAO;
import org.example.dao.EmpruntDAO;
import org.example.dao.LivreDAO;
import org.example.dao.UtilisateurDAO;
import org.example.model.Admin;
import org.example.view.*;

public class AuthService {
    private AuthDAO authDAO;
    public AuthService(AuthDAO authDAO){
        this.authDAO = authDAO;
    }
    public void check (Admin admin){
        boolean response = authDAO.AuthenticateAdmin(admin);
        if(response){
            System.out.println("User authenticated");
            LivreDAO livreDAO = new LivreDAO();
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            EmpruntDAO empruntDAO = new EmpruntDAO();
            BibliothequeService bibServe = new BibliothequeService(livreDAO,utilisateurDAO,empruntDAO);
            LivreView livreView = new LivreView(bibServe);
            UtilisateurView utilisateurView = new UtilisateurView(bibServe);
            EmpruntView empruntView = new EmpruntView(bibServe);
            BiblioView biblioView = new BiblioView(livreView,utilisateurView,empruntView);
            biblioView.start();
        }else {
            System.out.println("User not authenticated");
        }
    }
}
