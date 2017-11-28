import lk.UoGNiP.Entity.Student;
import lk.UoGNiP.Entity.Batch;
import lk.UoGNiP.Data.InputForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {

    public static void main(String[] args) {

        List<Student> listOfStudents = new ArrayList<>();

        while (true) {

            InputForm form = new InputForm();
            Student obj = new Student(form);
            listOfStudents.add(obj);

            System.out.println(obj.getOverallMarks());
            System.out.println(obj.getOverallGrade());

            Scanner sc = new Scanner(System.in);
            System.out.println("Do you wish to enter details of any more students? " +
                    "[y]es or [n]o :");
            char userChoice = sc.next().toUpperCase().charAt(0);
            if (userChoice == 'N') break;

        }

        Batch seBatch = new Batch(listOfStudents);
        System.out.println("\nTo resit ICT");
        for(Student std: seBatch.getListOfIctResits()) System.out.println(std.getRegNo());
        System.out.println("\nTo resit Group Coursework 01");
        for(Student std: seBatch.getListOfGroupCW01Resits()) System.out.println(std.getRegNo());
        System.out.println("\nTo resit Group Coursework 02");
        for(Student std: seBatch.getListOfGroupCW02Resits()) System.out.println(std.getRegNo());

    }

}
