package org.example.model;

import java.time.LocalDate;

public class ManuelScolaire extends Livre{
    private String niveauScolaire;

    public ManuelScolaire(int id, String titre, String auteur, LocalDate anneePublication, String niveauScolaire) {
        super(id, titre,auteur,  anneePublication);
        this.niveauScolaire=niveauScolaire;

    }

    public ManuelScolaire() {

    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }
    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }
}
