package view;

import controller.communesController;
import javafx.scene.layout.GridPane;

public class SearchView {

    private GridPane searchPane;

    public SearchView(communesController controller) {
        this.searchPane = new GridPane();
        
    }

    public GridPane getPane() {
        return searchPane;
    }

}
