package lab09;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light.*;
import javafx.scene.paint.Color;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    // Canvas variable
    @FXML
    Canvas canvas;


    // FUNCTIONS

    /**
     * Function to read a url link
     */
    public static Double[] downloadStockPrices(String stockTicker) throws Exception {

        ArrayList<String> outputs = new ArrayList<>();

        URL url = new URL(" https://query1.finance.yahoo.com/v7/finance/download/" + stockTicker + "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");

        URLConnection connection = url.openConnection();
        connection.setDoOutput(false);
        connection.setDoInput(true);

        InputStreamReader inputStream = new InputStreamReader(connection.getInputStream());

        BufferedReader reader = new BufferedReader(inputStream);

        String line;

        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            String closePrice = values[4];
            outputs.add(closePrice);
        }

        Double[] doubles = new Double[outputs.size()];
        double sum = 0;
        for (int i = 0; i < outputs.size(); i++) {
            doubles[i] = Double.parseDouble(outputs.get(i));
        }

        return doubles;
    }

    /**
     * Function to draw line in plot
     */
    public static void plotLine(GraphicsContext gc,int width, int height,int gap, Double[] list, Color color) {
        int maxData = 1000;
        //Scale the plot
        double xScale = ((double) width-2*gap)/ (list.length-1);
        double yScale = ((double) height-2*gap)/(maxData -1);

        //Create data points from the list
        ArrayList<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < list.length; i++){
            int x1 = (int)(i * xScale + gap);
            int y1 = (int)((maxData - list[i]) * yScale + gap);
            graphPoints.add(new Point(x1,y1));
        }

        for (int i = 0; i < list.length-1;i++){
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i+1).x;
            int y2 = graphPoints.get(i +1).y;
            gc.setStroke(color);
            gc.strokeLine(x1,y1,x2,y2);
        }
    }

    /**
     * Function to draw the plot
     */
    public static void drawLinePlot(GraphicsContext gc, Double[] list1, Double[] list2) {
        int height = 600;
        int width = 600;
        int borderGap = 50;

        //Set y-axis for scatter plot
        gc.setFill(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeLine(borderGap,width-borderGap,borderGap,borderGap);

        //Set x-axis for scatter plot
        gc.setFill(Color.BLACK);
        gc.setLineWidth(3);
        gc.strokeLine(borderGap, height-borderGap,width+borderGap,height-borderGap);

        //Call plot line to draw the line graph
        Color c1 = Color.RED;
        Color c2 = Color.BLUE;

        plotLine(gc,width, height,borderGap, list1, c1);
        plotLine(gc,width, height,borderGap, list2, c2);
    }


    /**
     * Initialize Function
     */
    @FXML
    private void initialize() throws Exception {

        String stockTicker1 = "GOOGL";
        String stockTicker2 = "AMZN";
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawLinePlot(gc, downloadStockPrices(stockTicker1), downloadStockPrices(stockTicker2));
    }


}
