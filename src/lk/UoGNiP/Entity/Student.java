package lk.UoGNiP.Entity;

import lk.UoGNiP.Data.Resit;
import lk.UoGNiP.Data.Grade;
import lk.UoGNiP.Data.InputForm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Student Class which creates Student Objects
// Implements Serializable to mark class as writable object to Byte stream file
public class Student implements Serializable {

    static final long serialVersionUID=0L;

    // Attributes of Student object

    // Student Registration number
    private String regNo;
    // Student First name
    private String fName;
    // Student Last name
    private String lName;

    // Student Ict 01 Marks
    private int ict01Marks;
    // Student Ict 02 Marks
    private int ict02Marks;
    // Student Group Coursework 01 Marks
    private int groupCW01Marks;
    // Student Group Coursework 02 Marks
    private int groupCW02Marks;

    // Student Overall Marks
    private int overallMarks;
    // Student Overall Grade
    private Grade overallGrade;

    // Student Component to be resit
    private List<Resit> toResit = new ArrayList<Resit>();


    // Constructor method for Student Class.
    // Accepts an InputForm object from which you're receiving the Student details
    // as parameter and constructs a Student object.
    public Student(InputForm inputForm) {

        this.regNo = inputForm.getRegNo();
        this.fName = inputForm.getFName();
        this.lName = inputForm.getLName();

        this.ict01Marks = inputForm.getIct01Marks();
        this.ict02Marks = inputForm.getIct02Marks();
        this.groupCW01Marks = inputForm.getGroupCw01Marks();
        this.groupCW02Marks = inputForm.getGroupCw02Marks();

        this.overallMarks = setOverallMarks();
        this.overallGrade = setOverallGrade();
    }

    // Setter method for overallMarks of Student.
    // Gets marks of Student for each individual component and calculates the
    //      overall mark based on the following weightage:
    //      1) Ict 01 => 20%
    //      2) Ict 02 => 20%
    //      3) Group Coursework 01 => 30%
    //      4) Group Coursework 02 => 30%
    // Returns the overall marks of Student.

    private int setOverallMarks() {
        overallMarks = (int) (this.ict01Marks * 0.2 + this.ict02Marks * 0.2 +
                this.groupCW01Marks * 0.3 + this.groupCW02Marks * 0.3);
        return overallMarks;
    }

    // Setter method for overallGrade of Student.
    // Get components' marks and overall mark of Student and determines the overall grade.
    // Returns the overall grade of Student.
    private Grade setOverallGrade(){
        if(overallMarks>=40 && (ict01Marks+ict02Marks)/2 >=30 && groupCW01Marks >=30 && groupCW02Marks >=30){

            // Check if student has passed the overall module, by passing all components and
            // obtained overall mark equal to or greater than 40

            if (overallMarks >= 70) overallGrade = Grade.First_Class;
            else if (overallMarks >= 60) overallGrade = Grade.Second_Class_Upper;
            else if (overallMarks >= 50) overallGrade = Grade.Second_Class_Lower;
            else overallGrade = Grade.General_Pass;
        }
        else if(overallMarks<30)
            // Check if student has failed the module, by failing to obtain minimum module mark of 30
            overallGrade = Grade.Fail_Retake;
        else {
            // Student has neither failed nor passed the component, meaning Student has to Resit
            // selected components
            overallGrade = Grade.Resit;
            if ((overallMarks >= 40 && (ict01Marks+ict02Marks)/2<30)||
                    (overallMarks<40 && (ict01Marks+ict02Marks)/2<40))
                // Check if Student needs to resit qualifying set Ict. If yes, add Ict to list of
                // components Student needs to resit
                toResit.add(Resit.Resit_Ict);
            if ((overallMarks >= 40 && groupCW01Marks <30)|| (overallMarks < 40 && groupCW01Marks < 40))
                // Check if Student needs to resit Group Coursework 1. If yes, add Group Coursework 1 to list of
                // components Student needs to resit
                toResit.add(Resit.Resit_GroupCw01);
            if ((overallMarks >= 40 && groupCW02Marks <30)|| (overallMarks < 40 && groupCW02Marks < 40))
                // Check if Student needs to resit Group Coursework 1. If yes, add Group Coursework 1 to list of
                // components Student needs to resit
                toResit.add(Resit.Resit_GroupCw02);
        }
        return overallGrade;
    }

    // Getter method for Student Registration number.
    public String getRegNo() {return regNo;}

    // Getter methods for Student First and Last name.
    public String getFName() {return fName;}

    public String getLName() {return lName;}

    // Getter methods for Components' marks
    public int getIct01Marks() {return ict01Marks;}

    public int getIct02Marks() {return ict02Marks;}

    public int getGroupCW01Marks() {return groupCW01Marks;}

    public int getGroupCW02Marks() {return groupCW02Marks;}

    // Getter method for Student overall marks
    public int getOverallMarks() {return overallMarks;}

    // Getter method for Student overall grade
    public Grade getOverallGrade() {return overallGrade;}

    // Getter method to get List of components for which Student has to resit
    public List<Resit> getToResit(){return toResit;}

    // Void method to print basic details of Student
    public void printStudentDetails() {
        System.out.println("REGISTRATION NUMBER: " + this.getRegNo() +
                "\nNAME: " + this.getFName() + " " + this.getLName() +
                "\nOVERALL MARKS: " + this.getOverallMarks() +
                "\nOVERALL GRADE: " + this.getOverallGrade());
    }
}
