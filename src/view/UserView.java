package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class UserView {

    private GridPane userPane;
    private Label labelUsername;
    private Label labelPassword;
    private Label labelUISize;
    private Slider sliderUISize;

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

        labelUISize = new Label("UI Size");
        labelUISize.setFont(controller.getFONT());
        GridPane.setMargin(labelUISize, new Insets(10));
        GridPane.setHalignment(labelUISize, HPos.CENTER);
        sliderUISize = new Slider();
        sliderUISize.setShowTickMarks(true);
        sliderUISize.setScaleShape(false);
        sliderUISize.setMajorTickUnit(20);
        sliderUISize.setBlockIncrement(20);
        sliderUISize.setMin(60);
        sliderUISize.setMax(100);

        userPane.add(labelUsername, 0, 0);
        userPane.add(labelPassword, 0, 1);
        userPane.add(labelUISize, 0, 2);
        userPane.add(sliderUISize, 1, 2);
    }

    public GridPane getPane() {
        return userPane;
    }

    public Label getLabelUsername() {
        return labelUsername;
    }

    public Label getLabelPassword() {
        return labelPassword;
    }

    public Label getLabelUISize() {
        return labelUISize;
    }

    public Slider getSliderUISize() {
        return sliderUISize;
    }
}
