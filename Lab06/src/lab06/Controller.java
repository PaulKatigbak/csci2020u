package lab06;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class Controller {

    /**
     * Data Variables for Bar graph
     */
    private static final double[] avgHousingPricesByYear = {247381.0, 264171.4, 287715.3, 294736.1,
            308431.4, 322635.9, 340253.0, 363153.7};
    private static final double[] avgCommercialPricesByYear = {1121585.3, 1219479.5, 1246354.2, 1295364.8,
            1335932.6, 1472362.0, 1583521.9, 1613246.3};

    /**
     * Data variables for Pie chart
     */
    private static final String[] ageGroups = {
            "18-25:", "26-35:", "36-45:", "46-55:", "56-65:", "65+:"
    };
    private static final String[] dataPercentage = {"5.7%", "8.9%", "21.5%", "27.8%", "16.4%", "19.7%"};
    private static final int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private final static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    /**
     * Set stage
     *
     * @FXML variables
     */
    @FXML
    private Canvas canvas;


    /**
     * Initialize Function
     */
    @FXML
    private void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawBarGraph(gc);
        drawPieChart(gc);
        setDataPie(gc);
    }


    // FUNCTIONS

    /**
     * Function to draw pie chart
     * References taken from TA demo
     *
     * @param gc GraphicsContext
     */
    public void drawPieChart(GraphicsContext gc) {

        Font font = new Font("Arial", 36);
        gc.setFont(font);
        gc.setFill(Color.BLUE);
        gc.fillText("Pie Chart", 800, 100);

        int numOfGroups = 0;
        for (int peopleByAgeGroups : purchasesByAgeGroup) {
            numOfGroups += peopleByAgeGroups;
        }

        double startAngle = 0.0;
        for (int i = 0; i < purchasesByAgeGroup.length; i++) {
            double slicePercentage = (double) purchasesByAgeGroup[i] / (double) numOfGroups;
            double sweepAngle = slicePercentage * 360.0;

            gc.setStroke(Color.BLACK);
            gc.setFill(pieColours[i]);
            gc.fillArc(700, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);
            gc.strokeArc(700, 150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);

            startAngle += sweepAngle;
        }
    }

    public void setDataPie(GraphicsContext gc) {
        int xAxis = 550;
        int[] yAxis = {300, 280, 260, 240, 220, 200};

        Font font1 = new Font("Arial", 26);
        gc.setFont(font1);
        gc.setFill(Color.BLACK);
        gc.fillText("Legend:", 570, 170);

        for (int i = 0; i < ageGroups.length; i++) {
            Font font = new Font("Arial", 20);
            gc.setFont(font);
            gc.setFill(pieColours[i]);
            gc.fillText(ageGroups[i], xAxis, yAxis[i]);
            gc.fillText(dataPercentage[i], 620, yAxis[i]);
        }
    }


    /**
     * Function to draw bar graph
     *
     * @param gc GraphicsContext
     */
    public void drawBarGraph(GraphicsContext gc) {
        Font font = new Font("Arial", 36);
        gc.setFont(font);
        gc.setFill(Color.RED);
        gc.fillText("Bar Graph", 50, 100);



         // Loop creates rectangles based on avgHousingPricesByYear

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            double current = avgHousingPricesByYear[i] / 4000;
            gc.setStroke(Color.BLACK);
            gc.setFill(Color.RED);
            gc.fillRect(40 * i, 450 - current, 15, current);
            gc.strokeRect(40 * i, 450 - current, 15, current);
        }


         // Loop creates rectangles based on avgCommercialPricesByYear

        for (int i = 0; i < avgCommercialPricesByYear.length; i++) {
            double current = avgCommercialPricesByYear[i] / 5000;
            gc.setStroke(Color.BLACK);
            gc.setFill(Color.BLUE);
            gc.fillRect(40 * i + 15, 450 - current, 15, current);
            gc.strokeRect(40 * i + 15, 450 - current, 15, current);

        }

    }

}
