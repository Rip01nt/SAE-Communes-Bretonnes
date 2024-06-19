package controller;

import javafx.scene.control.Alert;
import model.dao.UserDAO;
import model.data.User;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void createUser(String login, String password) {
        User user = new User(login, password);
        int result = userDAO.create(user);
        showAlert("Create User", result > 0 ? "User created successfully" : "Error creating user");
    }

    public void updateUser(String login, String password) {
        User user = new User(login, password);
        int result = userDAO.update(user);
        showAlert("Update User", result > 0 ? "User updated successfully" : "Error updating user");
    }

    public void deleteUser(String login) {
        User user = new User(login, "");
        int result = userDAO.delete(user);
        showAlert("Delete User", result > 0 ? "User deleted successfully" : "Error deleting user");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
