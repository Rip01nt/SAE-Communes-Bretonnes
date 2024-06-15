package view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    private static final Label TITLE_LABEL = new Label(TITLE);
    private static final int IMG_SIZE = 80;
    private static final Font TITLE_FONT = new Font("Arial", IMG_SIZE/2);
    private static final Font FONT = new Font("Arial", IMG_SIZE/4);
    private static final Insets INSETS = new Insets(IMG_SIZE/8, IMG_SIZE/8, IMG_SIZE/8, IMG_SIZE/8);
    //private static final String FXML = "/ressource/communes.fxml";
    //private static final String CSS = "/ressource/communes.css";
    private Stage primaryStage;
    private Scene scene;
    private BorderPane root;
    private BorderPane titleBar;
    private StackPane center;
    private VBox menu;
    private Button menuButton;
    private Button userButton;
    private Button searchButton;
    private Button homeButton;
    private Button scoreboardButton;
    private Button settingsButton;
    private Button exitButton;
    private Button[] menuButtons;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public void start(Stage primaryStage) throws Exception {
        communesController controller = new communesController(this);
        this.primaryStage = primaryStage;
        // FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML));
        // Parent parRoot = loader.load();
        try {
        root = new BorderPane();
        userButton = new Button();
        this.setMenuButtonsImage(userButton, new FileInputStream("../src/assets/user.png"));
        searchButton = new Button();
        this.setMenuButtonsImage(searchButton, new FileInputStream("../src/assets/search.png"));
        homeButton = new Button();
        this.setMenuButtonsImage(homeButton, new FileInputStream("../src/assets/home.png"));
        scoreboardButton = new Button();
        this.setMenuButtonsImage(scoreboardButton, new FileInputStream("../src/assets/scoreboard.png"));
        settingsButton = new Button();
        this.setMenuButtonsImage(settingsButton, new FileInputStream("../src/assets/settings.png"));
        exitButton = new Button();
        this.setMenuButtonsImage(exitButton, new FileInputStream("../src/assets/exit.png"));
        } catch (NullPointerException e) {
            System.out.println("Error: "+e.getMessage());
        }
        exitButton.textFillProperty().set(javafx.scene.paint.Color.RED);
        menu = new VBox(userButton, searchButton, homeButton, scoreboardButton, settingsButton, exitButton);
        menuButton = new Button("≡");
        menuButton.setFont(TITLE_FONT);
        titleBar = new BorderPane();
        TITLE_LABEL.setFont(TITLE_FONT);
        titleBar.setCenter(TITLE_LABEL);
        titleBar.setLeft(menuButton);
        ImageView logo = new ImageView(new Image(new FileInputStream("../src/assets/logo_dark.png")));
        logo.setFitHeight(IMG_SIZE*1.25);
        logo.setFitWidth(IMG_SIZE*1.25);
        titleBar.setRight(logo);

        root.setLeft(menu);
        root.setTop(titleBar);
        root.setStyle("-fx-background-color: #CCCCFF;");
        titleBar.setStyle("-fx-background-color: #FFFFFF;");
        menu.setVisible(false);
        root.getChildren().remove(menu);
        controller.onReady();
        menuButtons = new Button[]{userButton, searchButton, homeButton, scoreboardButton, settingsButton, exitButton};
        for (Button button : menuButtons) {
            button.setPrefWidth(150);
            button.setPrefHeight(Integer.MAX_VALUE);
        }
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        root.setCenter(new Hyperlink("https://www.youtube.com/watch?v=DmH6YPWhaDY", new Label("Don't click here -->")));
        this.usernameField = new TextField();
        this.passwordField = new PasswordField();
        this.center = new StackPane(root, this.authPane());
        this.scene = new Scene(center, 720, 720);
        this.primaryStage.setMinHeight(IMG_SIZE*9);
        this.primaryStage.setMinWidth(IMG_SIZE*7);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public void showMenu() {
        menu.setVisible(true);
        root.setLeft(menu);
    }

    public void hideMenu() {
        menu.setVisible(false);
        root.getChildren().remove(menu);
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public VBox getMenu() {
        return menu;
    }

    public BorderPane getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public void exit() {
        primaryStage.close();
    }

    public Button[] getMenuButtons() {
        return menuButtons;
    }

    private void setMenuButtonsImage(Button button, FileInputStream FIS) {
        Image image = new Image(FIS);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(IMG_SIZE);
        imageView.setFitWidth(IMG_SIZE);
        button.setGraphic(imageView);
        button.textFillProperty().set(javafx.scene.paint.Color.BLUE);
    }

    private GridPane authPane() {
        GridPane authPane = new GridPane();
        ImageView logo = null;
        try {
            logo = new ImageView(new Image(new FileInputStream("../src/assets/logo_light.png")));
            logo.setFitHeight(IMG_SIZE*1.75);
            logo.setFitWidth(IMG_SIZE*1.75);            
        } catch (Exception e) {}
        Label errLabel = new Label("Wrong credentials");
        usernameField = new TextField();
        usernameField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        loginButton = new Button("Login");
        GridPane.setHalignment(logo, HPos.CENTER);
        GridPane.setHalignment(errLabel, HPos.CENTER);
        GridPane.setHalignment(loginButton, HPos.CENTER);
        errLabel.setFont(FONT);
        usernameField.setFont(FONT);
        passwordField.setFont(FONT);
        loginButton.setFont(FONT);
        errLabel.setTextFill(javafx.scene.paint.Color.RED);
        authPane.add(logo, 0, 0);
        GridPane.setMargin(logo, new Insets(20));
        authPane.add(usernameField, 0, 2);
        GridPane.setMargin(usernameField, INSETS);
        authPane.add(passwordField, 0, 3);
        GridPane.setMargin(passwordField, INSETS);
        authPane.add(loginButton, 0, 4);
        GridPane.setMargin(loginButton, INSETS);


        loginButton.setOnAction(e -> {
            if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                authPane.setVisible(false);
                root.setVisible(true);
            } else {
                authPane.add(errLabel, 0, 1);
                GridPane.setMargin(errLabel, INSETS);
            }
        });

        authPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.75);");
        authPane.setAlignment(Pos.CENTER);

        return authPane;
    }
}
