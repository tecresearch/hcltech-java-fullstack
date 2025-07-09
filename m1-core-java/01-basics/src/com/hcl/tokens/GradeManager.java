/*
 * Problem Statement:

Create a Java program that manages student records. Each student has:

A name
A roll number
A list of marks in 5 subjects
Your program should:

Define a Student class with appropriate fields and methods.
Accept details for multiple students.
Calculate and display:
Total marks
Average marks
Grade (A/B/C/Fail based on average)
 */
package com.hcl.tokens;
import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private int[] marks = new int[5];

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAverageMarks() {
        return getTotalMarks() / 5.0;
    }

    public String getGrade() {
        double avg = getAverageMarks();
        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Average: " + getAverageMarks());
        System.out.println("Grade: " + getGrade());
        System.out.println("---------------------------");
    }
}

public class GradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Roll No: ");
            int rollNo = scanner.nextInt();

            int[] marks = new int[5];
            System.out.println("Enter marks for 5 subjects:");
            for (int j = 0; j < 5; j++) {
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine(); // consume newline

            students.add(new Student(name, rollNo, marks));
        }

        System.out.println("\n--- Student Report ---");
        for (Student s : students) {
            s.displayInfo();
        }

        scanner.close();
    }
}
