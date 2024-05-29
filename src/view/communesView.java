package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.communesController;

public class communesView extends Application {

    public void start(Stage primaryStage) throws Exception {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/communes.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Communes Bretonnes");
        primaryStage.show();
        primaryStage.setResizable(false);
        communesController controller = new communesController();
        */
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
