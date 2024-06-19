package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import exception.CommuneNotFoundException;
import exception.InvalidAttributException;
import model.data.Aeroport;
import model.data.Departement;

public class AeroportDAO extends DAO<Aeroport, String, String>{

    public int create(Aeroport aeroport) {
        int ret = -1;
        String query = "INSERT INTO Aeroport VALUES ('" + aeroport.getNom() + "','" + aeroport.getAdresse() + "'," + aeroport.getLeDepartement().getIdDepartement() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int update(Aeroport aeroport) {
        int ret = -1;
        String query = "UPDATE Aeroport SET nom = '" + aeroport.getNom() + "', adresse = '" + aeroport.getAdresse() + "', leDepartement = " + aeroport.getLeDepartement().getIdDepartement() + " WHERE nom = '" + aeroport.getNom() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int delete(Aeroport aeroport) {
        int ret = -1;
        String query = "DELETE FROM Aeroport WHERE nom = '" + aeroport.getNom() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
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
                try {
                    ret.add(new Aeroport(leDepartement, nom, adresse));
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                } catch (CommuneNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Aeroport findByID(String nom, String a){
        Aeroport aeroport = null;
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM Aeroport WHERE nom = '?'")) {
            st.setString(1, nom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String n = rs.getString("nom");
                String adresse = rs.getString("adresse");
                DepartementDAO depDAO = new DepartementDAO();
                Departement d = depDAO.findByID(rs.getInt("leDepartement"), null);
                try {
                    aeroport = new Aeroport(d, n, adresse);
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                } catch (CommuneNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return aeroport;
    }

    public ArrayList<Aeroport> findByDep(int idDep){
        ArrayList<Aeroport> ret = new ArrayList<Aeroport>();
        Aeroport aero;
        try (Connection con = this.getConnection(); Statement st = con.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM Aeroport WHERE leDepartement = " + idDep);
            while (rs.next()){
                aero = new Aeroport();
                aero.setNom(rs.getString("nom"));
                aero.setAdresse(rs.getString("adresse"));
                ret.add(aero);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (InvalidAttributException e){
            e.printStackTrace();
        }
        return ret;
    }
}
