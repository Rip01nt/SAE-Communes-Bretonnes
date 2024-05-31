package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.communesController;

public class communesView extends Application {

    private static final String TITLE = "Communes Bretonnes";
    private static final String FXML = "/ressource/communes.fxml";
    private BorderPane root;
    private VBox menu;
    private Button menuButton;


    public void start(Stage primaryStage) throws Exception {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/communes.fxml"));
        Parent root = loader.load();
        */
        root = new BorderPane();
        menu = new VBox();
        root.setLeft(menu);
        root.setTop(menuButton);
        BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        root.setCenter(new Label("Hello World"));
        menuButton = new Button("≡");
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Communes Bretonnes");


        primaryStage.show();
        communesController controller = new communesController();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
