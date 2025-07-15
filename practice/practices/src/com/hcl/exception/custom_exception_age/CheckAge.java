package com.hcl.exception.custom_exception_age;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckAge {

    public ArrayList<Person> checkList() throws AdmissionFullException {
        ArrayList<Person> pList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (pList.size() < 3) {
            try {
                Person person = new Person();

                System.out.print("Enter your name: ");
                person.setName(sc.nextLine());

                System.out.print("Enter your age: ");
                int age = Integer.parseInt(sc.nextLine());
                if (age < 18) throw new AgeInvalidCheckedException();
                person.setAge(age);

                System.out.print("Enter your percentage: ");
                int percentage = Integer.parseInt(sc.nextLine());
                if (percentage < 75) throw new PercentageException();
                person.setPercentage(percentage);

                pList.add(person);

            } catch (AgeInvalidCheckedException | PercentageException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values for age and percentage.");
            }
        }

        if (pList.size() == 3) { 
        	System.out.println(pList);
            throw new AdmissionFullException();
        }

        return pList;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Person> validList = new CheckAge().checkList();
            System.out.println("Valid entries: " + validList);
        } catch (AdmissionFullException e) {
            System.out.println("Admission full: " + e.getMessage());
        }
    }
}
