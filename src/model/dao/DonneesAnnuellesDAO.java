package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.*;

public class DonneesAnnuellesDAO extends DAO<DonneesAnnuelles, Integer, Integer>{

    public int create(DonneesAnnuelles donneesAnnuelles){
        String query = "INSERT INTO DonneesAnnuelles VALUES (" + donneesAnnuelles.getLAnnee().getANNEE() + "," + donneesAnnuelles.getLaCommune().getIdCommune() + "," + donneesAnnuelles.getNbMaison() + "," + donneesAnnuelles.getNbAppart() + "," + donneesAnnuelles.getPrixMoyen() + "," + donneesAnnuelles.getPrixM2Moyen() + "," + donneesAnnuelles.getSurfaceMoy() + "," + donneesAnnuelles.getDepensesCultutrellesTotales() + "," + donneesAnnuelles.getBudgetTotal() + "," + donneesAnnuelles.getPopulation() + ")";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int update(DonneesAnnuelles donneesAnnuelles) {
        String query = "UPDATE DonneesAnnuelles SET lAnnee = " + donneesAnnuelles.getLAnnee().getANNEE() + ", laCommune = " + donneesAnnuelles.getLaCommune().getIdCommune() + ", nbMaison = " + donneesAnnuelles.getNbMaison() + ", nbAppart = " + donneesAnnuelles.getNbAppart() + ", prixMoyen = " + donneesAnnuelles.getPrixMoyen() + ", prixM2Moyen = " + donneesAnnuelles.getPrixM2Moyen() + ", surfaceMoy = " + donneesAnnuelles.getSurfaceMoy() + ", depensesCulturellesTotales = " + donneesAnnuelles.getDepensesCultutrellesTotales() + ", budgetTotal = " + donneesAnnuelles.getBudgetTotal() + ", population = " + donneesAnnuelles.getPopulation() +  " WHERE lAnnee = " + donneesAnnuelles.getLAnnee().getANNEE() + " AND WHERE laCommune = " + donneesAnnuelles.getLaCommune().getIdCommune();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int delete(DonneesAnnuelles donneesAnnuelles) {
        String query = "DELETE FROM DonneesAnnuelles WHERE lAnnee = " + donneesAnnuelles.getLAnnee().getANNEE() + ", AND WHERE laCommune = " + donneesAnnuelles.getLaCommune().getIdCommune();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public List<DonneesAnnuelles> findAll(){
        List<DonneesAnnuelles> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM DonneesAnnuelles");
            while (rs.next()) {
                AnneeDAO anneeDAO = new AnneeDAO();
                Annee lAnnee = anneeDAO.findByID(rs.getInt("lAnnee"), null);
                CommuneDAO communeDAO = new CommuneDAO();
                Commune laCommune = communeDAO.findByID(rs.getInt("laCommune"), null);
                int nbMaison = rs.getInt("nbMaison");
                int nbAppart = rs.getInt("nbAppart");
                int prixMoyen = rs.getInt("prixMoyen");
                int prixM2Moyen = rs.getInt("prixM2Moyen");
                int surfaceMoy = rs.getInt("surfaceMoy");
                int depensesCulturellesTotales = rs.getInt("depensesCulturellesTotales");
                int budgetTotal = rs.getInt("budgetTotal");
                int population = rs.getInt("population");
                ret.add(new DonneesAnnuelles(lAnnee, laCommune, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depensesCulturellesTotales, budgetTotal, population));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public DonneesAnnuelles findByID(Integer lAnnee, Integer laCommune){
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM DonneesAnnuelles WHERE lAnnee = ? AND WHERE laCommune = ?")) {
            st.setInt(1, lAnnee.intValue());
            st.setInt(2, laCommune.intValue());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AnneeDAO anneeDAO = new AnneeDAO();
                Annee a = anneeDAO.findByID(rs.getInt("lAnnee"), null);
                CommuneDAO communeDAO = new CommuneDAO();
                Commune c = communeDAO.findByID(rs.getInt("laCommune"), null);
                int nbMaison = rs.getInt("nbMaison");
                int nbAppart = rs.getInt("nbAppart");
                int prixMoyen = rs.getInt("prixMoyen");
                int prixM2Moyen = rs.getInt("prixM2Moyen");
                int surfaceMoy = rs.getInt("surfaceMoy");
                int depensesCulturellesTotales = rs.getInt("depensesCulturellesTotales");
                int budgetTotal = rs.getInt("budgetTotal");
                int population = rs.getInt("population");
                return new DonneesAnnuelles(a, c, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depensesCulturellesTotales, budgetTotal, population);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DonneesAnnuelles findByID(int lAnnee, int laCommune){
        return this.findByID(new Integer(lAnnee), new Integer(laCommune));
    }
}
