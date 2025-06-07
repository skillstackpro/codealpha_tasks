package StudentGradeTracker;

//package service;

import StudentGradeTracker.Student;
import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public double calculateAverage() {
        double total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        return students.size() > 0 ? total / students.size() : 0;
    }

    public double getHighestGrade() {
        double highest = Double.MIN_VALUE;
        for (Student s : students) {
            if (s.getGrade() > highest) {
                highest = s.getGrade();
            }
        }
        return highest;
    }

    public double getLowestGrade() {
        double lowest = Double.MAX_VALUE;
        for (Student s : students) {
            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
            }
        }
        return lowest;
    }
}

