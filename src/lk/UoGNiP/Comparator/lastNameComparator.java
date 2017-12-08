package lk.UoGNiP.Comparator;

import lk.UoGNiP.Entity.Student;

import java.util.Comparator;

public class lastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getLName().compareTo(o1.getLName());
    }
}
