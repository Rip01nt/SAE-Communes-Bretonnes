package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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

import model.dao.AeroportDAO;
import model.dao.AnneeDAO;
import model.dao.CommuneDAO;
import model.dao.DepartementDAO;
import model.dao.DonneesAnnuellesDAO;
import model.dao.GareDAO;
import model.dao.UserDAO;

import model.data.UIVars;
import model.data.Commune;


public class communesController {

    private CommunesView mainView;
    private AuthView authView;
    private UserView userView;
    private SearchView searchView;
    private HomeView homeView;
    private ScoreboardView scoreboardView;
    private SettingsView settingsView;
    private UIMakingUtils utils;

    private AeroportDAO aeroportDAO;
    private AnneeDAO anneeDAO;
    private CommuneDAO communeDAO;
    private DepartementDAO departementDAO;
    private DonneesAnnuellesDAO donneesAnnuellesDAO;
    private GareDAO gareDAO;
    private UserDAO userDAO;

    private UIVars uivars = new UIVars();
    

    public communesController(CommunesView view) {
        this.mainView = view;

        this.authView = new AuthView(this);
        this.userView = new UserView(this);
        this.searchView = new SearchView(this);
        this.homeView = new HomeView(this);
        this.scoreboardView = new ScoreboardView(this);
        this.settingsView = new SettingsView(this);
        this.utils = new UIMakingUtils(this);

        this.aeroportDAO = new AeroportDAO();
        this.anneeDAO = new AnneeDAO();
        this.communeDAO = new CommuneDAO();
        this.departementDAO = new DepartementDAO();
        this.donneesAnnuellesDAO = new DonneesAnnuellesDAO();
        this.gareDAO = new GareDAO();
        this.userDAO = new UserDAO();
    }

    public void onReady() {
        this.mainView.getRoot().setCenter(this.homeView.getPane());
        this.mainView.getTitleLabel().setText("Bienvenue !");

        mainView.getUserButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.userView.getPane());
            mainView.getTitleLabel().setText(uivars.getUSER());
        });

        mainView.getSearchButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.searchView.getPane());
            mainView.getTitleLabel().setText(uivars.getSEARCH());
        });

        mainView.getHomeButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.homeView.getPane());
            mainView.getTitleLabel().setText(uivars.getHOME());
        });

        mainView.getScoreboardButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.scoreboardView.getPane());
            mainView.getTitleLabel().setText(uivars.getSCOREBOARD());
        });

        mainView.getSettingsButton().setOnAction(e -> {
            mainView.getRoot().setCenter(this.settingsView.getPane());
            mainView.getTitleLabel().setText(uivars.getSETTINGS());
        });

        mainView.getLogo().setOnMouseClicked(e -> {
            mainView.getRoot().setCenter(utils.rickRoll());
            mainView.getTitleLabel().setText(uivars.getUTILS());
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
            if (oldVal instanceof MediaView) {
                if (newVal != utils.getRickView()) {
                    ((MediaView) oldVal).getMediaPlayer().stop();
                }
            }
        });

        searchView.getSearchButton().setOnAction(e -> {

            Commune commune = communeDAO.findByName(searchView.getSearchField().getText().trim());
        });

        authView.getLoginButton().setOnAction(e -> {
            // Hardcoded login credentials
            // TODO : Implement a database for user authentication
            if (authView.getUsernameField().getText().equals("admin") && authView.getPasswordField().getText().equals("admin")) {
                if (this.homeView.getImageView() != null) {
                    this.homeView.getImageView().setPreserveRatio(true);
                    this.homeView.getImageView().fitWidthProperty().bind(this.homeView.getPane().widthProperty().multiply(0.9));
                    this.homeView.getImageView().fitHeightProperty().bind(this.homeView.getPane().heightProperty().multiply(0.9));
                }
                authView.getPane().setVisible(false);
                mainView.getRoot().setVisible(true);
                mainView.getMenuButton().setFocusTraversable(true);
            } else {
                authView.getPane().add(authView.getErrLabel(), 0, 1);
                GridPane.setMargin(authView.getErrLabel(), uivars.getINSETS());
            }
        });

        this.setSettingsFit(settingsView.getSliders(), settingsView.getLabels());

        searchView.getListView().prefWidthProperty().bind(searchView.getPane().widthProperty());
        searchView.getListView().prefHeightProperty().bind(searchView.getPane().heightProperty());
        
    }

    private void setSettingsFit(Slider[] sliderList, Label[] labelList) {
        for (Slider slider : sliderList) {
            // Bind the slider's width to 40% of the settingsPane's width
            slider.prefWidthProperty().bind(settingsView.getPane().widthProperty().multiply(0.4));
            slider.prefHeightProperty().bind(settingsView.getPane().heightProperty().multiply(0.2));
        }

        for (Label label : labelList) {
            settingsView.getPane().widthProperty().addListener((ChangeListener<? super Number>) new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    double newFontSize = newValue.doubleValue() * 0.03;
                    label.setFont(Font.font(label.getFont().getFamily(), newFontSize));
                }
            });
            
            // Bind the label's width to 80% of the settingsPane's width
            label.prefHeightProperty().bind(settingsView.getPane().heightProperty().multiply(0.8));
            label.setWrapText(true);
            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setMargin(label, uivars.getINSETS());
        }
    }

    public int getImgSize() {
        return uivars.getImgSize();
    }

    public String getTITLE() {
        return uivars.getTITLE();
    }

    public Font getTITLE_FONT() {
        return uivars.getTITLE_FONT();
    }

    public Font getFONT() {
        return uivars.getFONT();
    }

    public Insets getINSETS() {
        return uivars.getINSETS();
    }

    public String getFONT_NAME() {
        return uivars.getFONT_NAME();
    }

    public GridPane getAuthPane() {
        return authView.getPane();
    }

    public ImageView getLogo_light() {
        return uivars.getLogo_light();
    }

    public ImageView getLogo_dark() {
        return uivars.getLogo_dark();
    }
    
}
