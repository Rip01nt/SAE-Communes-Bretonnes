
package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T,P,V> {
    private static String driverClassName = "org.mariadb.jdbc.Driver";
    private static String url = "jdbc:mariadb://localhost:3306/bdSAE";
    private static String username = "root";
    private static String password = "root";

    protected Connection getConnection() throws SQLException {
        Connection con = null;
        // Charger la classe du pilote
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // Obtenir la connection
        con = DriverManager.getConnection(url , username , password);
        return con;
    }

    public abstract List <T> findAll ();
    public abstract T findByID(P id, V id2);
    public abstract int update(T element);
    public abstract int delete(T element);
    public abstract int create(T element);
    
}
