package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.Aeroport;

public class AeroportDAO extends DAO<Aeroport, String>{

    public int create(Aeroport aeroport){
        String query = "INSERT INTO Aeroport VALUES ('" + aeroport.getNom() + "','" + aeroport.getAdresse() + "'," + aeroport.getLeDepartement().getIdDepartement() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int update(Aeroport aeroport) {
        String query = "UPDATE Aeroport SET nom = '" + aeroport.getNom() + "', adresse = '" + aeroport.getAdresse() + "', leDepartement = " + aeroport.getLeDepartement().getIdDepartement() + " WHERE nom = '" + aeroport.getNom() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int delete(Aeroport aeroport) {
        String query = "DELETE FROM Aeroport WHERE nom = '" + aeroport.getNom() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Aeroport> findAll(){
        List<Aeroport> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Aeroport");
            while (rs.next()) {
                String  = rs.getString
            }
        }
    }
    
}
