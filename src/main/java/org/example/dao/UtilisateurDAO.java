package org.example.dao;
import org.example.DBconnection;
import org.example.model.Livre;
import org.example.model.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    private Connection con;
    public UtilisateurDAO(){
        con = DBconnection.getInstance().getConnection();
    }

    public void ajouterUtilisateur(Utilisateur user){
        String sql = "INSERT INTO users(nom, prenom) VALUES (?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void supprimreUtilisateur(int utilisateurId){
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, utilisateurId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifierUtilisateur(Utilisateur user){
        String sql = "UPDATE users SET nom = ?, prenom = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Utilisateur> listerUtilisateur(){
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM utilisateur";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom")
                );
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
    public Utilisateur chercherUtilisateurParId(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        Utilisateur utilisateur = null;
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }


}
