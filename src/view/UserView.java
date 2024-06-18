package view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class UserView {
    public GridPane getPane() {
        
        GridPane userPane = new GridPane();

        this.titleLabel = new Label("User");

        Label labelUsername = new Label("Username");
        labelUsername.setFont(new Font(FONT_NAME, imgSize/4));
        GridPane.setMargin(labelUsername, new Insets(10));
        GridPane.setHalignment(labelUsername, HPos.CENTER);

        Label labelPassword = new Label("Password");
        labelPassword.setFont(new Font(FONT_NAME, imgSize/4));
        GridPane.setMargin(labelPassword, new Insets(10));
        GridPane.setHalignment(labelPassword, HPos.CENTER);

        Label labelUISize = new Label("UI Size");
        labelUISize.setFont(new Font(FONT_NAME, imgSize/4));
        GridPane.setMargin(labelUISize, new Insets(10));
        GridPane.setHalignment(labelUISize, HPos.CENTER);
        Slider sliderUISize = new Slider();
        sliderUISize.setShowTickMarks(true);
        sliderUISize.setScaleShape(false);
        sliderUISize.setMajorTickUnit(20);
        sliderUISize.setBlockIncrement(20);
        sliderUISize.setMin(60);
        sliderUISize.setMax(100);
        sliderUISize.setOnMouseReleased(e -> {
            imgSize = (int) sliderUISize.getValue();
            titleLabel.setFont(new Font(FONT_NAME, imgSize/2));
            for (Button button : menuButtons) {
                button.setPrefWidth(imgSize*1.2);
                button.setPrefHeight(Integer.MAX_VALUE);
                VBox.setMargin(button, new Insets(imgSize/10, imgSize/10, 0, imgSize/20));
            }
            VBox.setMargin(userButton, new Insets(imgSize/10, imgSize/10, 0, imgSize/20));
            VBox.setMargin(exitButton, new Insets(imgSize/10, imgSize/10, imgSize/10, imgSize/20));
            BorderPane.setAlignment(menuButton, javafx.geometry.Pos.CENTER_LEFT);
        });

        userPane.add(labelUsername, 0, 0);
        userPane.add(labelPassword, 0, 1);
        userPane.add(labelUISize, 0, 2);
        userPane.add(sliderUISize, 1, 2);



        return userPane;
    }
}
