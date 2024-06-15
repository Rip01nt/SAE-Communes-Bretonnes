package view;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    private static final Label TITLE_LABEL = new Label(TITLE);
    private static final int IMG_SIZE = 80;
    private static final String FONT_NAME="Arial";
    private static final Font TITLE_FONT = new Font(FONT_NAME, IMG_SIZE/2);
    private static final Font FONT = new Font(FONT_NAME, IMG_SIZE/4);
    private static final Insets INSETS = new Insets(IMG_SIZE/10, IMG_SIZE/10, IMG_SIZE/10, IMG_SIZE/10);
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
        BorderPane.setMargin(menuButton, INSETS);
        ImageView logo = new ImageView(new Image(new FileInputStream("../src/assets/logo_dark.png")));
        logo.setFitHeight(IMG_SIZE*1.2);
        logo.setFitWidth(IMG_SIZE*1.2);
        BorderPane.setMargin(logo, INSETS);
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
            button.setPrefWidth(IMG_SIZE*1.2);
            button.setPrefHeight(Integer.MAX_VALUE);
            VBox.setMargin(button, new Insets(IMG_SIZE/10, IMG_SIZE/10, 0, IMG_SIZE/20));
        }
        VBox.setMargin(userButton, new Insets(IMG_SIZE/10, IMG_SIZE/10, 0, IMG_SIZE/20));
        VBox.setMargin(exitButton, new Insets(IMG_SIZE/10, IMG_SIZE/10, IMG_SIZE/10, IMG_SIZE/20));
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);

        root.setCenter(this.rickRoll());

        userButton.setOnAction(e -> {
            root.setCenter(this.userView());
        });

        searchButton.setOnAction(e -> {
            root.setCenter(this.searchView());
        });

        homeButton.setOnAction(e -> {
            root.setCenter(this.homeView());
        });

        scoreboardButton.setOnAction(e -> {
            root.setCenter(this.scoreboardView());
        });

        settingsButton.setOnAction(e -> {
            root.setCenter(this.settingsView());
        });
        logo.setOnMouseClicked(e -> {
            root.setCenter(this.rickRoll());
        });


        this.center = new StackPane(root, this.authPane());
        this.scene = new Scene(center, 720, 740);
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
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setFitHeight(IMG_SIZE);
        imageView.setFitWidth(IMG_SIZE);
        button.setGraphic(imageView);
        button.textFillProperty().set(javafx.scene.paint.Color.BLUE);
    }

    private MediaView rickRoll() {
        MediaPlayer mediaPlayer=null;
        MediaView mediaView=null;
        try {
            mediaPlayer = new MediaPlayer(new Media(new File("../src/assets/rick.mp4").toURI().toURL().toString()));
            mediaView = new MediaView(mediaPlayer);
        } catch (Exception e) {}
        mediaView.setFitHeight(IMG_SIZE*9);
        mediaView.setFitWidth(IMG_SIZE*7);
        mediaPlayer.play();
        return mediaView;
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
        this.usernameField = new TextField();
        usernameField.setPromptText("Username");
        this.passwordField = new PasswordField();
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

        authPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
        authPane.setAlignment(Pos.CENTER);

        return authPane;
    }

    private GridPane userView() {
        GridPane userPane = new GridPane();

        return userPane;
    }


    private GridPane homeView() {
        GridPane homePane = new GridPane();


        return homePane;
    }

    private GridPane searchView() {
        GridPane searchPane = new GridPane();

        return searchPane;
    }

    private GridPane scoreboardView() {
        GridPane scoreboardPane = new GridPane();

        return scoreboardPane;
    }

    private GridPane settingsView() {
        GridPane dataPane = new GridPane();

        Label labelCommunesVoisines = new Label("Nombre de communes voisines");

        Slider sliderCommunesVoisines = new Slider();
        sliderCommunesVoisines.setShowTickMarks(true);
        sliderCommunesVoisines.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(false);
        sliderCommunesVoisines.setMajorTickUnit(10);
        sliderCommunesVoisines.setBlockIncrement(1);

        Label labelVenteApart = new Label("Nombre d'appartements vendu par ans");

        Slider sliderVenteApart = new Slider();
        sliderVenteApart.setShowTickMarks(true);
        sliderVenteApart.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(true);
        sliderVenteApart.setMajorTickUnit(10);
        sliderVenteApart.setBlockIncrement(1);

        Label labelTailleMoyHabit = new Label("Taille moyenne des habitations");

        Slider sliderTailleMoyHabit = new Slider();
        sliderTailleMoyHabit.setShowTickMarks(true);
        sliderTailleMoyHabit.setShowTickLabels(true);
        sliderTailleMoyHabit.setMajorTickUnit(10);
        sliderTailleMoyHabit.setBlockIncrement(1);

        Label labelInflation = new Label("Taux inflation");

        Slider sliderInflation = new Slider();
        sliderInflation.setShowTickMarks(true);
        sliderInflation.setShowTickLabels(true);
        sliderInflation.setMajorTickUnit(10);
        sliderInflation.setBlockIncrement(1);

        Label labelInvCulture = new Label("Investissement culturel");

        Slider sliderInvCulture = new Slider();
        sliderInvCulture.setShowTickMarks(true);
        sliderInvCulture.setShowTickLabels(true);
        sliderInvCulture.setMajorTickUnit(10);
        sliderInvCulture.setBlockIncrement(1);

        Label labelPrixMoyM2Ans = new Label("Prix moyen du m² par ans");

        Slider sliderPrixMoyM2Ans = new Slider();
        sliderPrixMoyM2Ans.setShowTickMarks(true);
        sliderPrixMoyM2Ans.setShowTickLabels(true);
        sliderPrixMoyM2Ans.setMajorTickUnit(10);
        sliderPrixMoyM2Ans.setBlockIncrement(1);

        Label labelNbGare = new Label("Nombre de Gare");

        Slider sliderNbGare = new Slider();
        sliderNbGare.setShowTickMarks(true);
        sliderNbGare.setShowTickLabels(true);
        sliderNbGare.setMajorTickUnit(10);
        sliderNbGare.setBlockIncrement(1);

        Label labelNbHabitant = new Label("Nombre d'habitant");

        Slider sliderNbHabitant = new Slider();
        sliderNbHabitant.setShowTickMarks(true);
        sliderNbHabitant.setShowTickLabels(true);
        sliderNbHabitant.setMajorTickUnit(10);
        sliderNbHabitant.setBlockIncrement(1);

        Label labelNbMaisonVenduAns = new Label("Nombre de maison vendu par ans");

        Slider sliderNbMaisonVenduAns = new Slider();
        sliderNbMaisonVenduAns.setShowTickMarks(true);
        sliderNbMaisonVenduAns.setShowTickLabels(true);
        sliderNbMaisonVenduAns.setMajorTickUnit(10);
        sliderNbMaisonVenduAns.setBlockIncrement(1);

        Label labelNbAeroport = new Label("Nombre d\'aéroport");

        Slider sliderNbAeroport = new Slider();
        sliderNbAeroport.setShowTickMarks(true);
        sliderNbAeroport.setShowTickLabels(true);
        sliderNbAeroport.setMajorTickUnit(10);
        sliderNbAeroport.setBlockIncrement(1);

        Label[] labels = new Label[]{labelCommunesVoisines, labelVenteApart, labelTailleMoyHabit, labelInflation, labelInvCulture, labelPrixMoyM2Ans, labelNbGare, labelNbHabitant, labelNbMaisonVenduAns, labelNbAeroport};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font(FONT_NAME, IMG_SIZE/5));
            GridPane.setMargin(labels[i], new Insets(10));
            GridPane.setHalignment(labels[i], HPos.CENTER);
        }

        dataPane.add(labelCommunesVoisines, 0, 0);
        dataPane.add(sliderCommunesVoisines, 0, 1);

        dataPane.add(labelVenteApart, 1, 0);
        dataPane.add(sliderVenteApart, 1, 1);

        dataPane.add(labelTailleMoyHabit, 0, 2);
        dataPane.add(sliderTailleMoyHabit, 0, 3);

        dataPane.add(labelInflation, 1, 2);
        dataPane.add(sliderInflation, 1, 3);

        dataPane.add(labelInvCulture, 0, 4);
        dataPane.add(sliderInvCulture, 0, 5);

        dataPane.add(labelPrixMoyM2Ans, 1, 4);
        dataPane.add(sliderPrixMoyM2Ans, 1, 5);

        dataPane.add(labelNbGare, 0, 6);
        dataPane.add(sliderNbGare, 0, 7);

        dataPane.add(labelNbHabitant, 1, 6);
        dataPane.add(sliderNbHabitant, 1, 7);

        dataPane.add(labelNbMaisonVenduAns, 0, 8);
        dataPane.add(sliderNbMaisonVenduAns, 0, 9);

        dataPane.add(labelNbAeroport, 1, 8);
        dataPane.add(sliderNbAeroport, 1, 9);

        return dataPane;
    }
}
