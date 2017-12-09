package lk.UoGNiP.Comparator;

import lk.UoGNiP.Entity.Student;

import java.util.Comparator;

// Custom Comparator to compare Last names of two students
public class LastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student std1, Student std2) {
        // Compares the last names of two Student
        // If std1's name is lexographically larger, value > 0 is returned
        // If std2's name is lexographically larger, value < 0 is returned
        return std2.getLName().compareTo(std1.getLName());
    }
}
