package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import model.data.*;

public class UserDAO extends DAO<User, String, String>{

    public int create(User user){
        int ret = -1;
        String query = "INSERT INTO User VALUES ('" + user.getLogin() + "','" + user.getPassword() + "')";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int update(User user) {
        int ret = -1;
        String query = "UPDATE User SET login = '" + user.getLogin() + "', password = '" + user.getPassword() + "' WHERE login = '" + user.getLogin() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public int delete(User user) {
        int ret = -1;
        String query = "DELETE FROM User WHERE login = '" + user.getLogin() + "'";
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ret = st.executeUpdate(query);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public List<User> findAll(){
        List<User> ret = new LinkedList<>();
        try (Connection con = this.getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM User");
            while (rs.next()) {
                String login = rs.getString("login");
                String password = rs.getString("password");
                ret.add(new User(login, password));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public User findByID(String login, String password){
        User user = null;
        try (Connection con = this.getConnection(); PreparedStatement st = con.prepareStatement("SELECT * FROM User WHERE login = ? AND password = ?")) {
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String l = rs.getString("login");
                String p = rs.getString("password");
                user = new User(l, p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }
}
