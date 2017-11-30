import lk.UoGNiP.Entity.Student;
import lk.UoGNiP.Entity.Batch;
import lk.UoGNiP.Data.InputForm;
import lk.UoGNiP.GUI.HorizontalGui;
import lk.UoGNiP.GUI.VerticalGui;
import lk.UoGNiP.GUI.VerticalStars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

    public static List<Student> listOfStudents = new ArrayList<>();

    public static boolean checkIfStudent(List<Student> param) {
        if (param.size() == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Batch seBatch = null;

        Scanner sc = new Scanner(System.in);
        int userOpt = 0;
        char userOpt2 = '\u0000';

        while (true) {

            System.out.println("" +
                    "==================================================" +
                    "\nWELCOME TO UoG NiP Student Report System for PP01" +
                    "\n==================================================" +
                    "\n" +
                    "\n1.  (FR1) |   Enter student details" +
                    "\n2.  (FR2) |   View class average for individual components" +
                    "\n3.  (FR3) |   View number of failed students for individual components" +
                    "\n4.  (FR4) |   View overall class average" +
                    "\n5.  (FR5) |   View students below class average" +
                    "\n6.  (FR6) |   View student above class average" +
                    "\n7.  (FR7) |   View highest scorers" +
                    "\n8.  (FR8) |   View overall lowest scorer" +
                    "\n9.  (FR9) |   View retake students" +
                    "\n10. (FR10)|   View list of resit student for individiual components" +
                    "\n11. (FR11)|   Display horizontal histogram" +
                    "\n12. (FR12)|   Display vertical histogram" +
                    "\n");

            do {
                System.out.print("" +
                        "Please enter the number corresponding to your desired command" +
                        " in the prompt below or 0 to exit" +
                        "\n>>>>");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input...");
                    sc.next();
                }
                userOpt = sc.nextInt();
                if (!(userOpt >= 0 && userOpt <= 12)) {
                    System.out.println("Invalid input...");
                }
            } while (!(userOpt >= 0 && userOpt <= 12));


            /*if (userOpt == 0) break;
            else if (userOpt > 1) {
                if (!checkIfStudent(listOfStudents)) {
                    if (!checkIfStudent(listOfStudents)) {
                        System.out.println("No students added yet...\n");
                        continue;
                    }
                }
            }*/


            switch (userOpt) {
                case 1:
                    while (true) {
                        InputForm form = new InputForm();
                        Student obj = new Student(form);
                        listOfStudents.add(obj);
                        System.out.println("Successfully added details of " + obj.getRegNo());
                        System.out.println("Do you wish to enter details of any more students? " +
                                "[y]es or [n]o :");
                        char userChoice = sc.next().toUpperCase().charAt(0);
                        if (userChoice == 'N') {
                            seBatch = new Batch(listOfStudents);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Class average for In-Class Test 01: " + seBatch.getIct01ClassAvg());
                    System.out.println("Class average for In-Class Test 02: " + seBatch.getIct02ClassAvg());
                    System.out.println("Class average for Group Coursework 01: " + seBatch.getGroupCW01ClassAvg());
                    System.out.println("Class average for Group Coursework 02: " + seBatch.getGroupCW02ClassAvg());
                    break;
                case 3:
                    System.out.println("Number of students who've scored below 30 for ICT 01: " + seBatch.numOfIct01MarksBelow30());
                    System.out.println("Number of students who've scored below 30 for ICT 02: " + seBatch.numOfIct02MarksBelow30());
                    System.out.println("Number of students who've scored below 30 for Group CW 01: " + seBatch.numOfGroupCw01MarksBelow30());
                    System.out.println("Number of students who've scored below 30 for Group CW 02: " + seBatch.numOfGroupCw02MarksBelow30());
                    break;
                case 4:
                    System.out.println("Overall class average is: " + seBatch.getOverallClassAvg());
                    break;
                case 5:
                    System.out.println("\nList of students whose total module marks fall below class average");
                    for (Student std : seBatch.getStdsBelowOverallClassAvg()) {
                        System.out.println("Student Registration Number: " + std.getRegNo());
                        System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                        System.out.println("Student Overall Marks: " + std.getOverallMarks());
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("\nList of students who total module marks fall above class average");
                    for (Student std : seBatch.getStdsAboveOverallClassAvg()) {
                        System.out.println("Student Registration Number: " + std.getRegNo());
                        System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                        System.out.println("Student Overall Marks: " + std.getOverallMarks());
                        System.out.println();
                    }
                    break;
                case 7:
                    Student ict01Highest = seBatch.getIct01HighestScorer();
                    Student ict02Highest = seBatch.getIct02HighestScorer();
                    Student groupCw01Highest = seBatch.getGroupCW01HighestScorer();
                    Student groupCw02Highest = seBatch.getGroupCW02HighestScorer();

                    System.out.println("Highest scorer for Ict 01\n");
                    System.out.println("Student Registration Number: " + ict01Highest.getRegNo());
                    System.out.println("Student Name: " + ict01Highest.getFName() + " " + ict01Highest.getLName());
                    System.out.println("Student Marks for Ict 01: " + ict01Highest.getIct01Marks());

                    System.out.println("Highest scorer for Ict 02\n");
                    System.out.println("Student Registration Number: " + ict02Highest.getRegNo());
                    System.out.println("Student Name: " + ict02Highest.getFName() + " " + ict02Highest.getLName());
                    System.out.println("Student Marks for Ict 01: " + ict02Highest.getIct02Marks());

                    System.out.println("Highest scorer for Group Coursework 1\n");
                    System.out.println("Student Registration Number: " + groupCw01Highest.getRegNo());
                    System.out.println("Student Name: " + groupCw01Highest.getFName() + " " + groupCw01Highest.getLName());
                    System.out.println("Student Marks for Ict 01: " + groupCw01Highest.getGroupCW02Marks());

                    System.out.println("Highest scorer for Group Coursework 2\n");
                    System.out.println("Student Registration Number: " + groupCw02Highest.getRegNo());
                    System.out.println("Student Name: " + groupCw02Highest.getFName() + " " + groupCw02Highest.getLName());
                    System.out.println("Student Marks for Ict 01: " + groupCw02Highest.getGroupCW02Marks());


                    break;
                case 8:
                    Student overallLowest = seBatch.getOverallLowestScorer();
                    System.out.println("Student Registration Number: " + overallLowest.getRegNo());
                    System.out.println("Student Name: " + overallLowest.getFName() + " " + overallLowest.getLName());
                    System.out.println("Student Overall Marks: " + overallLowest.getOverallMarks());
                    break;
                case 9:
                    if (seBatch.getListOfRetakeStudents().size() == 0) System.out.println("No retake students");
                    else {
                        for (Student std : seBatch.getListOfRetakeStudents()) {
                            System.out.println("Student Registration Number: " + std.getRegNo());
                            System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                            System.out.println("Student Overall Marks: " + std.getOverallMarks());
                            System.out.println();
                        }
                    }
                    break;
                case 10:
                    if (seBatch.getListOfIctResits().size() == 0) System.out.println("No students to resit for ICT");
                    else {
                        System.out.println("\nList of Resit students for ICT\n");
                        for (Student std : seBatch.getListOfIctResits()) {
                            System.out.println("Student Registration Number: " + std.getRegNo());
                            System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                            System.out.println("Student ICT Total Marks: " + (std.getIct01Marks()) + std.getIct02Marks());
                            System.out.println();
                        }
                    }


                    if (seBatch.getListOfGroupCW01Resits().size() == 0) System.out.println("No students to resit " +
                            "for Group CW 01");
                    else {
                        System.out.println("\nList of Resit students for Group CW 01\n");
                        for (Student std : seBatch.getListOfGroupCW01Resits()) {
                            System.out.println("Student Registration Number: " + std.getRegNo());
                            System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                            System.out.println("Student Group CW 01 Marks: " + std.getGroupCW01Marks());
                            System.out.println();
                        }
                    }

                    if (seBatch.getListOfGroupCW02Resits().size() == 0) System.out.println("No students to resit " +
                            "for Group CW 02");
                    else {
                        System.out.println("\nList of Resit students for Group CW 02\n");
                        for (Student std : seBatch.getListOfGroupCW01Resits()) {
                            System.out.println("Student Registration Number: " + std.getRegNo());
                            System.out.println("Student Name: " + std.getFName() + " " + std.getLName());
                            System.out.println("Student Group CW 02 Marks: " + std.getGroupCW02Marks());
                        }
                    }
                    break;
                case 11:
                    HorizontalGui hGui = new HorizontalGui(listOfStudents);
                    break;
                case 12:
                    VerticalGui vGui = new VerticalGui(listOfStudents);
                    break;
            }

            while (true) {
                System.out.print("\nPress 0 in the prompt below to go back or X\n>>>: ");
                userOpt2 = sc.next().charAt(0);
                if (!((userOpt2 == '0') || (userOpt2 == 'X'))) {
                    System.out.println("Invalid input");
                } else break;
            }
            if (userOpt2 == '0') continue;
            else if (userOpt2 == 'X') break;
        }
    }
}
