package com.hcl.many2one.unidirectional.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="a6_department_uni")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String name;
	private String head;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String name, String head) {
		 
		this.name = name;
		this.head = head;
		
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	
	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", head=" + head +  "]";
	}
	
	
}
