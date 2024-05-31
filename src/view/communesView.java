package view;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    //private static final String FXML = "/ressource/communes.fxml";
    //private static final String CSS = "/ressource/communes.css";
    private static final int MENU_WIDTH = 100;
    private Stage primaryStage;
    private BorderPane root;
    private VBox menu;
    private Button menuButton;
    private Button userButton;
    private Button searchButton;
    private Button homeButton;
    private Button scoreboardButton;
    private Button settingsButton;
    private Button exitButton;
    


    public void start(Stage primaryStage) throws Exception {
        communesController controller = new communesController(this);
        this.primaryStage = primaryStage;
        // FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML));
        // Parent parRoot = loader.load();
        root = new BorderPane();
        userButton = new Button("User");
        userButton.setPrefWidth(MENU_WIDTH);
        searchButton = new Button("Search");
        searchButton.setPrefWidth(MENU_WIDTH);
        homeButton = new Button("Home");
        homeButton.setPrefWidth(MENU_WIDTH);
        scoreboardButton = new Button("Scoreboard");
        scoreboardButton.setPrefWidth(MENU_WIDTH);
        settingsButton = new Button("Settings");
        settingsButton.setPrefWidth(MENU_WIDTH);
        exitButton = new Button("Exit");
        exitButton.setPrefWidth(MENU_WIDTH);
        exitButton.textFillProperty().set(javafx.scene.paint.Color.RED);
        menu = new VBox(userButton, searchButton, homeButton, scoreboardButton, settingsButton, exitButton);
        menuButton = new Button("≡");
        root.setLeft(menu);
        root.setTop(menuButton);
        menu.setVisible(false);
        controller.onReady();
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        root.setCenter(new Hyperlink("https://www.youtube.com/watch?v=DmH6YPWhaDY", new Label("Don't click here -->")));
        Scene scene = new Scene(root);
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

    public Button getExitButton() {
        return exitButton;
    }

    public void exit() {
        primaryStage.close();
    }
}
