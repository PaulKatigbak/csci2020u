package Lab05;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<StudentRecord, String> ID;
    @FXML
    private TableColumn<StudentRecord, Float> assignment;
    @FXML
    private TableColumn<StudentRecord, Float> midterm;
    @FXML
    private TableColumn<StudentRecord, Float> finalExam;
    @FXML
    private TableColumn<StudentRecord, Float> finalMark;
    @FXML
    private TableColumn<StudentRecord, String> letterGrade;


    //Variable for Text field
    @FXML
    private TextField addID;
    @FXML
    private TextField addAssignment;
    @FXML
    private TextField addMidterm;
    @FXML
    private TextField addFinal;
    @FXML
    private Label response1;
    @FXML
    private Label response2;
    @FXML
    private Label response3;
    @FXML
    private Label response4;

    //Function to add new data
    @FXML
    protected void add(ActionEvent event) throws Exception {
        ObservableList<StudentRecord> marks = tableView.getItems();
        if (addID.getText().isEmpty()) {
            response1.setText("Please enter ID!");
            response1.setStyle("-fx-text-fill: red");
        }
        if (addAssignment.getText().isEmpty()) {
            response2.setText("Please enter Grade!");
            response2.setStyle("-fx-text-fill: red");
        }
        if (addMidterm.getText().isEmpty()) {
            response3.setText("Please enter Grade!");
            response3.setStyle("-fx-text-fill: red");
        }
        if (addFinal.getText().isEmpty()) {
            response4.setText("Please enter Grade!");
            response4.setStyle("-fx-text-fill: red");
        }

        marks.add(new StudentRecord(addID.getText(), addAssignment.getText(), addMidterm.getText(), addFinal.getText()));

    }


    //Initialize
    @FXML
    public void initialize() {
        ID.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        assignment.setCellValueFactory(new PropertyValueFactory<>("assignment"));

        midterm.setCellValueFactory(new PropertyValueFactory<>("midterms"));
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finals"));
        finalMark.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));


        tableView.setItems(DataSource.getAllMarks());
    }


}

