package view;

import controller.communesController;
import javafx.scene.layout.GridPane;

public class HomeView {

    private GridPane homePane;

    public HomeView(communesController controller) {
        this.homePane = new GridPane();
    }

    public GridPane getPane() {
        return homePane;
    }
}
