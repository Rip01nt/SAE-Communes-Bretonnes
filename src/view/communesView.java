package view;

import javafx.application.Application;
import javafx.geometry.Insets;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    private static final Label TITLE_LABEL = new Label(TITLE);
    private static final int IMG_SIZE = 80;
    private static final Font FONT = new Font("Arial", IMG_SIZE/2);
    //private static final String FXML = "/ressource/communes.fxml";
    //private static final String CSS = "/ressource/communes.css";
    private Stage primaryStage;
    private Scene scene;
    private BorderPane root;
    private BorderPane titleBar;
    private VBox menu;
    private Button menuButton;
    private Button userButton;
    private Button searchButton;
    private Button homeButton;
    private Button scoreboardButton;
    private Button settingsButton;
    private Button exitButton;
    private Button[] menuButtons;


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
        menuButton.setFont(FONT);
        titleBar = new BorderPane();
        TITLE_LABEL.setFont(FONT);
        titleBar.setCenter(TITLE_LABEL);
        titleBar.setLeft(menuButton);
        ImageView logo = new ImageView(new Image(new FileInputStream("../src/assets/logo.png")));
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
        this.scene = new Scene(root, 720, 720);
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
}
