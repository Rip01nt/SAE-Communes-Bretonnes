package view;

import controller.communesController;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SearchView {

    private GridPane searchPane;
    private TextField searchField;
    private Button searchButton;
    private ListView<String> listView;

    public SearchView(communesController controller) {
        this.searchPane = new GridPane();
        
        // Création des éléments de l'interface utilisateur
        this.searchField = new TextField();
        this.searchField.setPromptText("Enter search query");

        this.searchButton = new Button("Search");
        this.listView = new ListView<>();

        // Configuration de la disposition
        VBox layout = new VBox(10);
        layout.getChildren().addAll(searchField, searchButton, listView);

        searchPane.add(layout, 0, 0);
    }

    public GridPane getPane() {
        return searchPane;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public ListView<String> getListView() {
        return listView;
    }
}
