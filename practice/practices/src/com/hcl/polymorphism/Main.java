package com.hcl.polymorphism;

import lombok.*;

// Lombok annotations to reduce boilerplate
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private int id;
    private String name;

    public Student(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public void submitTask() {
        System.out.println("Must be implemented by all the students.");
    }
}

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class LawStudents extends Student {

    public LawStudents(int id, String name) {
        super(id, name);
    }

    @Override
    public void submitTask() {
        System.out.println("This is a law student.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using constructor for Student
        Student s1 = new Student(12, "Brijesh");

        // Using constructor for LawStudents
        LawStudents s2 = new LawStudents(15, "Anjali");

        System.out.println("Student Info: " + s1);
        System.out.println("Law Student Info: " + s2);

        s1.submitTask();
        s2.submitTask();
    }
}
