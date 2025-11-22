package org.example.dao;

import org.example.DBconnection;
import org.example.model.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDAO {
    private Connection con;
    public AuthDAO() {
        con = DBconnection.getInstance().getConnection();
    }
    public boolean AuthenticateAdmin(Admin admin) {
        String sql = "SELECT * FROM admin WHERE username='"+admin.getName()+"' AND password='"+admin.getPassword()+"' ";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        }catch (SQLException e){
            System.err.println("echec de la connexion" + e.getMessage());
            return false;
        }
    }
}
