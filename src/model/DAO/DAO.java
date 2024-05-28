
package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO <T> {
    private static String driverClassName = "com.mysql.cj.jdbc.Driver ";
    private static String url = "dbc:mysql://localhost:3306/bdSAE";
    private static String username = "thel9";
    private static String password = "motdepasse";
    private Connection conn = null;
    protected void openConnection () throws SQLException {
        if(this.conn == null){
            // Charger la classe du pilote
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace ();
                this.conn = null;
            }
            // Obtenir la connection
            this.conn = DriverManager.getConnection(url , username , password);
        }
    }
    protected void closeConnection(){
        if (this.conn != null){
            this.conn.close();
            this.conn = null;
        }
    }
    public abstract List <T> findAll ();
    public abstract T findByID(Long id);
    public abstract int update(T element);
    public abstract int delete(T element);
    public abstract int create(T element);
    
}