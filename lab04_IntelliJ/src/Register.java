import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Register extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button button1 = new Button();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 04 Solution");

        // Sets the grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Label and input box for username
        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 0);

        TextField userInput = new TextField("");
        GridPane.setConstraints(userInput, 1, 0);

        // Label and input box for password
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Enter your password");
        GridPane.setConstraints(passInput, 1, 1);

        // Label and input box for Full name
        Label fullNameLabel = new Label("Full Name:");
        GridPane.setConstraints(fullNameLabel, 0, 2);

        TextField fullNameInput = new TextField("");
        GridPane.setConstraints(fullNameInput, 1, 2);

        // Label and input box for e-mail address
        Label mailLabel = new Label("E-mail:");
        GridPane.setConstraints(mailLabel, 0, 3);

        TextField mailInput = new TextField("");
        GridPane.setConstraints(mailInput, 1, 3);

        // Label and input box for phone number
        Label phoneLabel = new Label("Phone#(Use a '-'):");
        GridPane.setConstraints(phoneLabel, 0, 4);

        TextField phoneInput = new TextField("");
        GridPane.setConstraints(phoneInput, 1, 4);

        //Label and input for date of birth
        Label birthLabel = new Label("Date of Birth:");
        GridPane.setConstraints(birthLabel, 0, 5);

        DatePicker birthInput = new DatePicker();
        GridPane.setConstraints(birthInput, 1, 5);


        // Set button for scene
        button1.setText("Register");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.printf(
                        "Registration Validation!%n%nUsername: %s %nPassword: %s %nFull Name: %s %nEmail: %s %nPhone Number: %s %nDate of Birth: %s",
                        userInput.getText(), passInput.getText(), fullNameInput.getText(), mailInput.getText(),
                        checkPhone(phoneInput),birthInput.getValue());
            }
        });
        GridPane.setConstraints(button1, 0, 6);
        // Show the User Interface
        Scene mainScene = new Scene(grid, 400, 350);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        grid.getChildren().addAll(userLabel, userInput, passLabel, passInput, fullNameLabel, fullNameInput, phoneLabel,
                mailLabel, mailInput, phoneInput,birthLabel,birthInput, button1);
    }

    public String checkPhone(TextField input) {
        String phoneNum = input.getText();
        if (phoneNum.matches("[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}")) {
            phoneNum = input.getText();
        } else {
            phoneNum = "Error! Invalid format/input";
        }
        return phoneNum;
    }
}
