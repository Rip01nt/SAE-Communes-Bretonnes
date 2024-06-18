package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.*;

public class AeroportDAO extends DAO<Aeroport, String, String>{

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
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                DepartementDAO depDAO = new DepartementDAO();
                Departement leDepartement = depDAO.findByID(rs.getInt("leDepartement"), null);
                ret.add(new Aeroport(leDepartement, nom, adresse));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Aeroport findByID(String nom, String a){
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM Aeroport WHERE nom = '?'")) {
            st.setString(1, nom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String n = rs.getString("nom");
                String adresse = rs.getString("adresse");
                DepartementDAO depDAO = new DepartementDAO();
                Departement d = depDAO.findByID(rs.getInt("leDepartement"), null);
                return new Aeroport(d, n, adresse);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
