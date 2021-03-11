/**
 * Lab 06
 *@author: Paul Katigbak
 *created on 03/10/2021
 */

package lab06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 06");
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
