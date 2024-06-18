package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import controller.communesController;

public class CommunesView extends Application {

    private Label titleLabel;
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
    private ImageView logo;

    public void start(Stage primaryStage) throws Exception {
        communesController controller = new communesController(this);
        this.primaryStage = primaryStage;

        root = new BorderPane();
        titleLabel = new Label();
        titleLabel.setFont(new Font(controller.getFONT_NAME(), controller.getImgSize()/2));
        userButton = new Button("\uE853");
        userButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        searchButton = new Button("\uE8B6");
        searchButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        homeButton = new Button("\uE88A");
        homeButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        scoreboardButton = new Button("\uF6A0");
        scoreboardButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        settingsButton = new Button("\uE026");
        settingsButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        exitButton = new Button("\uE8AC");
        exitButton.setStyle("-fx-font-family: 'Material Symbols Outlined';-fx-font-size: 3em;-fx-alignment: center;");
        exitButton.textFillProperty().set(javafx.scene.paint.Color.RED);
        menu = new VBox(userButton, searchButton, homeButton, scoreboardButton, settingsButton, exitButton);
        menuButton = new Button("≡");
        menuButton.setFocusTraversable(false);
        menuButton.setFont(controller.getTITLE_FONT());
        titleBar = new BorderPane();
        this.titleLabel.setFont(controller.getTITLE_FONT());
        titleBar.setCenter(titleLabel);
        titleBar.setLeft(menuButton);
        BorderPane.setMargin(menuButton, controller.getINSETS());
        logo = controller.getLogo_dark();
        BorderPane.setMargin(logo, controller.getINSETS());
        titleBar.setRight(logo);

        root.setLeft(menu);
        root.setTop(titleBar);
        root.setStyle("-fx-background-color: #CCCCFF;");
        titleBar.setStyle("-fx-background-color: #FFFFFF;");
        menu.setVisible(false);
        root.getChildren().remove(menu);
        menuButtons = new Button[]{userButton, searchButton, homeButton, scoreboardButton, settingsButton, exitButton};
        for (Button button : menuButtons) {
            button.setPrefWidth(controller.getImgSize()*1.2);
            button.setPrefHeight(Integer.MAX_VALUE);
            VBox.setMargin(button, new Insets(controller.getImgSize()/10, controller.getImgSize()/10, 0, controller.getImgSize()/20));
        }
        VBox.setMargin(userButton, new Insets(controller.getImgSize()/10, controller.getImgSize()/10, 0, controller.getImgSize()/20));
        VBox.setMargin(exitButton, new Insets(controller.getImgSize()/10, controller.getImgSize()/10, controller.getImgSize()/10, controller.getImgSize()/20));
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        controller.onReady();

        this.center = new StackPane(root, controller.getAuthPane());
        this.scene = new Scene(center, controller.getImgSize()*9, controller.getImgSize()*9.25);
        this.primaryStage.setMinHeight(controller.getImgSize()*9);
        this.primaryStage.setMinWidth(controller.getImgSize()*7);
        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle(controller.getTITLE());
        this.primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
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

    public Button getUserButton() {
        return userButton;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public Button getScoreboardButton() {
        return scoreboardButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    public Label getTitleLabel() {
        return titleLabel;
    }

    public void exit() {
        primaryStage.close();
    }

    public Button[] getMenuButtons() {
        return menuButtons;
    }

    public ImageView getLogo() {
        return logo;
    }
}