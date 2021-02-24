package Lab05;

//Student Record Class
public class StudentRecord {

    //Variables
    private String studentID;
    private Float assignment;
    private Float midterms;
    private Float finals;
    private Float finalMark;
    private String letterGrade;

    //Variables when adding new data
    private String addStudentID;
    private String addAssignment;
    private String addMidterms;
    private String addFinals;


    //Constructor
    public StudentRecord() {
        this.studentID = "";
        this.assignment = 0f;
        this.midterms = 0f;
        this.finals = 0f;
    }

    public StudentRecord(String studentID, Float assignment, Float midterms, Float finals) {
        this.studentID = studentID;
        this.assignment = assignment;
        this.midterms = midterms;
        this.finals = finals;

        //Calculate  final mark and convert to letter grade
        this.finalMark = 0.5f * finals + 0.3f * midterms + 0.2f * assignment;
        this.letterGrade = convertGrade(finalMark);

    }

    public StudentRecord(String addStudentID, String addAssignment, String addMidterms, String addFinals) {
        this.addStudentID = addStudentID;
        this.addAssignment = addAssignment;
        this.addMidterms = addMidterms;
        this.addFinals = addFinals;


        //These variable convert the string value to float
        Float f1 = Float.parseFloat(addAssignment);
        Float f2 = Float.parseFloat(addMidterms);
        Float f3 = Float.parseFloat(addFinals);

        //Set the obtained data to the original variables
        this.studentID = addStudentID;
        this.assignment = f1;
        this.midterms = f2;
        this.finals = f3;

        //Calculate  final mark and convert to letter grade
        this.finalMark = 0.5f * f3 + 0.3f * f2 + 0.2f * f1;
        this.letterGrade = convertGrade(finalMark);
    }


    //Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Float getAssignment() {
        return assignment;
    }

    public void setAssignment(Float assignment) {
        this.assignment = assignment;
    }

    public Float getMidterms() {
        return midterms;
    }

    public void setMidterms(Float midterms) {
        this.midterms = midterms;
    }

    public Float getFinals() {
        return finals;
    }

    public void setFinals(Float finals) {
        this.finals = finals;
    }

    public Float getFinalMark() {
        return finalMark;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public String getAddStudentID() {
        return addStudentID;
    }

    public void setAddStudentID(String addStudentID) {
        this.addStudentID = addStudentID;
    }

    public String getAddAssignment() {
        return addAssignment;
    }

    public void setAddAssignment(String addAssignment) {
        this.addAssignment = addAssignment;
    }

    public String getAddMidterms() {
        return addMidterms;
    }

    public void setAddMidterms(String addMidterms) {
        this.addMidterms = addMidterms;
    }

    public String getAddFinals() {
        return addFinals;
    }

    public void setAddFinals(String addFinals) {
        this.addFinals = addFinals;
    }

    //This function gets the final mark and converts it to a letter grade
    public String convertGrade(Float finalMark) {
        String letterGrade = "";
        if (finalMark >= 80 && finalMark <= 100) {
            letterGrade += "A";
        }
        if (finalMark >= 70 && finalMark <= 79) {
            letterGrade += "B";
        }
        if (finalMark >= 60 && finalMark <= 69) {
            letterGrade += "C";
        }
        if (finalMark >= 50 && finalMark <= 59) {
            letterGrade += "D";
        }
        if (finalMark >= 0 && finalMark <= 49) {
            letterGrade += "F";
        }
        return letterGrade;
    }
}
