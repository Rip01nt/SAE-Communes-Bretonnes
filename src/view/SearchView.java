package view;

import controller.communesController;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchView {

    private GridPane searchPane;
    private TextField searchField;
    private Button searchButton;
    private ListView<String> listView;

    public SearchView(communesController controller) {
        this.searchPane = new GridPane();
        GridPane innerPane = new GridPane();
        
        // Création des éléments de l'interface utilisateur
        this.searchField = new TextField();
        this.searchField.setFont(controller.getFONT());
        this.searchField.setPromptText("Enter search query");
        GridPane.setMargin(searchField, controller.getINSETS());

        this.searchButton = new Button("Search");
        this.searchButton.setFont(controller.getFONT());
        GridPane.setMargin(searchButton, controller.getINSETS());
        this.listView = new ListView<>();
        GridPane.setMargin(listView, controller.getINSETS());


        innerPane.add(searchField, 0, 0);
        innerPane.add(searchButton, 1, 0);
        searchPane.add(innerPane, 0, 0);
        searchPane.add(listView, 0, 1);

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
