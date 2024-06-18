package controller;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import view.CommunesView;
import view.AuthView;
import view.UserView;
import view.SearchView;
import view.HomeView;
import view.ScoreboardView;
import view.SettingsView;
import view.UIMakingUtils;

import model.data.UIVars;


public class communesController {

    private CommunesView mainView;
    private AuthView authView;
    private UserView userView;
    private SearchView searchView;
    private HomeView homeView;
    private ScoreboardView scoreboardView;
    private SettingsView settingsView;
    private UIMakingUtils utils;

    

    public communesController(CommunesView view) {
        this.mainView = view;
    }

    public void onReady() {
        mainView.getUserButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.userView.getPane());
        });

        mainView.getSearchButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.searchView.getPane());
        });

        mainView.getHomeButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.homeView.getPane());
        });

        mainView.getScoreboardButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.scoreboardView.getPane());
        });

        mainView.getSettingsButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.settingsView.getPane());
        });
        mainView.getLogo().setOnMouseClicked(e -> {
            mainView.getRoot().setCenter(utils.rickRoll());
        });
        mainView.getMenuButton().setOnAction(e -> {
            mainView.getMenu().setVisible(!mainView.getMenu().isVisible());
            if (!mainView.getMenu().isVisible()) {
                mainView.getRoot().getChildren().remove(mainView.getMenu());
            } else {
                mainView.getRoot().setLeft(mainView.getMenu());
            }
        });
        mainView.getExitButton().setOnAction(e -> {
            mainView.exit();
        });
        mainView.getRoot().centerProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != utils.getRickView()) {
                ((MediaView) oldVal).getMediaPlayer().stop();
            }
        });
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
    }


    public int getImgSize() {
        return imgSize;
    }
    
}
