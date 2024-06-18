package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.*;

public class AnneeDAO extends DAO<Annee, Integer, String>{
    public int create(Annee annee){
        String query = "INSERT INTO Annee VALUES (" + annee.getANNEE() + "," + annee.getTauxInflation() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int update(Annee annee) {
        String query = "UPDATE Annee SET annee = " + annee.getANNEE() + ", tauxInflation = " + annee.getTauxInflation() + " WHERE annee = " + annee.getANNEE();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int delete(Annee annee) {
        String query = "DELETE FROM Annee WHERE annee = " + annee.getANNEE();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Annee> findAll(){
        List<Annee> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Annee");
            while (rs.next()) {
                int annee = rs.getInt("annee");
                double tauxInflation = rs.getFloat("tauxInflation");
                ret.add(new Annee(annee, tauxInflation));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Annee findByID(Integer annee, String a){
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM Annee WHERE nom = ?")) {
            st.setInt(1, annee);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int a = rs.getInt("annee");
                double tauxInflation = rs.getFloat("tauxInflation");
                return new Annee(a, tauxInflation);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Annee findByID(int annee, String a){
        return this.findByID(new Integer(annee), a);
    }
}
