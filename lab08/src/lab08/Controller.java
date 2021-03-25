package lab08;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;


public class Controller {

    ObservableList<StudentRecord> marks = FXCollections.observableArrayList();
    //UI Variables
    @FXML
    private Stage stage;
    @FXML
    private TableView<StudentRecord> tableView;
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
    @FXML
    private MenuBar menuBar;
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

    private String currentFilename;

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
        addID.clear();
        addAssignment.clear();
        addFinal.clear();
        addMidterm.clear();

    }

    //Functions for Menu

    @FXML
    public void handleKeyInput() {

    }

    //New table set
    @FXML
    public void onNew() {
        tableView.getItems().clear();
    }

    //Opens a file ands loads the data
    @FXML
    public void load() throws Exception {
//Creating a File chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");


        File file = fileChooser.showOpenDialog(stage);
        currentFilename = file.getAbsolutePath();
        String fieldDelimiter = ",";

        BufferedReader reader = new BufferedReader(new FileReader(currentFilename));
        String line;
        while((line = reader.readLine()) != null){
            String[] fields = line.split(fieldDelimiter,-1);
            StudentRecord data = new StudentRecord(fields[0],fields[1],fields[2],fields[3]);
            marks.add(data);
        }

    }

    //Exits the application
    @FXML
    public void onExit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }

    //Saving the data
    @FXML
    public void save(ActionEvent event) throws Exception {
        ObservableList<StudentRecord> studentRecords = tableView.getItems();
        //Saving the File
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(currentFilename));
        for (StudentRecord grades : studentRecords) {
            String text = grades.getStudentID() + "," + grades.getAssignment() + "," + grades.getMidterms() + "," + grades.getFinals();
            outWriter.write(text);
            outWriter.newLine();
        }
        outWriter.close();
    }

    @FXML
    public void saveAs(ActionEvent event) throws Exception {
        //Creating a File chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", ".csv"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text", ".txt"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            handleSave(tableView.getItems(), file);
        }
    }

    //
    @FXML
    public void handleSave(ObservableList<StudentRecord> studentRecords, File file) throws Exception {
        //Saving the File
        BufferedWriter outWriter = new BufferedWriter(new FileWriter(file));
        for (StudentRecord grades : studentRecords) {
            String text = grades.getStudentID() + "," + grades.getAssignment() + "," + grades.getMidterms() + "," + grades.getFinals();
            outWriter.write(text);
            outWriter.newLine();
        }
        outWriter.close();
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


        tableView.setItems(marks);
    }


}

