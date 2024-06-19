package view;

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
        initialize();
    }

    private void initialize() {
        // Créer un label pour le titre de la page d'accueil
        Label titleLabel = new Label("Bienvenue !");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Ajouter une image
        String imagePath = "file:/home/bernard-griffiths/Documents/GitHub/SAE-Communes-Bretonnes/ws/ImageAcceuil.jpg";
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);

        // Ajouter du texte descriptif
        Label descriptionLabel = new Label("Cliquez sur les 3 barres en haut à gauche pour naviguer dans l'application.");
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
