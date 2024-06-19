package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import exception.InvalidAttributException;
import model.data.Commune;
import model.data.Departement;
import model.data.Gare;

public class CommuneDAO extends DAO<Commune, Integer, String> {

    private List<Commune> listCommunes;

    public CommuneDAO(){
        super();
        this.updateList();
    }

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
        this.listCommunes.add(commune);
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

    private void updateList(){
        this.listCommunes = new LinkedList<>();
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
                System.out.println("ledocument: "+rs.getInt("leDepartement"));
                System.out.println("Dep "+rs.getInt("leDepartement"));
                Departement leDepartement = depDAO.findByID(rs.getInt("leDepartement"), null);

                rsG = st.executeQuery("SELECT codeGare FROM Gare WHERE laCommune = " + idCommune);
                lesGares = new ArrayList<Gare>();
                GareDAO gareDAO = new GareDAO();
                while (rsG.next()){
                    lesGares.add(gareDAO.findByID(rsG.getInt("codeGare"), null));
                }
                 System.out.println(lesGares.toString());
                try {
                    System.out.println(leDepartement+" "+ lesGares+" "+  idCommune+" "+  nomCommune);
                    listCommunes.add(new Commune(leDepartement, lesGares, idCommune, nomCommune));
                } catch (InvalidAttributException e) {
                    System.out.println("Commune: "+e.getMessage());
                    e.printStackTrace();
                    break;
                }
            }
            for (Commune c : this.listCommunes){
                rsV = st.executeQuery("SELECT communeVoisine FROM Voisinage WHERE commune = " + c.getIdCommune());
                communesVoisines = new ArrayList<Commune>();
                while (rsV.next()) {
                    for (Commune commune : listCommunes){
                        if (commune.getIdCommune() == rsV.getInt("communeVoisine")){
                            communesVoisines.add(commune);
                        }
                    }
                }
                try {
                    c.setCommunesVoisines(communesVoisines);
                } catch (InvalidAttributException e) {
                    System.out.println("Commune: "+e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Commune> findAll(){
        return this.listCommunes;
    }

    public Commune findByID(Integer idCommune, String a) {
        Commune commune = null;

        for (Commune c : this.listCommunes){
            if (Integer.valueOf(c.getIdCommune()).equals(idCommune)){
                commune = c;
            }
        }
        
        return commune;
    }

    public Commune findByID(int idCommune, String a){
        return this.findByID(Integer.valueOf(idCommune), a);
    }

    public Commune findByName(String name){
        Commune ret = null;
        for (Commune c : this.listCommunes){
            if (c.getNomCommune().equalsIgnoreCase(name)) {
                ret = c;
            }
        }
        return ret;
    }
}
