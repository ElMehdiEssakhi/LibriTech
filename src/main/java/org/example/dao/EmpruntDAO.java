package org.example.dao;

import org.example.DBconnection;
import org.example.model.Emprunt;
import org.example.model.Livre;
import org.example.model.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDAO {
    private Connection con;
    public EmpruntDAO(){
        con = DBconnection.getInstance().getConnection();
    }

    public void ajouterEmprunt(Emprunt emprunt){
        String sql = "INSERT INTO emprunts(livre_id, utilisateur_id, date_emprunt, date_retour) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, emprunt.getLivre().getId());
            stmt.setInt(2, emprunt.getUtilisateur().getId());
            stmt.setDate(3, Date.valueOf(emprunt.getDateEmprunt()));
            if (emprunt.getDateRetour() != null) {
                stmt.setDate(4, Date.valueOf(emprunt.getDateRetour()));
            } else {
                stmt.setNull(4, Types.DATE);
            }
            stmt.executeUpdate();
            System.out.println("Emprunt ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'emprunt : " + e.getMessage());
        }
    }
    public void supprimerEmprunt(int id) {
        String sql = "DELETE FROM emprunts WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Emprunt supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'emprunt : " + e.getMessage());
        }
    }

    public void modifierEmprunt(Emprunt emprunt) {
        String sql = "UPDATE emprunts SET livre_id=? ,utilisateur_id=?, date_emprunt=?,date_retour = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, emprunt.getLivre().getId());
            stmt.setInt(2, emprunt.getUtilisateur().getId());
            stmt.setDate(3, Date.valueOf(emprunt.getDateEmprunt()));
            if (emprunt.getDateRetour() != null) {
                stmt.setDate(4, Date.valueOf(emprunt.getDateRetour()));
            } else {
                stmt.setNull(4, Types.DATE);
            }
            stmt.setInt(5, emprunt.getId());
            stmt.executeUpdate();
            System.out.println("Emprunt modifié avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'emprunt : " + e.getMessage());
        }
    }
    public Emprunt chercherEmpruntParId(int id, LivreDAO livreDAO, UtilisateurDAO utilisateurDAO) {
        String sql = "SELECT * FROM emprunts WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Emprunt e = new Emprunt();
                    e.setId(rs.getInt("id"));

                    // récupérer Livre et Utilisateur via DAO
                    e.setLivre(livreDAO.chercherLivreParId(rs.getInt("livre_id")));
                    e.setUtilisateur(utilisateurDAO.chercherUtilisateurParId(rs.getInt("utilisateur_id")));

                    e.setDateEmprunt(rs.getDate("date_emprunt").toLocalDate());
                    Date retour = rs.getDate("date_retour");
                    if (retour != null) e.setDateRetour(retour.toLocalDate());

                    return e;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche de l'emprunt : " + ex.getMessage());
        }
        return null;
    }

    // Lister tous les emprunts
    public List<Emprunt> listerEmprunts(LivreDAO livreDAO, UtilisateurDAO utilisateurDAO) {
        List<Emprunt> emprunts = new ArrayList<>();
        String sql = "SELECT * FROM emprunts";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Emprunt e = new Emprunt();
                e.setId(rs.getInt("id"));
                e.setLivre(livreDAO.chercherLivreParId(rs.getInt("livre_id")));
                e.setUtilisateur(utilisateurDAO.chercherUtilisateurParId(rs.getInt("utilisateur_id")));
                e.setDateEmprunt(rs.getDate("date_emprunt").toLocalDate());

                Date retour = rs.getDate("date_retour");
                if (retour != null) e.setDateRetour(retour.toLocalDate());

                emprunts.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors du listing des emprunts : " + e.getMessage());
        }
        return emprunts;
    }
}
