package in.tecresearch.beans;

public class Student
{
    String name;
    String course;
    Address address;

    public Student(String name, String course, Address address) {
        this.name = name;
        this.course = course;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", address=" + address +
                '}';
    }
}
