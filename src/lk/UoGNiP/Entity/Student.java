package lk.UoGNiP.Entity;

import lk.UoGNiP.Data.Component;
import lk.UoGNiP.Data.Grade;
import lk.UoGNiP.Data.InputForm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>, Serializable {

    private String regNo;
    private String fName;
    private String lName;

    private int ict01Marks;
    private int ict02Marks;
    private int groupCW01Marks;
    private int groupCW02Marks;

    private int overallMarks;
    private Grade overallGrade;

    private List<Component> toResit = new ArrayList<Component>();


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

    private int setOverallMarks() {
        overallMarks = (int) (this.ict01Marks * 0.2 + this.ict02Marks * 0.2 +
                this.groupCW01Marks * 0.3 + this.groupCW02Marks * 0.3);
        return overallMarks;
    }

    private Grade setOverallGrade(){
        if(overallMarks>=40 && (ict01Marks+ict02Marks)/2 >=30 && groupCW01Marks >=30 && groupCW02Marks >=30){
            if (overallMarks >= 70) overallGrade = Grade.First_Class;
            else if (overallMarks >= 60) overallGrade = Grade.Second_Class_Upper;
            else if (overallMarks >= 50) overallGrade = Grade.Second_Class_Lower;
            else overallGrade = Grade.General_Pass;
        }
        else if(overallMarks<30) overallGrade = Grade.Fail_Retake;
        else {
            overallGrade = Grade.Resit;
            if ((overallMarks >= 40 && (ict01Marks+ict02Marks)/2<30)||
                    (overallMarks<40 && (ict01Marks+ict02Marks)/2<40)) toResit.add(Component.Ict);
            if ((overallMarks >= 40 && groupCW01Marks<30)||
                    (overallMarks < 40 && groupCW01Marks < 40)) toResit.add(Component.GroupCw01);
            if ((overallMarks >= 40 && groupCW02Marks<30)||
                    (overallMarks < 40 && groupCW02Marks < 40)) toResit.add(Component.GroupCw02);
        }
        return overallGrade;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public int getIct01Marks() {
        return ict01Marks;
    }

    public int getIct02Marks() {
        return ict02Marks;
    }

    public int getGroupCW01Marks() {
        return groupCW01Marks;
    }

    public int getGroupCW02Marks() {
        return groupCW02Marks;
    }

    public int getOverallMarks() {
        return overallMarks;
    }

    public Grade getOverallGrade() {
        return overallGrade;
    }

    public List<Component> getToResit() {
        return toResit;
    }

    public void printStudentDetails() {
        System.out.println("REGISTRATION NUMBER: " + this.getRegNo() +
                "\nNAME: " + this.getFName() + " " + this.getLName() +
                "\nOVERALL MARKS: " + this.getOverallMarks() +
                "\nOVERALL GRADE: " + this.getOverallGrade());
    }

    @Override
    public int compareTo(Student o) {
        return this.overallMarks - o.overallMarks;
    }
}
