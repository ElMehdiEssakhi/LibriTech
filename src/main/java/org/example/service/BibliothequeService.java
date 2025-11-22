package org.example.service;
import org.example.dao.LivreDAO;
import org.example.dao.UtilisateurDAO;
import org.example.dao.EmpruntDAO;
import org.example.model.Emprunt;
import org.example.model.Livre;
import org.example.model.Utilisateur;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class BibliothequeService {
    private LivreDAO livreDAO;
    private UtilisateurDAO utilisateurDAO;
    private EmpruntDAO empruntDAO;

    public BibliothequeService(LivreDAO livreDAO, UtilisateurDAO utilisateurDAO, EmpruntDAO empruntDAO) {
        this.livreDAO = livreDAO;
        this.utilisateurDAO = utilisateurDAO;
        this.empruntDAO = empruntDAO;
    }
    public void ajouterLivre(Livre livre) {
        livreDAO.ajouterLivre(livre);
    }
    public boolean supprimerLivre(int livreId) {
        Livre livre = livreDAO.chercherLivreParId(livreId);
        if(livre!=null){
            livreDAO.supprimerLivre(livreId);
            return true;
        }else{
            return false;
        }
    }
    public void modifierLivre(Livre livre) {
        livreDAO.modifierLivre(livre);
    }
    public List<Livre> listerLivres() {
        return livreDAO.listerLivres();
    }
    public Livre chercherLivreParId(int id) {
        return livreDAO.chercherLivreParId(id);
    }
    public void ajouterUtilisateur(Utilisateur user) {
        utilisateurDAO.ajouterUtilisateur(user);
    }
    public boolean supprimerUtilisateur(int utilisateurId) {
        Utilisateur utilisateur = utilisateurDAO.chercherUtilisateurParId(utilisateurId);
        if (utilisateur != null) {
            utilisateurDAO.supprimreUtilisateur(utilisateurId);
            return true;
        }
        return false;
    }
    public void modifierUtilisateur(Utilisateur user) {
        utilisateurDAO.modifierUtilisateur(user);
    }
    public List<Utilisateur> listerUtilisateur() {
        return utilisateurDAO.listerUtilisateur();
    }
    public Utilisateur chercherUtilisateurParId(int id) {
        return utilisateurDAO.chercherUtilisateurParId(id);
    }
    public void ajouterEmprunt(int livreId,int utilisateurId,LocalDate dateEmprunt){
        Livre livre = livreDAO.chercherLivreParId(livreId);
        Utilisateur utilisateur = utilisateurDAO.chercherUtilisateurParId(utilisateurId);
        Emprunt emprunt = new Emprunt(livre,utilisateur,dateEmprunt);
        empruntDAO.ajouterEmprunt(emprunt);
    }
    public boolean supprimerEmprunt(int id) {
        Emprunt emprunt = empruntDAO.chercherEmpruntParId(id, livreDAO, utilisateurDAO);
        if (emprunt != null) {
            empruntDAO.supprimerEmprunt(id);
            return true;
        }
        return false;
    }
    public void modifierEmprunt(int emId, int utilisateurId, int livreId, LocalDate dateEmprunt, LocalDate dateRetour) {
        Livre livre = livreDAO.chercherLivreParId(livreId);
        Utilisateur user = utilisateurDAO.chercherUtilisateurParId(utilisateurId);
        Emprunt emprunt = new Emprunt(emId, livre, user, dateEmprunt, dateRetour);
        empruntDAO.modifierEmprunt(emprunt);
    }
    public Emprunt chercherEmpruntParId(int id, LivreDAO livreDAO, UtilisateurDAO utilisateurDAO) {
        return empruntDAO.chercherEmpruntParId(id, livreDAO, utilisateurDAO);
    }
    public List<Emprunt> listerEmprunts() {
        return empruntDAO.listerEmprunts(livreDAO, utilisateurDAO);
    }
}

