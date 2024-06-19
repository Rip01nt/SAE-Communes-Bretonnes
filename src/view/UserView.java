package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserView {

    private GridPane userPane;
    private Label labelUsername;
    private Label labelPassword;

    public UserView(communesController controller) {
        userPane = new GridPane();

        labelUsername = new Label("Username");
        labelUsername.setFont(controller.getFONT());
        GridPane.setMargin(labelUsername, new Insets(10));
        GridPane.setHalignment(labelUsername, HPos.CENTER);

        labelPassword = new Label("Password");
        labelPassword.setFont(controller.getFONT());
        GridPane.setMargin(labelPassword, new Insets(10));
        GridPane.setHalignment(labelPassword, HPos.CENTER);

        userPane.add(labelUsername, 0, 0);
        userPane.add(labelPassword, 0, 1);
    }

    public GridPane getPane() {
        return userPane;
    }

    public TextField getLabelUsername() {
        return labelUsername;
    }

    public TextField getLabelPassword() {
        return labelPassword;
    }

}
