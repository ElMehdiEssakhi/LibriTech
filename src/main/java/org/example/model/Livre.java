package org.example.model;

import java.time.LocalDate;

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private LocalDate anneePublication;

    public Livre() {
    }

    public Livre(int id, String titre,String auteur, LocalDate anneePublication) {
        this.id=id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    public Livre( String titre, String auteur,LocalDate anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public LocalDate getAnneePublication() {
        return anneePublication;
    }
    public void setAnneePublication(LocalDate anneePublication) {
        this.anneePublication = anneePublication;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
}
