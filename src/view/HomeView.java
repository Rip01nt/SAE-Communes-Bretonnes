package view;

import javafx.scene.layout.GridPane;

public class HomeView {

    public GridPane getPane() {
        GridPane homePane = new GridPane();

        this.titleLabel.setText(TITLE);

        return homePane;
    }
}
