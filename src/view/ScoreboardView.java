package view;

import controller.communesController;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;

public class ScoreboardView {

    public GridPane getPane(communesController controller) {
                GridPane scoreboardPane = new GridPane();

                // Define the X-axis
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Month");

        // Define the Y-axis
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Sales");

        // Create the line chart
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Monthly Sales Data");

        // Prepare data
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("My plot");

        // Adding data to the series
        series.getData().add(new XYChart.Data<>(1, 23));
        series.getData().add(new XYChart.Data<>(2, 14));
        series.getData().add(new XYChart.Data<>(3, 15));
        series.getData().add(new XYChart.Data<>(4, 24));
        series.getData().add(new XYChart.Data<>(5, 34));
        series.getData().add(new XYChart.Data<>(6, 36));
        series.getData().add(new XYChart.Data<>(7, 22));
        series.getData().add(new XYChart.Data<>(8, 45));
        series.getData().add(new XYChart.Data<>(9, 43));
        series.getData().add(new XYChart.Data<>(10, 17));
        series.getData().add(new XYChart.Data<>(11, 29));
        series.getData().add(new XYChart.Data<>(12, 35));

        // Add the series to the chart
        lineChart.getData().add(series);
        lineChart.setPrefSize(controller.getImgSize()*7, controller.getImgSize()*7);
        lineChart.setCreateSymbols(true);
        lineChart.setLegendVisible(true);
        lineChart.setAnimated(true);

        scoreboardPane.add(lineChart, 0, 0);

        return scoreboardPane;
    }

}
