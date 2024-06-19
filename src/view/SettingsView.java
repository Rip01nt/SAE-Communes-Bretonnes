package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class SettingsView {

    private GridPane settingsPane;
    private Button buttonExport;
    private Label[] labels;
    private Slider[] sliders;

    public SettingsView(communesController controller) {
        this.settingsPane = new GridPane();
        GridPane innerPane = new GridPane();

        buttonExport = new Button("Exporter les données des communes");
        buttonExport.setFont(controller.getFONT());
        GridPane.setMargin(buttonExport, new Insets(40));
        GridPane.setHalignment(buttonExport, HPos.CENTER);

        Label labelCommunesVoisines = new Label("Communes voisines");

        Slider sliderCommunesVoisines = new Slider();
        sliderCommunesVoisines.setShowTickMarks(true);
        sliderCommunesVoisines.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(false);
        sliderCommunesVoisines.setMajorTickUnit(10);
        sliderCommunesVoisines.setBlockIncrement(1);

        Label labelVenteApart = new Label("Appartements vendu par ans");

        Slider sliderVenteApart = new Slider();
        sliderVenteApart.setShowTickMarks(true);
        sliderVenteApart.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(true);
        sliderVenteApart.setMajorTickUnit(10);
        sliderVenteApart.setBlockIncrement(1);

        Label labelTailleMoyHabit = new Label("Taille moyenne des habitations");

        Slider sliderTailleMoyHabit = new Slider();
        sliderTailleMoyHabit.setShowTickMarks(true);
        sliderTailleMoyHabit.setShowTickLabels(true);
        sliderTailleMoyHabit.setMajorTickUnit(10);
        sliderTailleMoyHabit.setBlockIncrement(1);

        Label labelInflation = new Label("Taux inflation");

        Slider sliderInflation = new Slider();
        sliderInflation.setShowTickMarks(true);
        sliderInflation.setShowTickLabels(true);
        sliderInflation.setMajorTickUnit(10);
        sliderInflation.setBlockIncrement(1);

        Label labelInvCulture = new Label("Investissement culturel");

        Slider sliderInvCulture = new Slider();
        sliderInvCulture.setShowTickMarks(true);
        sliderInvCulture.setShowTickLabels(true);
        sliderInvCulture.setMajorTickUnit(10);
        sliderInvCulture.setBlockIncrement(1);

        Label labelPrixMoyM2Ans = new Label("Prix moyen du m² par ans");

        Slider sliderPrixMoyM2Ans = new Slider();
        sliderPrixMoyM2Ans.setShowTickMarks(true);
        sliderPrixMoyM2Ans.setShowTickLabels(true);
        sliderPrixMoyM2Ans.setMajorTickUnit(10);
        sliderPrixMoyM2Ans.setBlockIncrement(1);

        Label labelNbGare = new Label("Nombre de Gare");

        Slider sliderNbGare = new Slider();
        sliderNbGare.setShowTickMarks(true);
        sliderNbGare.setShowTickLabels(true);
        sliderNbGare.setMajorTickUnit(10);
        sliderNbGare.setBlockIncrement(1);

        Label labelNbHabitant = new Label("Nombre d'habitant");

        Slider sliderNbHabitant = new Slider();
        sliderNbHabitant.setShowTickMarks(true);
        sliderNbHabitant.setShowTickLabels(true);
        sliderNbHabitant.setMajorTickUnit(10);
        sliderNbHabitant.setBlockIncrement(1);
        Label labelNbMaisonVenduAns = new Label("Maison vendues par ans");

        Slider sliderNbMaisonVenduAns = new Slider();
        sliderNbMaisonVenduAns.setShowTickMarks(true);
        sliderNbMaisonVenduAns.setShowTickLabels(true);
        sliderNbMaisonVenduAns.setMajorTickUnit(10);
        sliderNbMaisonVenduAns.setBlockIncrement(1);

        Label labelNbAeroport = new Label("Nombre d\'aéroport");

        Slider sliderNbAeroport = new Slider();
        sliderNbAeroport.setShowTickMarks(true);
        sliderNbAeroport.setShowTickLabels(true);
        sliderNbAeroport.setMajorTickUnit(10);
        sliderNbAeroport.setBlockIncrement(1);

        innerPane.add(labelCommunesVoisines, 0, 0);
        innerPane.add(sliderCommunesVoisines, 0, 1);

        innerPane.add(labelVenteApart, 1, 0);
        innerPane.add(sliderVenteApart, 1, 1);

        innerPane.add(labelTailleMoyHabit, 0, 2);
        innerPane.add(sliderTailleMoyHabit, 0, 3);

        innerPane.add(labelInflation, 1, 2);
        innerPane.add(sliderInflation, 1, 3);

        innerPane.add(labelInvCulture, 0, 4);
        innerPane.add(sliderInvCulture, 0, 5);

        innerPane.add(labelPrixMoyM2Ans, 1, 4);
        innerPane.add(sliderPrixMoyM2Ans, 1, 5);

        innerPane.add(labelNbGare, 0, 6);
        innerPane.add(sliderNbGare, 0, 7);

        innerPane.add(labelNbHabitant, 1, 6);
        innerPane.add(sliderNbHabitant, 1, 7);

        innerPane.add(labelNbMaisonVenduAns, 0, 8);
        innerPane.add(sliderNbMaisonVenduAns, 0, 9);

        innerPane.add(labelNbAeroport, 1, 8);
        innerPane.add(sliderNbAeroport, 1, 9);

        this.settingsPane.add(innerPane, 0, 0);
        this.settingsPane.add(buttonExport, 0, 1);

        this.labels = new Label[] {labelCommunesVoisines, labelVenteApart, labelTailleMoyHabit, labelInflation, labelInvCulture, labelPrixMoyM2Ans, labelNbGare, labelNbHabitant, labelNbMaisonVenduAns, labelNbAeroport};
        this.sliders = new Slider[] {sliderCommunesVoisines, sliderVenteApart, sliderTailleMoyHabit, sliderInflation, sliderInvCulture, sliderPrixMoyM2Ans, sliderNbGare, sliderNbHabitant, sliderNbMaisonVenduAns, sliderNbAeroport};

    }

    public GridPane getPane() {
        return this.settingsPane;
    }

    public Button getButtonExport() {
        return this.buttonExport;
    }

    public Label[] getLabels() {
        return this.labels;
    }

    public Slider[] getSliders() {
        return this.sliders;
    }
}
