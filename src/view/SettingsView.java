package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SettingsView {

    private GridPane settingsPane;
    private communesController controller;

    public SettingsView(communesController controller) {
        this.settingsPane = new GridPane();
        this.controller = controller;


        Label labelCommunesVoisines = new Label("Nombre de communes voisines");

        Slider sliderCommunesVoisines = new Slider();
        sliderCommunesVoisines.setShowTickMarks(true);
        sliderCommunesVoisines.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(false);
        sliderCommunesVoisines.setMajorTickUnit(10);
        sliderCommunesVoisines.setBlockIncrement(1);
        this.setFit(sliderCommunesVoisines, labelCommunesVoisines);

        Label labelVenteApart = new Label("Nombre d'appartements vendu par ans");

        Slider sliderVenteApart = new Slider();
        sliderVenteApart.setShowTickMarks(true);
        sliderVenteApart.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(true);
        sliderVenteApart.setMajorTickUnit(10);
        sliderVenteApart.setBlockIncrement(1);
        this.setFit(sliderVenteApart, labelVenteApart);

        Label labelTailleMoyHabit = new Label("Taille moyenne des habitations");

        Slider sliderTailleMoyHabit = new Slider();
        sliderTailleMoyHabit.setShowTickMarks(true);
        sliderTailleMoyHabit.setShowTickLabels(true);
        sliderTailleMoyHabit.setMajorTickUnit(10);
        sliderTailleMoyHabit.setBlockIncrement(1);
        this.setFit(sliderTailleMoyHabit, labelTailleMoyHabit);

        Label labelInflation = new Label("Taux inflation");

        Slider sliderInflation = new Slider();
        sliderInflation.setShowTickMarks(true);
        sliderInflation.setShowTickLabels(true);
        sliderInflation.setMajorTickUnit(10);
        sliderInflation.setBlockIncrement(1);
        this.setFit(sliderInflation, labelInflation);

        Label labelInvCulture = new Label("Investissement culturel");

        Slider sliderInvCulture = new Slider();
        sliderInvCulture.setShowTickMarks(true);
        sliderInvCulture.setShowTickLabels(true);
        sliderInvCulture.setMajorTickUnit(10);
        sliderInvCulture.setBlockIncrement(1);
        this.setFit(sliderInvCulture, labelInvCulture);

        Label labelPrixMoyM2Ans = new Label("Prix moyen du m² par ans");

        Slider sliderPrixMoyM2Ans = new Slider();
        sliderPrixMoyM2Ans.setShowTickMarks(true);
        sliderPrixMoyM2Ans.setShowTickLabels(true);
        sliderPrixMoyM2Ans.setMajorTickUnit(10);
        sliderPrixMoyM2Ans.setBlockIncrement(1);
        this.setFit(sliderPrixMoyM2Ans, labelPrixMoyM2Ans);

        Label labelNbGare = new Label("Nombre de Gare");

        Slider sliderNbGare = new Slider();
        sliderNbGare.setShowTickMarks(true);
        sliderNbGare.setShowTickLabels(true);
        sliderNbGare.setMajorTickUnit(10);
        sliderNbGare.setBlockIncrement(1);
        this.setFit(sliderNbGare, labelNbGare);

        Label labelNbHabitant = new Label("Nombre d'habitant");

        Slider sliderNbHabitant = new Slider();
        sliderNbHabitant.setShowTickMarks(true);
        sliderNbHabitant.setShowTickLabels(true);
        sliderNbHabitant.setMajorTickUnit(10);
        sliderNbHabitant.setBlockIncrement(1);
        this.setFit(sliderNbHabitant, labelNbHabitant);

        Label labelNbMaisonVenduAns = new Label("Nombre de maison vendu par ans");

        Slider sliderNbMaisonVenduAns = new Slider();
        sliderNbMaisonVenduAns.setShowTickMarks(true);
        sliderNbMaisonVenduAns.setShowTickLabels(true);
        sliderNbMaisonVenduAns.setMajorTickUnit(10);
        sliderNbMaisonVenduAns.setBlockIncrement(1);
        this.setFit(sliderNbMaisonVenduAns, labelNbMaisonVenduAns);

        Label labelNbAeroport = new Label("Nombre d\'aéroport");

        Slider sliderNbAeroport = new Slider();
        sliderNbAeroport.setShowTickMarks(true);
        sliderNbAeroport.setShowTickLabels(true);
        sliderNbAeroport.setMajorTickUnit(10);
        sliderNbAeroport.setBlockIncrement(1);
        this.setFit(sliderNbAeroport, labelNbAeroport);

        Label[] labels = new Label[]{labelCommunesVoisines, labelVenteApart, labelTailleMoyHabit, labelInflation, labelInvCulture, labelPrixMoyM2Ans, labelNbGare, labelNbHabitant, labelNbMaisonVenduAns, labelNbAeroport};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(controller.getFONT());
            GridPane.setMargin(labels[i], new Insets(10));
            GridPane.setHalignment(labels[i], HPos.CENTER);
        }

        this.settingsPane.add(labelCommunesVoisines, 0, 0);
        this.settingsPane.add(sliderCommunesVoisines, 0, 1);

        this.settingsPane.add(labelVenteApart, 1, 0);
        this.settingsPane.add(sliderVenteApart, 1, 1);

        this.settingsPane.add(labelTailleMoyHabit, 0, 2);
        this.settingsPane.add(sliderTailleMoyHabit, 0, 3);

        this.settingsPane.add(labelInflation, 1, 2);
        this.settingsPane.add(sliderInflation, 1, 3);

        this.settingsPane.add(labelInvCulture, 0, 4);
        this.settingsPane.add(sliderInvCulture, 0, 5);

        this.settingsPane.add(labelPrixMoyM2Ans, 1, 4);
        this.settingsPane.add(sliderPrixMoyM2Ans, 1, 5);

        this.settingsPane.add(labelNbGare, 0, 6);
        this.settingsPane.add(sliderNbGare, 0, 7);

        this.settingsPane.add(labelNbHabitant, 1, 6);
        this.settingsPane.add(sliderNbHabitant, 1, 7);

        this.settingsPane.add(labelNbMaisonVenduAns, 0, 8);
        this.settingsPane.add(sliderNbMaisonVenduAns, 0, 9);

        this.settingsPane.add(labelNbAeroport, 1, 8);
        this.settingsPane.add(sliderNbAeroport, 1, 9);

    }

    private void setFit(Slider slider, Label label) {
        Font font = new Font("Arial", 40);
        // Bind the slider's width to 40% of the settingsPane's width
        slider.prefWidthProperty().bind(settingsPane.widthProperty().multiply(0.4));

        // Bind the label's width to 80% of the settingsPane's width
        label.prefWidthProperty().bind(settingsPane.widthProperty().multiply(0.8));
        label.setWrapText(true);
        label.setFont(font);
        

    }


    public GridPane getPane() {
        return this.settingsPane;
    }
}
