package in.tecresearch.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
    int id;
    String name;
    String phone;
    String course;
    Address address;
    public Student(int id, String name, String phone, String course,Address address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.course = course;
        this.address=address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", course='" + course + '\'' +
                ", address=" + address +
                '}';
    }
}
