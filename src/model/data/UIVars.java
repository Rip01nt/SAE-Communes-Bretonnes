package model.data;

import javafx.geometry.Insets;
import javafx.scene.text.Font;

public class UIVars {
    
    private final String TITLE = "Communes Bretonnes";
    private final String FONT_NAME="Arial";
    private int imgSize = 80;
    private final Font TITLE_FONT = new Font(FONT_NAME, imgSize/2);
    private final Font FONT = new Font(FONT_NAME, imgSize/4);
    private final Insets INSETS = new Insets(imgSize/10, imgSize/10, imgSize/10, imgSize/10);

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

    public Font getFONT() {
        return FONT;
    }

    public Insets getINSETS() {
        return INSETS;
    }
}
