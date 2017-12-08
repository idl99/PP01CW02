import lk.UoGNiP.Data.Resit;
import lk.UoGNiP.Data.InputForm;

import lk.UoGNiP.Entity.Student;
import lk.UoGNiP.Entity.Batch;

import lk.UoGNiP.GUI.HorizontalGui;
import lk.UoGNiP.GUI.VerticalGui;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static List<Student> listOfStudents = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userOpt = 0;
        char userOpt2 = '\0';

        while (true) {
            Batch seBatch = new Batch(listOfStudents);
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
                    "\n10. (FR10)|   View list of resit student for individual components" +
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


            if (userOpt == 0) break;

            else if (userOpt>1 && new File("Students.txt").exists()) {
                FileInputStream fis = null;
                ObjectInputStream ois = null;

                try {

                    fis = new FileInputStream(new File("Students.txt"));
                    ois = new ObjectInputStream(fis);

                    listOfStudents = (ArrayList<Student>) ois.readObject();
                    seBatch = new Batch(listOfStudents);

                } catch (FileNotFoundException e) {
                    if (userOpt > 1) {
                        System.out.println("No students added yet");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    ois.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }

            switch (userOpt) {
                case 1:
                    while (true) {
                        InputForm form = new InputForm();
                        Student obj = new Student(form);
                        listOfStudents.add(obj);
                        obj.printStudentDetails();
                        if(obj.getToResit().size()!=0) {
                            System.out.println("COMPONENTS TO RESIT");
                            for (Resit resit : obj.getToResit()) System.out.println(resit);
                        }
                        System.out.println("Successfully added details of " + obj.getRegNo());
                        System.out.println("Do you wish to enter details of any more students? " +
                                "[y]es or [n]o :");
                        char userChoice = sc.next().toUpperCase().charAt(0);

                        if (userChoice == 'N') {

                            FileOutputStream fos = null;
                            ObjectOutputStream oos = null;

                            try {
                                fos = new FileOutputStream(new File("Students.txt"));
                                oos = new ObjectOutputStream(fos);

                                oos.writeObject(listOfStudents);

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            finally {
                                try{
                                    oos.close();
                                    fos.close();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Class average for In-Class Main 01: " + seBatch.getIct01ClassAvg());
                    System.out.println("Class average for In-Class Main 02: " + seBatch.getIct02ClassAvg());
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
                        std.printStudentDetails();
                    }
                    break;
                case 6:
                    System.out.println("\nList of students who total module marks fall above class average");
                    for (Student std : seBatch.getStdsAboveOverallClassAvg()) {
                        std.printStudentDetails();
                    }
                    break;
                case 7:
                    Student ict01Highest = seBatch.getIct01HighestScorer();
                    Student ict02Highest = seBatch.getIct02HighestScorer();
                    Student groupCw01Highest = seBatch.getGroupCW01HighestScorer();
                    Student groupCw02Highest = seBatch.getGroupCW02HighestScorer();
                    Student overallHighest = seBatch.getOverallHighestScorer();

                    System.out.println("\nHighest scorer for Ict 01");
                    ict01Highest.printStudentDetails();
                    System.out.println("Student Marks for Ict 01: " + ict01Highest.getIct01Marks());

                    System.out.println("\nHighest scorer for Ict 02");
                    ict02Highest.printStudentDetails();
                    System.out.println("Student Marks for Ict 02: " + ict02Highest.getIct02Marks());

                    System.out.println("\nHighest scorer for Group Coursework 1");
                    groupCw01Highest.printStudentDetails();
                    System.out.println("Student Marks for Group Coursework 1: " + groupCw01Highest.getGroupCW02Marks());

                    System.out.println("\nHighest scorer for Group Coursework 2");
                    groupCw02Highest.printStudentDetails();
                    System.out.println("Student Marks for Group Coursework 2: " + groupCw02Highest.getGroupCW02Marks());

                    System.out.println("\nHighest scorer for Overall Module");
                    overallHighest.printStudentDetails();
                    System.out.println("Student overall module marks: "+overallHighest.getOverallMarks());

                    break;
                case 8:
                    Student overallLowest = seBatch.getOverallLowestScorer();
                    overallLowest.printStudentDetails();
                    break;
                case 9:
                    if (seBatch.getListOfRetakeStudents().size() == 0) System.out.println("No retake students");
                    else {
                        for (Student std : seBatch.getListOfRetakeStudents()) {
                            std.printStudentDetails();
                        }
                    }
                    break;
                case 10:
                    if (seBatch.getListOfIctResits().size() == 0) System.out.println("No students to resit for ICT");
                    else {
                        System.out.println("\nList of Resit students for ICT\n");
                        for (Student std : seBatch.getListOfIctResits()) {
                            std.printStudentDetails();
                            System.out.println("Student ICT Total Marks: " + (std.getIct01Marks()) +
                                    " "+std.getIct02Marks());
                        }
                    }


                    if (seBatch.getListOfGroupCW01Resits().size() == 0) System.out.println("No students to resit " +
                            "for Group CW 01");
                    else {
                        System.out.println("\nList of Resit students for Group CW 01\n");
                        for (Student std : seBatch.getListOfGroupCW01Resits()) {
                            std.printStudentDetails();
                            System.out.println("Student Group CW 01 Marks: " + std.getGroupCW01Marks());
                        }
                    }

                    if (seBatch.getListOfGroupCW02Resits().size() == 0) System.out.println("No students to resit " +
                            "for Group CW 02");
                    else {
                        System.out.println("\nList of Resit students for Group CW 02\n");

                        for (Student std : seBatch.getListOfGroupCW02Resits()) {
                            std.printStudentDetails();
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
            if (userOpt2 == 'X') break;
        }
    }
}
