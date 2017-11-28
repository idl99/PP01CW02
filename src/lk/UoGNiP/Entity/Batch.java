package lk.UoGNiP.Entity;


import lk.UoGNiP.Data.Component;
import lk.UoGNiP.Data.Grade;

import java.util.*;

public class Batch {

    private List<Student> list_Of_Students = new ArrayList<>();

    public Batch(List<Student> paramListOfStudents) {

        this.list_Of_Students = paramListOfStudents;

    }

    public double getIct01ClassAvg() {
        double ict01ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) (Integer) student.getIct01Marks();
        }

        ict01ClassAvg = total / this.list_Of_Students.size();
        return ict01ClassAvg;
    }

    public double getIct02ClassAvg() {
        double ict02ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) (Integer) student.getIct02Marks();
        }

        ict02ClassAvg = total / this.list_Of_Students.size();
        return ict02ClassAvg;
    }

    public double getGroupCW01ClassAvg() {
        double groupCW01ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) (Integer) student.getGroupCW01Marks();
        }

        groupCW01ClassAvg = total / this.list_Of_Students.size();
        return groupCW01ClassAvg;
    }

    public double getGroupCW02ClassAvg() {
        double groupCW02ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) (Integer) student.getGroupCW02Marks();
        }

        groupCW02ClassAvg = total / this.list_Of_Students.size();
        return groupCW02ClassAvg;
    }

    public double getOverallClassAvg() {
        double overallClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) (Integer) student.getOverallMarks();
        }

        overallClassAvg = total / this.list_Of_Students.size();
        return overallClassAvg;
    }

    public List<Student> ict01MarksBelow30(){
        List<Student> listOfStd = new ArrayList<Student>();
        for(Student std: list_Of_Students){
            if (std.getIct01Marks()<30) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> ict02MarksBelow30(){
        List<Student> listOfStd = new ArrayList<Student>();
        for(Student std: list_Of_Students){
            if (std.getIct02Marks()<30) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> groupCw01MarksBelow30(){
        List<Student> listOfStd = new ArrayList<Student>();
        for(Student std: list_Of_Students){
            if (std.getGroupCW01Marks()<30) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> groupCw02MarksBelow30(){
        List<Student> listOfStd = new ArrayList<Student>();
        for(Student std: list_Of_Students){
            if (std.getGroupCW02Marks()<30) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> getStdsBelowOverallClassAvg() {
        List<Student> stdsBelowClassAvg = new ArrayList<>();
        double batchAvg = getOverallClassAvg();
        for (Student student : this.list_Of_Students) {
            if (student.getOverallMarks() < batchAvg) stdsBelowClassAvg.add(student);
        }
        return stdsBelowClassAvg;
    }

    public List<Student> getStdsAboveOverallClassAvg() {
        List<Student> stdsAboveClassAvg = new ArrayList<>();
        double batchAvg = getOverallClassAvg();
        for (Student student : this.list_Of_Students) {
            if (student.getOverallMarks() > batchAvg) stdsAboveClassAvg.add(student);
        }
        Collections.sort(stdsAboveClassAvg, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getOverallMarks() - o2.getOverallMarks();
            }
        });
        return (stdsAboveClassAvg);
    }

    public Student getIct01HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getIct01Marks() > max) {
                highestScorer = student;
                max = highestScorer.getIct01Marks();
            }
        }
        return highestScorer;
    }

    public Student getIct02HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getIct02Marks() > max) {
                highestScorer = student;
                max = highestScorer.getIct02Marks();
            }
        }
        return highestScorer;
    }

    public Student getGroupCW01HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getGroupCW01Marks() > max) {
                highestScorer = student;
                max = highestScorer.getGroupCW01Marks();
            }
        }
        return highestScorer;
    }

    public Student getGroupCW02HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getGroupCW02Marks() > max) {
                highestScorer = student;
                max = highestScorer.getGroupCW02Marks();
            }
        }
        return highestScorer;
    }

    public Student getOverallHighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getOverallMarks() > max) {
                highestScorer = student;
                max = highestScorer.getOverallMarks();
            }
        }
        return highestScorer;
    }

    public Student getOverallLowestScorer() {
        int min = list_Of_Students.get(0).getOverallMarks();
        Student lowestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getIct01Marks() < min) {
                lowestScorer = student;
                min = lowestScorer.getOverallMarks();
            }
        }
        return lowestScorer;
    }

    public List<Student> getListOfRetakeStudents() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student student : list_Of_Students) {
            if (student.getOverallGrade() == Grade.F_Retake) listOfStd.add(student);
        }
        return listOfStd;
    }

    public List<Student> getListOfIctResits(){
        List<Student> listOfStd = new ArrayList<>();
        for (Student std: list_Of_Students){
            if(std.getToResit().contains(Component.Ict)) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> getListOfGroupCW01Resits(){
        List<Student> listOfStd = new ArrayList<>();
        for (Student std: list_Of_Students){
            if(std.getToResit().contains(Component.GroupCw01)) listOfStd.add(std);
        }
        return listOfStd;
    }

    public List<Student> getListOfGroupCW02Resits(){
        List<Student> listOfStd = new ArrayList<>();
        for (Student std: list_Of_Students){
            if(std.getToResit().contains(Component.GroupCw02)) listOfStd.add(std);
        }
        return listOfStd;
    }

}