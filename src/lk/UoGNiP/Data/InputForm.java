package lk.UoGNiP.Data;

import java.util.*;

public class InputForm {

    Scanner sc = new Scanner(System.in);

    private String inputRegNo = null;
    private String inputFName = null;
    private String inputLName = null;
    private int inputICT01Marks = 0;
    private int inputICT02Marks = 0;
    private int inputGroupCW01Marks = 0;
    private int inputGroupCW02Marks = 0;


    public InputForm() {

        this.inputRegNo = setRegNo();
        this.inputFName = setName("Enter first name: ");
        this.inputLName = setName("Enter last name: ");
        this.inputICT01Marks = setMarks("Enter ICT 01 Marks: ");
        this.inputICT02Marks = setMarks("Enter ICT 02 Marks: ");
        this.inputGroupCW01Marks = setMarks("Enter Group CW 01 Marks: ");
        this.inputGroupCW02Marks = setMarks("Enter Group CW 02 Marks: ");

    }

    private String setRegNo() {
        String input = null;
        while (true) {
            System.out.print("Enter student registration number: ");
            if (sc.hasNext(".*\\D+.*")) {
                System.out.println("Registration number can only contain digits. " +
                        "Please re-enter the registration number below");
                sc.nextLine();
                continue;
            } else if (!sc.hasNext("\\d{7}")) {
                System.out.println("Registration number should be 7 digits in length.");
                sc.nextLine();
                continue;
            } else input = sc.nextLine();
            break;
        }
        return input;
    }

    private String setName(String message) {
        String input = null;
        while (true) {
            System.out.print(message);
            if (sc.hasNext(".*\\d+.*")) {
                System.out.println("Name can only contain alphabetical characters. Please re-enter the below");
                sc.nextLine();
                continue;
            } else input = sc.nextLine();
            break;
        }
        return input;
    }

    private int setMarks(String message) {
        int marks;
        while (true) {
            System.out.print(message);
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Marks should be an integer value between 0-100");
                sc.nextInt();
                continue;
            }
            marks = sc.nextInt();
            if (!(marks >= 0 && marks <= 100)) {
                System.out.println("Invalid input. Marks should be within the range of 0-100.");
                continue;
            }
            break;
        }
        return marks;
    }


    public String getRegNo() {
        return inputRegNo;
    }

    public String getInputFName() {
        return inputFName;
    }

    public String getInputLName() {
        return inputLName;
    }

    public int getInputICT01Marks() {
        return inputICT01Marks;
    }

    public int getInputICT02Marks() {
        return inputICT02Marks;
    }

    public int getInputGroupCW01Marks() {
        return inputGroupCW01Marks;
    }

    public int getGetInputGroupCW02Marks() {
        return inputGroupCW02Marks;
    }
}
