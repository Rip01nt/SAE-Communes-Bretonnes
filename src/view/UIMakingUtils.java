package view;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import controller.communesController;

public class UIMakingUtils {

    private communesController communesController;

    public UIMakingUtils(communesController communesController) {
        this.communesController = communesController;
    }

    private MediaView rickView = null;

    public MediaView rickRoll() {
        MediaPlayer mediaPlayer = null;
        try {
            mediaPlayer = new MediaPlayer(new Media(new File("../src/assets/rick.mp4").toURI().toURL().toString()));
            rickView = new MediaView(mediaPlayer);
        } catch (Exception e) {} finally {
            rickView.setFitHeight(communesController.getImgSize()*9);
            rickView.setFitWidth(communesController.getImgSize()*7);
            mediaPlayer.play();
        }
        return rickView;
    }

    public MediaView getRickView() {
        return rickView;
    }

}
