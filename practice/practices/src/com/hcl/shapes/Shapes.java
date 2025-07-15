package com.hcl.shapes;

public class Shapes {
	int numberOfSides;
	public static void main(String args[]) {
		calculateShapeArea(3);
	}
	private static void calculateShapeArea(int i) {
		double area = 0;
		if(i==1) {
			Circle c=new Circle();
			area=c.calculateArea(5);
			System.out.println("The Area of Circle is "+area);
		}else if(i==3) {
			Tringle t=new Tringle();
			area=t.calculateArea(5);
			System.out.println("The Area of Tringle is "+area);
		}else if(i==4) {
			Squire s=new Squire();
			area=s.calculateArea(6);
			System.out.println("The Area of Squire is "+area);
		}else {
			System.out.println("No Shapes Present");
		}
		
	}
}
