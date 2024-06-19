package view;

import java.io.FileInputStream;

import controller.communesController;
import controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeView {

    private GridPane homePane;
    private ImageView imageView;

    // User Management fields
    private TextField tfLoginCreate;
    private TextField tfPasswordCreate;
    private TextField tfLoginUpdate;
    private TextField tfPasswordUpdate;
    private TextField tfLoginDelete;
    private UserController userController;

    public HomeView(communesController controller) {
        this.homePane = new GridPane();
        this.userController = new UserController();

        // Ajouter une image
        imageView = null;
        try {
            imageView = new ImageView(new Image(new FileInputStream("../src/assets/ImageAcceuil.jpg")));
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(300);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ajouter du texte descriptif
        Label descriptionLabel = new Label("Cette application vous permet de rechercher des informations sur les communes. Utilisez le menu à gauche pour naviguer.");
        descriptionLabel.setFont(controller.getFONT());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(controller.getINSETS());

        // Organiser les éléments dans un VBox
        VBox contentBox = new VBox(10, imageView, descriptionLabel);
        contentBox.setPadding(controller.getINSETS());
        contentBox.setStyle("-fx-alignment: center;");

        // Ajouter le VBox au GridPane
        homePane.add(contentBox, 0, 0);
        homePane.setPadding(controller.getINSETS());
        homePane.setStyle("-fx-alignment: center;");

        // Add User Management UI
        addUserManagementUI(controller);
    }

    private void addUserManagementUI(communesController controller) {
        GridPane userGrid = new GridPane();
        userGrid.setHgap(10);
        userGrid.setVgap(10);
        userGrid.setPadding(new Insets(10, 10, 10, 10));

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
        userGrid.add(lblCreate, 0, 0);
        userGrid.add(lblLoginCreate, 0, 1);
        userGrid.add(tfLoginCreate, 1, 1);
        userGrid.add(lblPasswordCreate, 0, 2);
        userGrid.add(tfPasswordCreate, 1, 2);
        userGrid.add(btnCreate, 1, 3);

        userGrid.add(lblUpdate, 0, 4);
        userGrid.add(lblLoginUpdate, 0, 5);
        userGrid.add(tfLoginUpdate, 1, 5);
        userGrid.add(lblPasswordUpdate, 0, 6);
        userGrid.add(tfPasswordUpdate, 1, 6);
        userGrid.add(btnUpdate, 1, 7);

        userGrid.add(lblDelete, 0, 8);
        userGrid.add(lblLoginDelete, 0, 9);
        userGrid.add(tfLoginDelete, 1, 9);
        userGrid.add(btnDelete, 1, 10);

        homePane.add(userGrid, 0, 1);
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
        return homePane;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
