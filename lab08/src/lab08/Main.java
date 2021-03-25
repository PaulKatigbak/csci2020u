/**
 * Lab 08
 *@author: Paul Katigbak
 *created on 03/23/2021
 */


package lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 08");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


}
