package lk.UoGNiP.Entity;

import lk.UoGNiP.Data.Component;
import lk.UoGNiP.Data.Grade;
import lk.UoGNiP.Data.InputForm;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

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


    public Student(InputForm paramForm) {

        super();
        this.regNo = paramForm.getRegNo();
        this.fName = paramForm.getFName();
        this.lName = paramForm.getLName();

        this.ict01Marks = paramForm.getIct01Marks();
        this.ict02Marks = paramForm.getIct02Marks();

        this.groupCW01Marks = paramForm.getGroupCw01Marks();
        this.groupCW02Marks = paramForm.getGroupCw02Marks();
        this.overallMarks = setOverallMarks();
        this.overallGrade = setOverallGrade();

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

    private int setOverallMarks() {

        overallMarks = (int) (this.ict01Marks * 0.2 + this.ict02Marks * 0.2 +
                this.groupCW01Marks * 0.3 + this.groupCW02Marks * 0.3);
        return overallMarks;
    }

    public int getOverallMarks() {
        return overallMarks;
    }

    private Grade setOverallGrade() {

        if (overallMarks >= 40 && ((ict01Marks + ict02Marks) / 2) >= 30 && groupCW01Marks >= 30 &&
                groupCW02Marks >= 30) {

            if (overallMarks >= 70) overallGrade = Grade.FC;

            else if (overallMarks >= 60) overallGrade = Grade.SUC;

            else if (overallMarks >= 50) overallGrade = Grade.SLC;

            else overallGrade = Grade.P;

        } else if ((overallMarks >= 40) && ((ict01Marks + ict02Marks) / 2) < 30 || groupCW01Marks < 30 ||
                groupCW02Marks < 30) {

            overallGrade = Grade.F_Resit;
            if(((ict01Marks+ict02Marks)/2)<30) toResit.add(Component.Ict);
            if(groupCW01Marks<30) toResit.add(Component.GroupCw01);
            if(groupCW02Marks<30) toResit.add(Component.GroupCw02);

        } else if ((overallMarks >= 30 && overallMarks < 40)) overallGrade = Grade.F_Resit;

            if(((ict01Marks+ict02Marks)/2)<40) toResit.add(Component.Ict);
            if(groupCW01Marks<40) toResit.add(Component.GroupCw01);
            if(groupCW02Marks<40) toResit.add(Component.GroupCw02);

        else if (overallMarks < 30) overallGrade = Grade.F_Retake;

        return overallGrade;
    }

    public Grade getOverallGrade() {
        return overallGrade;
    }

    public List<Component> getToResit(){
        return toResit;
    }

    @Override
    public int compareTo(Student o) {
        return this.overallMarks - o.overallMarks;
    }
}
