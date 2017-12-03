package lk.UoGNiP.Entity;

import lk.UoGNiP.Data.Component;
import lk.UoGNiP.Data.Grade;

import java.util.*;

public class Batch {

    private List<Student> list_Of_Students = new ArrayList<>();

    public Batch(List<Student> paramListOfStudents) {

        this.list_Of_Students = paramListOfStudents;

    }
/*
    public void displayClassAverages(){
        double ict01Total = 0.0, ict02Total = 0.0, groupCw01Total = 0.0,
                groupCw02Total = 0.0, overallTotal = 0.0;
        for(Student std: list_Of_Students){
            ict01Total += std.getIct01Marks();
            ict02Total += std.getIct02Marks();
            groupCw01Total += std.getGroupCW01Marks();
            groupCw02Total += std.getGroupCW02Marks();
            overallTotal += std.getOverallMarks();
        }
        System.out.println("CLASS AVERAGE FOR ICT 1:"+(ict01Total/list_Of_Students.size()));
        System.out.println("CLASS AVERAGE FOR ICT 2:"+(ict02Total/list_Of_Students.size()));
        System.out.println("CLASS AVERAGE FOR GROUP CW 01:"+(groupCw01Total/list_Of_Students.size()));
        System.out.println("CLASS AVERAGE FOR GROUP CW 02:"+(groupCw02Total/list_Of_Students.size()));
        System.out.println("CLASS OVERALL MODULE AVERAGE:"+(overallTotal/list_Of_Students.size()));
    }
*/
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

    public int numOfIct01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<Student>();
        for (Student std : list_Of_Students) {
            if (std.getIct01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfIct02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<Student>();
        for (Student std : list_Of_Students) {
            if (std.getIct02Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfGroupCw01MarksBelow30() {
        List<Student> listOfStd = new ArrayList<Student>();
        for (Student std : list_Of_Students) {
            if (std.getGroupCW01Marks() < 30) listOfStd.add(std);
        }
        return listOfStd.size();
    }

    public int numOfGroupCw02MarksBelow30() {
        List<Student> listOfStd = new ArrayList<Student>();
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
        stdsAboveClassAvg.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getOverallMarks() - o1.getOverallMarks();
            }
        });
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
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Component.Ict)) listOfStd.add(std);
        }
        listOfStd.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLName().compareTo(o2.getLName());
            }
        });
        return listOfStd;
    }

    public List<Student> getListOfGroupCW01Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Component.GroupCw01))
                listOfStd.add(std);
        }
        listOfStd.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLName().compareTo(o2.getLName());
            }
        });
        return listOfStd;
    }

    public List<Student> getListOfGroupCW02Resits() {
        List<Student> listOfStd = new ArrayList<>();
        for (Student std : list_Of_Students) {
            if (std.getOverallGrade() != Grade.Fail_Retake && std.getToResit().contains(Component.GroupCw02))
                listOfStd.add(std);
        }
        listOfStd.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLName().compareTo(o2.getLName());
            }
        });
        return listOfStd;
    }

}