package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class SettingsView {

    public GridPane getPane(communesController controller) {
        GridPane dataPane = new GridPane();


        Label labelCommunesVoisines = new Label("Nombre de communes voisines");

        Slider sliderCommunesVoisines = new Slider();
        sliderCommunesVoisines.setShowTickMarks(true);
        sliderCommunesVoisines.setShowTickLabels(true);
        sliderCommunesVoisines.setScaleShape(false);
        sliderCommunesVoisines.setMajorTickUnit(10);
        sliderCommunesVoisines.setBlockIncrement(1);

        Label labelVenteApart = new Label("Nombre d'appartements vendu par ans");

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

        Label labelNbMaisonVenduAns = new Label("Nombre de maison vendu par ans");

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

        Label[] labels = new Label[]{labelCommunesVoisines, labelVenteApart, labelTailleMoyHabit, labelInflation, labelInvCulture, labelPrixMoyM2Ans, labelNbGare, labelNbHabitant, labelNbMaisonVenduAns, labelNbAeroport};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(controller.getFONT());
            GridPane.setMargin(labels[i], new Insets(10));
            GridPane.setHalignment(labels[i], HPos.CENTER);
        }

        dataPane.add(labelCommunesVoisines, 0, 0);
        dataPane.add(sliderCommunesVoisines, 0, 1);

        dataPane.add(labelVenteApart, 1, 0);
        dataPane.add(sliderVenteApart, 1, 1);

        dataPane.add(labelTailleMoyHabit, 0, 2);
        dataPane.add(sliderTailleMoyHabit, 0, 3);

        dataPane.add(labelInflation, 1, 2);
        dataPane.add(sliderInflation, 1, 3);

        dataPane.add(labelInvCulture, 0, 4);
        dataPane.add(sliderInvCulture, 0, 5);

        dataPane.add(labelPrixMoyM2Ans, 1, 4);
        dataPane.add(sliderPrixMoyM2Ans, 1, 5);

        dataPane.add(labelNbGare, 0, 6);
        dataPane.add(sliderNbGare, 0, 7);

        dataPane.add(labelNbHabitant, 1, 6);
        dataPane.add(sliderNbHabitant, 1, 7);

        dataPane.add(labelNbMaisonVenduAns, 0, 8);
        dataPane.add(sliderNbMaisonVenduAns, 0, 9);

        dataPane.add(labelNbAeroport, 1, 8);
        dataPane.add(sliderNbAeroport, 1, 9);

        return dataPane;
    }
}
