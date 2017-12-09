package lk.UoGNiP.Entity;

import lk.UoGNiP.Comparator.LastNameComparator;
import lk.UoGNiP.Comparator.OverallMarkComparator;
import lk.UoGNiP.Data.Resit;
import lk.UoGNiP.Data.Grade;

import java.util.*;

public class Batch {

    private List<Student> list_Of_Students = new ArrayList<>();

    public Batch(List<Student> paramListOfStudents) {

        this.list_Of_Students = paramListOfStudents;

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

    public double getIct01ClassAvg() {
        double ict01ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) student.getIct01Marks();
        }

        ict01ClassAvg = total / this.list_Of_Students.size();
        return ict01ClassAvg;
    }

    public double getIct02ClassAvg() {
        double ict02ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) student.getIct02Marks();
        }

        ict02ClassAvg = total / this.list_Of_Students.size();
        return ict02ClassAvg;
    }

    public double getGroupCW01ClassAvg() {
        double groupCW01ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) student.getGroupCW01Marks();
        }

        groupCW01ClassAvg = total / this.list_Of_Students.size();
        return groupCW01ClassAvg;
    }

    public double getGroupCW02ClassAvg() {
        double groupCW02ClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) student.getGroupCW02Marks();
        }

        groupCW02ClassAvg = total / this.list_Of_Students.size();
        return groupCW02ClassAvg;
    }

    public double getOverallClassAvg() {
        double overallClassAvg;
        double total = 0.0;

        for (Student student : this.list_Of_Students) {
            total += (double) student.getOverallMarks();
        }

        overallClassAvg = total / this.list_Of_Students.size();
        return overallClassAvg;
    }

    public int numOfIct01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getIct01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfIct02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getIct02Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfGroupCw01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getGroupCW01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfGroupCw02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getGroupCW02Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
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
        sort(stdsAboveClassAvg,new OverallMarkComparator());
        return stdsAboveClassAvg;
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
            if (student.getIct01Marks() > max) {
                highestScorer = student;
                max = highestScorer.getOverallMarks();
            }
        }
        return highestScorer;
    }

    public Student getOverallLowestScorer() {
        int min = 100;
        Student lowestScorer = null;
        for (Student student : this.list_Of_Students) {
            if (student.getOverallMarks() < min) {
                lowestScorer = student;
                min = lowestScorer.getOverallMarks();
            }
        }
        return lowestScorer;
    }

    public List<Student> getListOfRetakeStudents() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student student : list_Of_Students) {
            if (student.getOverallGrade() == Grade.Fail_Retake) listOfStd.add(student);
        }
        return listOfStd;
    }

    public List<Student> getListOfIctResits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_Ict)) listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

    public List<Student> getListOfGroupCW01Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_GroupCw01))
                listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

    public List<Student> getListOfGroupCW02Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Resit.Resit_GroupCw02))
                listOfStd.add(std);
        }
        sort(listOfStd, new LastNameComparator());
        return listOfStd;
    }

}