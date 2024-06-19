package view;

import java.io.FileInputStream;

import controller.communesController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HomeView {

    private GridPane homePane;

    public HomeView(communesController controller) {
        this.homePane = new GridPane();
        initialize(controller);
    }

    private void initialize(communesController controller) {
        // Créer un label pour le titre de la page d'accueil
        Label titleLabel = new Label("Bienvenue !");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Ajouter une image
        ImageView imageView = null;
        try {
            imageView = new ImageView(new Image(new FileInputStream("../src/assets/ImageAcceuil.jpg")));
            imageView.setFitHeight(controller.getImgSize()*6);
            imageView.setFitWidth(controller.getImgSize()*6);
        } catch (Exception e) {}

        // Ajouter du texte descriptif
        Label descriptionLabel = new Label("Cette application vous permet de rechercher des informations sur les communes. Utilisez le menu à gauche pour naviguer.");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(new Insets(10, 0, 0, 0));

        // Organiser les éléments dans un VBox
        VBox contentBox = new VBox(10, titleLabel, imageView, descriptionLabel);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-alignment: center;");

        // Ajouter le VBox au GridPane
        homePane.add(contentBox, 0, 0);
        homePane.setStyle("-fx-alignment: center; -fx-padding: 20;");
    }

    public GridPane getPane() {
        return homePane;
    }
}
