package lk.UoGNiP.Comparator;

import lk.UoGNiP.Entity.Student;

import java.util.Comparator;

// Custom Comparator to compare the overall marks of two students
public class OverallMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student std1, Student std2) {
        // Compares the overall marks of two Student
        // If std1's overall marks is greater, value > 0 is returned
        // If std2's overall marks is greater, value < 0 is returned
        return std1.getOverallMarks() - std2.getOverallMarks();
    }
}
