package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import exception.InvalidAttributException;
import model.data.Commune;
import model.data.Departement;
import model.data.Gare;

public class CommuneDAO extends DAO<Commune, Integer, String>{

    public int create(Commune commune) {
        int ret = -1;
        String query = "INSERT INTO Commune VALUES (" + commune.getIdCommune() + ",'" + commune.getNomCommune() + "'," + commune.getLeDepartement().getIdDepartement() + ")";
        for (Commune c : commune.getCommunesVoisines()){
            query += "; INSERT INTO Voisinage VALUES (" + commune.getIdCommune() + "," + c.getIdCommune() + ")";
        }
        if(commune.getCommunesVoisines().size() != 0 ){
            query += ";";
        }
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int update(Commune commune) {
        int ret = -1;
        String query = "UPDATE Commune SET idCommune = " + commune.getIdCommune() + ", nomCommune = '" + commune.getNomCommune() + "', leDepartement = " + commune.getLeDepartement().getIdDepartement() + " WHERE idCommune = " + commune.getIdCommune() + "; DELETE FROM Voisinage WHERE commune = " + commune.getIdCommune() + ";";
        for (Commune c : commune.getCommunesVoisines()){
            query += " INSERT INTO Voisinage VALUES (" + commune.getIdCommune() + "," + c.getIdCommune() + ");";
        }
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret= st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int delete(Commune commune) {
        int ret = -1;
        String query = "DELETE FROM Commune WHERE idCommune = " + commune.getIdCommune();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public List<Commune> findAll(){
        List<Commune> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Commune");
            ResultSet rsG;
            ResultSet rsV;
            ArrayList<Gare> lesGares;
            ArrayList<Commune> communesVoisines;
            while (rs.next()) {
                int idCommune = rs.getInt("idCommune");
                String nomCommune = rs.getString("nomCommune");
                DepartementDAO depDAO = new DepartementDAO();
                Departement leDepartement = depDAO.findByID(rs.getInt("leDepartement"), null);

                rsG = st.executeQuery("SELECT codeGare FROM Gare WHERE laCommune = " + idCommune);
                lesGares = new ArrayList<Gare>();
                GareDAO gareDAO = new GareDAO();
                while (rsG.next()){
                    lesGares.add(gareDAO.findByID(rs.getInt("codeGare"), null));
                }

                rsV = st.executeQuery("SELECT communeVoisine FROM Voisinage WHERE commune = " + idCommune);
                communesVoisines = new ArrayList<Commune>();
                CommuneDAO communeDAO = new CommuneDAO();
                while (rsV.next()){
                    communesVoisines.add(communeDAO.findByID(rs.getInt("communeVoisine"), null));
                }
                try {
                    ret.add(new Commune(leDepartement, lesGares, communesVoisines, idCommune, nomCommune));
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Commune findByID(Integer idCommune, String a) {
        Commune commune = null;
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM Commune WHERE idCommune = ?")) {
            st.setInt(1, idCommune.intValue());
            ResultSet rs = st.executeQuery();
            ResultSet rsG;
            ResultSet rsV;
            ArrayList<Gare> lesGares;
            ArrayList<Commune> communesVoisines;
            while (rs.next()) {
                int id = rs.getInt("idCommune");
                String nomCommune = rs.getString("nomCommune");
                DepartementDAO depDAO = new DepartementDAO();
                Departement leDepartement = depDAO.findByID(rs.getInt("leDepartement"), null);

                rsG = st.executeQuery("SELECT codeGare FROM Gare WHERE laCommune = " + id);
                lesGares = new ArrayList<Gare>();
                GareDAO gareDAO = new GareDAO();
                while (rsG.next()) {
                    lesGares.add(gareDAO.findByID(rs.getInt("codeGare"), null));
                }

                rsV = st.executeQuery("SELECT communeVoisine FROM Voisinage WHERE commune = " + id);
                communesVoisines = new ArrayList<Commune>();
                CommuneDAO communeDAO = new CommuneDAO();
                while (rsV.next()) {
                    communesVoisines.add(communeDAO.findByID(rs.getInt("communeVoisine"), null));
                }

                try {
                    commune = new Commune(leDepartement, lesGares, communesVoisines, id, nomCommune);
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return commune;
    }

    public Commune findByID(int idCommune, String a){
        return this.findByID(Integer.valueOf(idCommune), a);
    }
}
