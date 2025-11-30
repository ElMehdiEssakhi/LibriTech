package org.example.model;

import java.time.LocalDate;

public class Roman extends Livre{
    private String genre;

    public Roman(int id, String titre, String auteur, LocalDate anneePublication, String genre) {
        super(id, titre, auteur, anneePublication);
        this.genre = genre;
    }

    public Roman(String titre, String auteur, LocalDate anneePublication, String genre) {
        super(titre, auteur, anneePublication);
        this.genre = genre;
    }

    public Roman() {

    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
