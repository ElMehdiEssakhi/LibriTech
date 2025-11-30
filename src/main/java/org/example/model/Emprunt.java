package org.example.model;

import java.time.LocalDate;

public class Emprunt {
    private int id;
    private Livre livre;        // The book being borrowed
    private Utilisateur utilisateur;  // The user who borrows the book
    private LocalDate dateEmprunt;   // The borrowing date
    private LocalDate dateRetour;    // The return date (null if not yet returned)

    // Constructor
    public Emprunt(Livre livre, Utilisateur utilisateur, LocalDate dateEmprunt) {
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Emprunt(int Id,Livre livre, Utilisateur utilisateur, LocalDate dateEmprunt,LocalDate dateRetour) {
        this.id = Id;
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public Emprunt() {

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    // Check if the book has been returned
    public boolean isReturned() {
        return dateRetour != null;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", " + livre +
                ", " + utilisateur +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                '}';
    }
}
