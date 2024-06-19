package model.data;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class UIVars {
    
    private final String TITLE = "Communes Bretonnes";
    private final String FONT_NAME="Arial";
    private int imgSize = 80;
    private final Font TITLE_FONT = new Font(FONT_NAME, imgSize/2);
    private final Font FONT = new Font(FONT_NAME, imgSize/4);
    private final Insets INSETS = new Insets(imgSize/10, imgSize/10, imgSize/10, imgSize/10);
    private final String HOME = "Home",SEARCH = "Search",USER = "User",SCOREBOARD = "Scoreboard",SETTINGS = "Settings",UTILS = "Utils";
    private final ImageView logo_light;
    private final ImageView logo_dark;
    private User user = null;
    private ArrayList<Commune> communes = new ArrayList<Commune>();

    public UIVars() {
        ImageView logo_light = null;
        ImageView logo_dark = null;
        try {
            logo_light = new ImageView(new Image(new FileInputStream("../src/assets/logo_light.png")));
            logo_light.setFitHeight(imgSize*1.75);
            logo_light.setFitWidth(imgSize*1.75);

            logo_dark = new ImageView(new Image(new FileInputStream("../src/assets/logo_dark.png")));
            logo_dark.setFitHeight(imgSize);
            logo_dark.setFitWidth(imgSize);
        } catch (Exception e) {}
        this.logo_light = logo_light;
        this.logo_dark = logo_dark;

    }


    public int getImgSize() {
        return imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    public String getTITLE() {
        return TITLE;
    }

    public Font getTITLE_FONT() {
        return TITLE_FONT;
    }

    public String getFONT_NAME() {
        return FONT_NAME;
    }

    public Font getFONT() {
        return FONT;
    }

    public Insets getINSETS() {
        return INSETS;
    }

    public String getHOME() {
        return HOME;
    }

    public String getSEARCH() {
        return SEARCH;
    }

    public String getUSER() {
        return USER;
    }

    public String getSCOREBOARD() {
        return SCOREBOARD;
    }

    public String getSETTINGS() {
        return SETTINGS;
    }

    public String getUTILS() {
        return UTILS;
    }

    public ImageView getLogo_light() {
        return logo_light;
    }

    public ImageView getLogo_dark() {
        return logo_dark;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Commune> getCommunes() {
        return communes;
    }

}
