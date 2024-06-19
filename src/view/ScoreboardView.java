package view;

import controller.communesController;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

public class ScoreboardView {

    private GridPane scoreboardPane;
    private final BarChart<String, Number> barChart;

    public ScoreboardView(communesController controller) {
        scoreboardPane = new GridPane();

        // Define the category axis
        final CategoryAxis xAxis = new CategoryAxis();

        // Define the value axis
        final NumberAxis yAxis = new NumberAxis();

        // Create the bar chart
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Moyenne attractivité des communes par département");

        // Prepare data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Departements");

        // Adding data to the series
        series.getData().add(new XYChart.Data<>("Finistère", 29));
        series.getData().add(new XYChart.Data<>("Coted D'Armor", 22));
        series.getData().add(new XYChart.Data<>("Morbihan", 56));
        series.getData().add(new XYChart.Data<>("Commune 4", 35));

        // Add the series to the chart
        barChart.getData().add(series);
        barChart.setPrefSize(controller.getImgSize() * 7, controller.getImgSize() * 7);
        barChart.setLegendVisible(false);
        barChart.setBarGap(3);
        barChart.setAnimated(true);

        scoreboardPane.add(barChart, 0, 0);
    }

    public GridPane getPane() {
        return scoreboardPane;
    }

}
