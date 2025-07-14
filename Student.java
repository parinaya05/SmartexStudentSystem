package smartex;

import java.util.*;

/**
 * Student class
 * Extends Record and implements PersonInfo.
 * Has constructors, methods to calculate grade, compare names, etc.
 */
public class Student extends Record implements PersonInfo {
    protected int studentId;
    protected String name;
    protected double marks;
    protected String section;
    protected boolean isPassed;
    protected StringBuffer remarks;
    protected static int studentCount = 0;
    public static final String INSTITUTE_NAME = "Smartex Institute";

    // Default constructor
    public Student() {
        studentId = 0;
        name = "Unknown";
        marks = 0;
        section = "A";
        isPassed = false;
        remarks = new StringBuffer("None");
        studentCount++;
    }

    // Parameterized constructor
    public Student(int studentId, String name, double marks, String section) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.section = section;
        this.isPassed = marks >= 40;
        this.remarks = new StringBuffer("None");
        studentCount++;
    }

    // Copy constructor
    public Student(Student s) {
        this.studentId = s.studentId;
        this.name = s.name;
        this.marks = s.marks;
        this.section = s.section;
        this.isPassed = s.isPassed;
        this.remarks = new StringBuffer(s.remarks.toString());
        studentCount++;
    }

    public void printDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Section: " + section);
        System.out.println("Passed: " + isPassed);
        System.out.println("Remarks: " + remarks);
    }

    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    public void appendRemarks(String newRemark) {
        if (remarks.toString().equals("None")) {
            remarks = new StringBuffer(newRemark);
        } else {
            remarks.append("; ").append(newRemark);
        }
    }

    public void compareNames(String otherName) {
        System.out.println("Comparison using == : " + (name == otherName));
        System.out.println("Comparison using equals() : " + name.equals(otherName));
        System.out.println("Comparison using equalsIgnoreCase() : " + name.equalsIgnoreCase(otherName));
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public final void finalizeRecord() {
        System.out.println("Finalizing student record for: " + name);
    }

    // Interface methods
    public void displayBasicInfo() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }

    public String getType() {
        return "Regular Student";
    }
}
