package view;

import java.io.FileInputStream;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class AuthView {

    private GridPane authPane;
    private ImageView logo;
    private Label errLabel;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;


    public GridPane getPane(communesController controller) {
        authPane = new GridPane();
        logo = null;
        try {
            logo = new ImageView(new Image(new FileInputStream("../src/assets/logo_light.png")));
            logo.setFitHeight(controller.getImgSize()*1.75);
            logo.setFitWidth(controller.getImgSize()*1.75);
        } catch (Exception e) {}
        errLabel = new Label("Wrong credentials");
        this.usernameField = new TextField();
        usernameField.setPromptText("Username");
        this.passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        loginButton = new Button("Login");
        GridPane.setHalignment(logo, HPos.CENTER);
        GridPane.setHalignment(errLabel, HPos.CENTER);
        GridPane.setHalignment(loginButton, HPos.CENTER);
        errLabel.setFont(controller.getFONT());
        usernameField.setFont(controller.getFONT());
        passwordField.setFont(controller.getFONT());
        loginButton.setFont(controller.getFONT());
        errLabel.setTextFill(javafx.scene.paint.Color.RED);
        authPane.add(logo, 0, 0);
        GridPane.setMargin(logo, new Insets(controller.getImgSize()/5));
        authPane.add(usernameField, 0, 2);
        GridPane.setMargin(usernameField, controller.getINSETS());
        authPane.add(passwordField, 0, 3);
        GridPane.setMargin(passwordField, controller.getINSETS());
        authPane.add(loginButton, 0, 4);
        GridPane.setMargin(loginButton, controller.getINSETS());

        authPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
        authPane.setAlignment(Pos.CENTER);

        return authPane;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getErrLabel() {
        return errLabel;
    }

    public GridPane getAuthPane() {
        return authPane;
    }


}
