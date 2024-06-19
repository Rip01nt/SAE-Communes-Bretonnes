package test.model;
import model.dao.*;

public class ScenarioDAO {

    public static void main(String[] args){
        CommuneDAO communeDAO = new CommuneDAO();
        System.out.println(communeDAO.findByName("Vannes"));
    }
}
