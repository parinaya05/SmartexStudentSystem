package smartex;

import java.util.*;

/**
 * StudentApp - main menu-driven program.
 * Add student, display details, append remarks, calculate grade, compare names, simulate exception.
 */
public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        boolean exit = false;
        Record record = new Student();
        record.welcomeMessage();

        while (!exit) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Append Remarks");
            System.out.println("4. Calculate Grade");
            System.out.println("5. Compare Names");
            System.out.println("6. Simulate Exception");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Marks (0-100): ");
                        double marks = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Section (A/B/C): ");
                        String section = sc.nextLine();
                        System.out.print("Is Scholar Student? (yes/no): ");
                        String scholar = sc.nextLine();
                        if (scholar.equalsIgnoreCase("yes")) {
                            System.out.print("Enter Scholarship Amount: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            ScholarStudent ss = new ScholarStudent(id, name, marks, section, amount);
                            studentList.add(ss);
                        } else {
                            Student s = new Student(id, name, marks, section);
                            studentList.add(s);
                        }
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        for (Student s : studentList) {
                            s.printDetails();
                            System.out.println("Type: " + s.getType());
                            System.out.println("------------------");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();
                        boolean found = false;
                        for (Student s : studentList) {
                            if (s.studentId == sid) {
                                System.out.print("Enter your remark: ");
                                String remark = sc.nextLine();
                                s.appendRemarks(remark);
                                System.out.println("Remark added successfully.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Student not found.");
                        break;

                    case 4:
                        System.out.print("Enter Student ID: ");
                        int gid = sc.nextInt();
                        sc.nextLine();
                        found = false;
                        for (Student s : studentList) {
                            if (s.studentId == gid) {
                                String grade = s.calculateGrade();
                                System.out.println("Grade: " + grade);
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Student not found.");
                        break;

                    case 5:
                        System.out.print("Enter first student name: ");
                        String n1 = sc.nextLine();
                        System.out.print("Enter second student name: ");
                        String n2 = sc.nextLine();
                        Student temp = new Student();
                        temp.name = n1;
                        temp.compareNames(n2);
                        break;

                    case 6:
                        System.out.print("Enter number: ");
                        int num = sc.nextInt();
                        System.out.print("Enter divisor: ");
                        int div = sc.nextInt();
                        try {
                            int res = num / div;
                            System.out.println("Result: " + res);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: Division by zero is not allowed.");
                        } finally {
                            System.out.println("Handled exception example.");
                        }
                        break;

                    case 7:
                        exit = true;
                        System.out.println("Exiting system. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InvalidMarksException e) {
                System.out.println("Invalid Marks: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Input error! Please enter correct data.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
