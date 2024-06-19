package view;

import java.io.FileInputStream;

import controller.communesController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeView {

    private GridPane homePane;
    private ImageView imageView;

    public HomeView(communesController controller) {
        this.homePane = new GridPane();

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
    }

    public GridPane getPane() {
        return homePane;
    }

    public ImageView getImageView() {
        return imageView;
    }

}
