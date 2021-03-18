package lab07;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

import java.util.TreeMap;


public class Controller {


    /**
     * Data variables for Pie chart
     */
    private TreeMap<String, Integer>countMap;
    private static final String[] disasterGroup = {
            "TORNADO", "SPECIAL MARINE", "SEVERE THUNDERSTORM","FLASH FLOOD"
    };

    private final static int[] countNum = {4849,18041,4007,2298};
    private final static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON
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


        drawPieChart(gc);
        setDataPie(gc);
    }


    // FUNCTIONS

    /**
     * Function to draw pie chart
     * Taken from previous lab
     *
     * @param gc GraphicsContext
     */

    public void drawPieChart(GraphicsContext gc) {

        int numOfGroups = 0;
        for (int numOfDisaster : countNum) {
            numOfGroups += numOfDisaster;
        }

        double startAngle = 0.0;
        for (int i = 0; i < countNum.length; i++) {
            double slicePercentage = (double) countNum[i] / (double) numOfGroups;
            double sweepAngle = slicePercentage * 360.0;

            gc.setStroke(Color.BLACK);
            gc.setFill(pieColours[i]);
            gc.fillArc(280, 50, 300, 300, startAngle, sweepAngle, ArcType.ROUND);
            gc.strokeArc(280, 50, 300, 300, startAngle, sweepAngle, ArcType.ROUND);

            startAngle += sweepAngle;
        }
    }


    public void setDataPie(GraphicsContext gc) {
        int xAxis = 100;
        int[] yAxis = {195, 155, 115, 75};


        for (int i = 0; i < disasterGroup.length; i++) {
            Font font = new Font("Arial", 14);
            gc.setFont(font);
            gc.setFill(Color.BLACK);
            gc.fillText(disasterGroup[i], xAxis, yAxis[i]);

            gc.setFill(pieColours[3]);
            gc.strokeRect(40,180,40,25);
            gc.fillRect(40,180,40,25);
            gc.setFill(pieColours[2]);
            gc.strokeRect(40,140,40,25);
            gc.fillRect(40,140,40,25);
            gc.setFill(pieColours[1]);
            gc.strokeRect(40,100,40,25);
            gc.fillRect(40,100,40,25);
            gc.setFill(pieColours[0]);
            gc.strokeRect(40,60,40,25);
            gc.fillRect(40,60,40,25);

        }
    }
}
