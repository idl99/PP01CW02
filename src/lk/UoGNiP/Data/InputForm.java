package lk.UoGNiP.Data;

import java.util.*;

// InputForm class to create InputForm object
// Handles input validation of Student details and marks
public class InputForm {

    Scanner sc = new Scanner(System.in);

    // Fields of InputForm
    private String inputRegNo = null;
    private String inputFName = null;
    private String inputLName = null;

    private int inputICT01Marks = 0;
    private int inputICT02Marks = 0;
    private int inputGroupCW01Marks = 0;
    private int inputGroupCW02Marks = 0;

    // Non-arg constructor for InputForm object
    public InputForm() {

        this.inputRegNo = setRegNo();
        this.inputFName = setName("Enter first name: ");
        this.inputLName = setName("Enter last name: ");

        this.inputICT01Marks = setMarks("Enter ICT 01 Marks: ");
        this.inputICT02Marks = setMarks("Enter ICT 02 Marks: ");
        this.inputGroupCW01Marks = setMarks("Enter Group CW 01 Marks: ");
        this.inputGroupCW02Marks = setMarks("Enter Group CW 02 Marks: ");

    }

    // Method to handle validation of Student Registration number
    private String setRegNo() {
        String input = null;
        while (true) {
            System.out.print("Enter student registration number: ");
            if (sc.hasNext(".*\\D+.*")) {
                // Checks if Registration number contains any characters other than digits
                System.out.println("Registration number can only contain digits. " +
                        "Please re-enter the registration number below");
                sc.nextLine();
                continue;
            } else if (!sc.hasNext("\\d{7}")) {
                // Checks if Registration number is exactly 7 digits in length or not
                System.out.println("Registration number should be 7 digits in length.");
                sc.nextLine();
                continue;
            } else input = sc.nextLine();
            break;
        }
        return input;
    }

    // Method to handle validation of names
    private String setName(String message) {
        String input = null;
        while (true) {
            System.out.print(message);
            if (sc.hasNext(".*[^A-Za-z]+.*")) {
                // Checks if the name contains any numeric characters
                System.out.println("Name can only contain alphabetical characters. Please re-enter the below");
                sc.nextLine();
                continue;
            } else input = sc.nextLine();
            break;
        }
        return input;
    }

    // Method to handle validation of marks
    private int setMarks(String message) {
        int marks;
        while (true) {
            // Loop which will execute until user enters a valid marks
            System.out.print(message);
            if (!sc.hasNextInt()) {
                // Checks if input is an integer
                System.out.println("Invalid input. Please enter an integer value");
                sc.nextInt();
                continue;
            }
            marks = sc.nextInt();
            if (!(marks >= 0 && marks <= 100)) {
                // Checks if input marks are within the range of 0 to 100
                System.out.println("Invalid input. Marks should be within the range of 0-100.");
                continue;
            }
            break;
        }
        return marks;
    }


    public String getRegNo() {return inputRegNo;}

    public String getFName() {return inputFName;}

    public String getLName() {return inputLName;}

    public int getIct01Marks() {return inputICT01Marks;}

    public int getIct02Marks() {return inputICT02Marks;}

    public int getGroupCw01Marks() {return inputGroupCW01Marks;}

    public int getGroupCw02Marks() {return inputGroupCW02Marks;}
}
