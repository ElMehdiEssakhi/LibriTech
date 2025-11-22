package org.example.dao;
import org.example.DBconnection;
import org.example.model.Livre;
import org.example.model.ManuelScolaire;
import org.example.model.Roman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDAO {
    private Connection con;
    public LivreDAO(){
        con = DBconnection.getInstance().getConnection();
    }

    public void ajouterLivre(Livre livre){
        String sql = "INSERT INTO livres( titre, auteur, annee, type, genre) VALUES (?, ?, ?, ?, 'Roman', ?)";
        String sql2 = "INSERT INTO livres( titre, auteur, annee, type, niveau_scolaire) VALUES (?, ?, ?, ?, 'ManuelScolaire', ?)";
        PreparedStatement stmt;
        try {
            if (livre instanceof Roman rm) {
                stmt = con.prepareStatement(sql);
                stmt.setString(5, rm.getGenre());
            }else if (livre instanceof ManuelScolaire ms) {
                stmt = con.prepareStatement(sql2);
                stmt.setString(5, ms.getNiveauScolaire());
            }else return;
            stmt.setString(1, livre.getTitre());
            stmt.setString(2, livre.getAuteur());
            stmt.setDate(3, Date.valueOf(livre.getAnneePublication()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur lors de lajout : " +e.getMessage());
        }
    }
    public void supprimerLivre(int livreId){
        String sql = "DELETE FROM livres WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, livreId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " +e.getMessage());
        }
    }
    public void modifierLivre(Livre livre){
        String sql = "UPDATE livres SET   titre = ?, auteur = ?, annee = ?, type = 'Roman', genre =?  WHERE id = ?";
        String sql2 = "UPDATE livres SET  titre = ?, auteur = ?, annee = ?, type = 'ManuelScolaire', niveau_scolaire =?  WHERE id = ?";
        PreparedStatement stmt;
        try {
            if (livre instanceof Roman rm) {
                stmt = con.prepareStatement(sql);
                stmt.setString(5, rm.getGenre());
            }else if (livre instanceof ManuelScolaire ms) {
                stmt = con.prepareStatement(sql2);
                stmt.setString(5, ms.getNiveauScolaire());
            }else return;
            stmt.setString(2, livre.getTitre());
            stmt.setString(3, livre.getAuteur());
            stmt.setDate(4, Date.valueOf(livre.getAnneePublication()));
            stmt.setInt(6, livre.getId());

        }catch (SQLException e) {
            System.out.println("Erreur lors de la modification : " + e.getMessage());
        }
    }
    public List<Livre> listerLivres() {
        List<Livre> livres = new ArrayList<>();
        String sql = "SELECT * FROM livres";
        try (PreparedStatement stmt = con.prepareStatement(sql)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");
                Livre livre;
                if ("Roman".equalsIgnoreCase(type)) {
                    Roman roman = new Roman();
                    roman.setGenre(rs.getString("genre"));
                    livre = roman;
                } else if ("ManuelScolaire".equalsIgnoreCase(type)) {
                    ManuelScolaire ms = new ManuelScolaire();
                    ms.setNiveauScolaire(rs.getString("niveau_scolaire"));
                    livre = ms;
                } else {
                    livre = new Livre();
                }
                livre.setId(rs.getInt("id"));
                livre.setTitre(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setAnneePublication(rs.getDate("annee").toLocalDate());
                livres.add(livre);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors du listing : " + e.getMessage());
        }
        return livres;
    }

    public Livre chercherLivreParId(int id) {
        String sql = "SELECT * FROM livres WHERE id = ?";
        try  {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String type = rs.getString("type");
                Livre livre;
                if ("Roman".equalsIgnoreCase(type)){
                    Roman rm = new Roman();
                    rm.setGenre(rs.getString("genre"));
                    livre = rm;
                } else if ("ManuelScolaire".equalsIgnoreCase(type)) {
                    ManuelScolaire ms  = new ManuelScolaire();
                    ms.setNiveauScolaire(rs.getString("niveau_scolaire"));
                    livre = ms;
                }else {
                    livre = new Livre();
                }
                livre.setId(rs.getInt("id"));
                livre.setTitre(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setAnneePublication(rs.getDate("annee").toLocalDate());
                return livre;
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return null; // si non trouvé
    }
}
