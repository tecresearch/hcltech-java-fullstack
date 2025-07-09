package in.tca.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
@Value("Brijesh")
private String name;
@Value("26")
private int rollno;
@Value("29.5")
private float marks;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public float getMarks() {
	return marks;
}
public void setMarks(float marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "Student [name=" + name + ", rollno=" + rollno + ", marks=" + marks + "]";
}

}
