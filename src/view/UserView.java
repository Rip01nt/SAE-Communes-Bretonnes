package view;

import controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class UserView {

    private GridPane userPane;
    private TextField tfLoginCreate;
    private TextField tfPasswordCreate;
    private TextField tfLoginUpdate;
    private TextField tfPasswordUpdate;
    private TextField tfLoginDelete;
    private UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
        this.userPane = new GridPane();
        this.userPane.setHgap(10);
        this.userPane.setVgap(10);
        this.userPane.setPadding(new Insets(10, 10, 10, 10));

        // Create user section
        Label lblCreate = new Label("Create User");
        Label lblLoginCreate = new Label("Login:");
        tfLoginCreate = new TextField();
        Label lblPasswordCreate = new Label("Password:");
        tfPasswordCreate = new TextField();
        Button btnCreate = new Button("Create");
        btnCreate.setOnAction(e -> createUser());

        // Update user section
        Label lblUpdate = new Label("Update User");
        Label lblLoginUpdate = new Label("Login:");
        tfLoginUpdate = new TextField();
        Label lblPasswordUpdate = new Label("New Password:");
        tfPasswordUpdate = new TextField();
        Button btnUpdate = new Button("Update");
        btnUpdate.setOnAction(e -> updateUser());

        // Delete user section
        Label lblDelete = new Label("Delete User");
        Label lblLoginDelete = new Label("Login:");
        tfLoginDelete = new TextField();
        Button btnDelete = new Button("Delete");
        btnDelete.setOnAction(e -> deleteUser());

        // Add nodes to the grid
        userPane.add(lblCreate, 0, 0);
        userPane.add(lblLoginCreate, 0, 1);
        userPane.add(tfLoginCreate, 1, 1);
        userPane.add(lblPasswordCreate, 0, 2);
        userPane.add(tfPasswordCreate, 1, 2);
        userPane.add(btnCreate, 1, 3);

        userPane.add(lblUpdate, 0, 4);
        userPane.add(lblLoginUpdate, 0, 5);
        userPane.add(tfLoginUpdate, 1, 5);
        userPane.add(lblPasswordUpdate, 0, 6);
        userPane.add(tfPasswordUpdate, 1, 6);
        userPane.add(btnUpdate, 1, 7);

        userPane.add(lblDelete, 0, 8);
        userPane.add(lblLoginDelete, 0, 9);
        userPane.add(tfLoginDelete, 1, 9);
        userPane.add(btnDelete, 1, 10);
    }

    private void createUser() {
        String login = tfLoginCreate.getText();
        String password = tfPasswordCreate.getText();
        userController.createUser(login, password);
    }

    private void updateUser() {
        String login = tfLoginUpdate.getText();
        String password = tfPasswordUpdate.getText();
        userController.updateUser(login, password);
    }

    private void deleteUser() {
        String login = tfLoginDelete.getText();
        userController.deleteUser(login);
    }

    public GridPane getPane() {
        return userPane;
    }
}
