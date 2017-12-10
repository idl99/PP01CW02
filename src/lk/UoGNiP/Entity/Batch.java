package lk.UoGNiP.Entity;

import lk.UoGNiP.Comparator.LastNameComparator;
import lk.UoGNiP.Comparator.OverallMarkComparator;
import lk.UoGNiP.Data.Resit;
import lk.UoGNiP.Data.Grade;

import java.util.*;

public class Batch {

    private List<Student> listOfStudents = new ArrayList<>();

    public Batch(List<Student> paramListOfStudents) {

        this.listOfStudents = paramListOfStudents;

    }

    // Custom Bubble sort method
    public void sort(List<Student> paramList, Comparator<Student> comparator){
        int length = paramList.size();
        Student temp = null;
        for(int i=0; i < length; i++) {// Outer Loop of the Bubble sort
            for (int j = 1; j < (length - i); j++) {// Inner Loop of the Bubble sort
                if (comparator.compare(paramList.get(j - 1), paramList.get(j)) < 0){
                    // Swap elements
                    temp = paramList.get(j - 1);
                    paramList.set(j - 1, paramList.get(j));
                    paramList.set(j, temp);
                }
            }

        }
    }

    // Method to calculate class average for Ict 01
    public double getIct01ClassAvg() {
        double ict01ClassAvg;
        double total = 0.0;

        for (Student student : this.listOfStudents) {
            total += (double) student.getIct01Marks();
        }

        ict01ClassAvg = total / this.listOfStudents.size();
        return ict01ClassAvg;
    }

    // Method to calculate class average for Ict 02
    public double getIct02ClassAvg() {
        double ict02ClassAvg;
        double total = 0.0;

        for (Student student : this.listOfStudents) {
            total += (double) student.getIct02Marks();
        }

        ict02ClassAvg = total / this.listOfStudents.size();
        return ict02ClassAvg;
    }

    // Method to calculate class average for Group Coursework 01
    public double getGroupCW01ClassAvg() {
        double groupCW01ClassAvg;
        double total = 0.0;

        for (Student student : this.listOfStudents) {
            total += (double) student.getGroupCW01Marks();
        }

        groupCW01ClassAvg = total / this.listOfStudents.size();
        return groupCW01ClassAvg;
    }

    // Method to calculate class average for Group Coursework 2
    public double getGroupCW02ClassAvg() {
        double groupCW02ClassAvg;
        double total = 0.0;

        for (Student student : this.listOfStudents) {
            total += (double) student.getGroupCW02Marks();
        }

        groupCW02ClassAvg = total / this.listOfStudents.size();
        return groupCW02ClassAvg;
    }

    // Method to calculate class average for overall module
    public double getOverallClassAvg() {
        double overallClassAvg;
        double total = 0.0;

        for (Student student : this.listOfStudents) {
            total += (double) student.getOverallMarks();
        }

        overallClassAvg = total / this.listOfStudents.size();
        return overallClassAvg;
    }

    // Method to obtain the count of Student who've obtained below 30 for Ict 01
    public int numOfIct01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getIct01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    // Method to obtain the count of Student who've obtained below 30 for Ict 02
    public int numOfIct02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getIct02Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    // Method to obtain the count of Student who've obtained below 30 for Group Coursework 01
    public int numOfGroupCw01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getGroupCW01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    // Method to obtain the count of Student who've obtained below 30 for Group Coursework 02
    public int numOfGroupCw02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getGroupCW02Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    // Method to get the list of students below class average for overall module
    public List<Student> getStdsBelowOverallClassAvg() {
        List<Student> stdsBelowClassAvg = new ArrayList<>();
        double batchAvg = getOverallClassAvg();
        for (Student student : this.listOfStudents) {
            if (student.getOverallMarks() < batchAvg) stdsBelowClassAvg.add(student);
        }
        return stdsBelowClassAvg;
    }

    // Method to get the list of students above class average for overall module
    public List<Student> getStdsAboveOverallClassAvg() {
        List<Student> stdsAboveClassAvg = new ArrayList<>();
        double batchAvg = getOverallClassAvg();
        for (Student student : this.listOfStudents) {
            if (student.getOverallMarks() > batchAvg) stdsAboveClassAvg.add(student);
        }
        sort(stdsAboveClassAvg,new OverallMarkComparator());
        return stdsAboveClassAvg;
    }

    // Method to get highest scoring Student for Ict 01
    public Student getIct01HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getIct01Marks() > max) {
                highestScorer = student;
                max = highestScorer.getIct01Marks();
            }
        }
        return highestScorer;
    }

    // Method to get highest scoring Student for Ict 02
    public Student getIct02HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getIct02Marks() > max) {
                highestScorer = student;
                max = highestScorer.getIct02Marks();
            }
        }
        return highestScorer;
    }

    // Method to get highest scoring Student for Group Coursework 01
    public Student getGroupCW01HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getGroupCW01Marks() > max) {
                highestScorer = student;
                max = highestScorer.getGroupCW01Marks();
            }
        }
        return highestScorer;
    }

    // Method to get highest scoring Student for Group Coursework 02
    public Student getGroupCW02HighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getGroupCW02Marks() > max) {
                highestScorer = student;
                max = highestScorer.getGroupCW02Marks();
            }
        }
        return highestScorer;
    }

    // Method to get highest scoring Student for overall module
    public Student getOverallHighestScorer() {
        int max = 0;
        Student highestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getOverallMarks() > max) {
                highestScorer = student;
                max = highestScorer.getOverallMarks();
            }
        }
        return highestScorer;
    }

    // Method to get lowest scoring Student for overall module
    public Student getOverallLowestScorer() {
        int min = 100;
        Student lowestScorer = null;
        for (Student student : this.listOfStudents) {
            if (student.getOverallMarks() < min) {
                lowestScorer = student;
                min = lowestScorer.getOverallMarks();
            }
        }
        return lowestScorer;
    }

    // Method to get list of Student to retake module
    public List<Student> getListOfRetakeStudents() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student student : listOfStudents) {
            if (student.getOverallGrade() == Grade.Fail_Retake) listOfStd.add(student);
        }
        return listOfStd;
    }

    // Method to get list of Student to resit Ict Component
    public List<Student> getListOfIctResits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_Ict)) listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

    // Method to get list of Student to resit Group Coursework 01 Component
    public List<Student> getListOfGroupCW01Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_GroupCw01))
                listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

    // Method to get list of Student to resit Group Coursework 02 Component
    public List<Student> getListOfGroupCW02Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : listOfStudents) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_GroupCw02))
                listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

}