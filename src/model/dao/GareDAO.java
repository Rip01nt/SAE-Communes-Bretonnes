package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.*;

public class GareDAO extends DAO<Gare, Integer, String>{

    public int create(Gare gare){
        String query = "INSERT INTO Gare VALUES (" + gare.getCodeGare() + ",'" + gare.getNomGare() + "'," + gare.getEstFret() + "," + gare.getEstVoyageur() + "," + gare.getLaCommune().getIdCommune() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int update(Gare gare) {
        String query = "UPDATE Gare SET codeGare = " + gare.getCodeGare() + ", nomGare = '" + gare.getNomGare() + "', estFret = " + gare.getEstFret() + ", estVoyageur = " + gare.getEstVoyageur() + ", laCommune = " + gare.getLaCommune().getIdCommune() + " WHERE codeGare = " + gare.getCodeGare();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int delete(Gare gare) {
        String query = "DELETE FROM Gare WHERE codeGare = " + gare.getClass();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Gare> findAll(){
        List<Gare> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Gare");
            while (rs.next()) {
                CommuneDAO communeDAO = new CommuneDAO();
                Commune laCommune = communeDAO.findByID(rs.getInt("laCommune"), null); 
                int codeGare = rs.getInt("codeGare");
                String nomGare = rs.getString("nomGare");
                boolean estFret = rs.getBoolean("estFret");
                boolean estVoyageur = rs.getBoolean("estVoyageur");
                ret.add(new Gare(laCommune, codeGare, nomGare, estFret, estVoyageur));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Gare findByID(Integer codeGare, String a){
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM Gare WHERE codeGare = ?")) {
            st.setInt(1, codeGare.intValue());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CommuneDAO communeDAO = new CommuneDAO();
                Commune laCommune = communeDAO.findByID(rs.getInt("laCommune"), null); 
                int c = rs.getInt("codeGare");
                String nomGare = rs.getString("nomGare");
                boolean estFret = rs.getBoolean("estFret");
                boolean estVoyageur = rs.getBoolean("estVoyageur");
                return new Gare(laCommune, c, nomGare, estFret, estVoyageur);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Gare findByID(int codeGare, String a){
        return this.findByID(new Integer(codeGare), a);
    }

}
