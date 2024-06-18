package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import exception.InvalidAttributException;
import model.data.Departement;
import model.data.Aeroport;
import model.data.Commune;

public class DepartementDAO extends DAO<Departement, Integer, String>{

    public int create(Departement departement){
        String query = "INSERT INTO Departement VALUES (" + departement.getIdDepartement() + ",'" + departement.getNomDepartement() + "'," + departement.getInvestissementCulturel2019() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int update(Departement departement) {
        String query = "UPDATE Departement SET idDep = " + departement.getIdDepartement() + ", nomDep = '" + departement.getNomDepartement() + "', investissementCulturel2019 = " + departement.getInvestissementCulturel2019() + " WHERE idDep = " + departement.getIdDepartement();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int delete(Departement departement) {
        String query = "DELETE FROM Departement WHERE idDep = " + departement.getIdDepartement();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<Departement> findAll(){
        List<Departement> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Departement");
            ResultSet rsA;
            ResultSet rsC;
            ArrayList<Aeroport> lesAeroport;
            ArrayList<Commune> lesCommunes;
            while (rs.next()) {
                int idDep = rs.getInt("idDep");
                String nomDepartement = rs.getString("nomDepartement");
                int investissementCulturel2019 = rs.getInt("investissementCulturel2019");

                rsA = st.executeQuery("SELECT nom FROM Aeroport WHERE leDepartement = " + idDep);
                lesAeroport = new ArrayList<Aeroport>();
                AeroportDAO aeroDAO = new AeroportDAO();
                while (rsA.next()){
                    lesAeroport.add(aeroDAO.findByID(rs.getString("nom"), null));
                }

                rsC = st.executeQuery("SELECT idCommune FROM Commune WHERE leDepartement = " + idDep);
                lesCommunes = new ArrayList<Commune>();
                CommuneDAO communeDAO = new CommuneDAO();
                while (rsC.next()){
                    lesCommunes.add(communeDAO.findByID(rs.getInt("idCommune"), null));
                }
                try {
                    ret.add(new Departement(lesAeroport, lesCommunes, idDep, nomDepartement, investissementCulturel2019));
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public Departement findByID(Integer idDep, String a){
        Departement departement = null;
        try {
            Connection con = this.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Departement WHERE idDep = '?");
            st.setInt(1, idDep.intValue());
            ResultSet rs = st.executeQuery();
            ResultSet rsA;
            ResultSet rsC;
            ArrayList<Aeroport> lesAeroport;
            ArrayList<Commune> lesCommunes;
            while (rs.next()) {
                int id = rs.getInt("idDep");
                String nomDepartement = rs.getString("nomDepartement");
                int investissementCulturel2019 = rs.getInt("investissementCulturel2019");

                rsA = st.executeQuery("SELECT nom FROM Aeroport WHERE leDepartement = " + id);
                lesAeroport = new ArrayList<Aeroport>();
                AeroportDAO aeroDAO = new AeroportDAO();
                while (rsA.next()){
                    lesAeroport.add(aeroDAO.findByID(rs.getString("nom"), null));
                }

                rsC = st.executeQuery("SELECT idCommune FROM Commune WHERE leDepartement = " + id);
                lesCommunes = new ArrayList<Commune>();
                CommuneDAO communeDAO = new CommuneDAO();
                while (rsC.next()){
                    lesCommunes.add(communeDAO.findByID(rs.getInt("idCommune"), null));
                }
                try {
                departement = new Departement(lesAeroport, lesCommunes, id, nomDepartement, investissementCulturel2019);
                } catch (InvalidAttributException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return departement;
    }

    public Departement findByID(int idDep, String a){
        return this.findByID(Integer.valueOf(idDep), a);
    }

}
