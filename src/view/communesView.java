package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    private static final String FXML = "/ressource/communes.fxml";
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/communes.fxml"));
        Parent parRoot = loader.load();
        root = new BorderPane();
        menu = new VBox();
        menuButton = new Button("≡");
        root.setLeft(menu);
        root.setTop(menuButton);
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        root.setCenter(new Label("Hello World"));
        Scene scene = new Scene(parRoot, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);


        primaryStage.show();
        communesController controller = new communesController();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
