package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import exception.InvalidAttributException;
import model.data.Commune;
import model.data.Gare;

public class CommuneDAO extends DAO<Commune, Integer, String> {

    private HashMap<Integer, Commune> mapCommune;

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
            this.mapCommune.put(Integer.valueOf(commune.getIdCommune()), commune);
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

    private void updateList(){
        this.mapCommune = new HashMap<Integer, Commune>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Commune C1, Commune C2, Voisinage WHERE C1.idCommune = commune AND C2.idCommune = communeVoisine");
            DepartementDAO depDAO = new DepartementDAO();
            GareDAO gareDAO = new GareDAO();
            while(rs.next()){
                Commune commune;
                Commune communeVoisine;
                if (!this.mapCommune.containsKey(Integer.valueOf(rs.getInt("C1.idCommune")))){
                    commune = new Commune();
                    commune.setIdCommune(rs.getInt("C1.idCommune"));
                    commune.setNomCommune(rs.getString("C1.nomCommune"));
                    commune.setLeDepartement(depDAO.findByID(rs.getInt("C1.leDepartement"), null));
                    commune.setLesGares(gareDAO.findByCommune(commune.getIdCommune()));
                    this.mapCommune.put(Integer.valueOf(commune.getIdCommune()), commune);      
                }else commune = this.mapCommune.get(Integer.valueOf(rs.getInt("C1.idCommune")));

                if (!this.mapCommune.containsKey(Integer.valueOf(rs.getInt("C2.idCommune")))){
                    communeVoisine = new Commune();
                    communeVoisine.setIdCommune(rs.getInt("C2.idCommune"));
                    communeVoisine.setNomCommune(rs.getString("C2.nomCommune"));
                    communeVoisine.setLeDepartement(depDAO.findByID(rs.getInt("C2.leDepartement"), null));
                    communeVoisine.setLesGares(gareDAO.findByCommune(communeVoisine.getIdCommune()));
                    this.mapCommune.put(Integer.valueOf(communeVoisine.getIdCommune()), communeVoisine); 
                }else communeVoisine = this.mapCommune.get(Integer.valueOf(rs.getInt("C2.idCommune")));

                commune.getCommunesVoisines().add(communeVoisine);
            }
            for (Commune c : this.mapCommune.values()){
                for (Gare g : c.getLesGares()){
                    g.setLaCommune(c);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAttributException e){
            e.printStackTrace();
        }
    }

    public List<Commune> findAll(){
        return new ArrayList<Commune>(this.mapCommune.values());
    }

    public Commune findByID(Integer idCommune, String a) {
        return this.mapCommune.get(idCommune);
    }

    public Commune findByID(int idCommune, String a){
        return this.findByID(Integer.valueOf(idCommune), a);
    }

    public Commune findByName(String name){
        Commune ret = null;
        ArrayList<Commune> listCommunes = new ArrayList<Commune>(this.mapCommune.values());
        for (Commune c : listCommunes){
            if (c.getNomCommune().equalsIgnoreCase(name)) {
                ret = c;
            }
        }
        return ret;
    }
}
