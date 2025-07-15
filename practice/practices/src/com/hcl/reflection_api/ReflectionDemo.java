package com.hcl.reflection_api;
import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Load the class
        Class<?> personClass = Class.forName("com.hcl.reflection_api.Person");

        // Create an instance new Person();
        Object person = personClass.getDeclaredConstructor().newInstance();

        // Access private field 'name'
        Field nameField = personClass.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println(nameField.getName()+": "+nameField.get(person));
        nameField.set(person, "John Doe");

        // Access private field 'age'
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println(ageField.getName()+": "+ageField.get(person));
        ageField.setInt(person, 25);

        Field percentageField=personClass.getDeclaredField("percentage");
        percentageField.setAccessible(true);
        System.out.println(percentageField.getName()+": "+percentageField.get(person));
        percentageField.set(person, 89);
        // Access method
        Method getNameMethod = personClass.getMethod("getName");
        String name = (String) getNameMethod.invoke(person);
        Method getAgeMethod = personClass.getMethod("getAge");
        Integer age = (Integer) getAgeMethod.invoke(person);
        Method getPercentageMethod = personClass.getMethod("getPercentage");
        Integer percentage = (Integer) getPercentageMethod.invoke(person);

        System.out.println("Name via reflection: " + name);
        System.out.println("Age via reflection: " + age);
        System.out.println("Percentage via reflection: " + percentage);
    }
}
  