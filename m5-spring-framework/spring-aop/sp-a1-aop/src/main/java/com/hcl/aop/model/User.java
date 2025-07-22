package com.hcl.aop.model;

import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class User {

		private int id;
		private String name;
		private Map<String, String> address;
		
		public User() {
			
		}
		public User(int id, String name, Map<String, String> address) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Map<String, String> getAddress() {
			return address;
		}
		public void setAddress(Map<String, String> address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
		}
		
		public void Display() {
			System.out.println("User [id=" + id + ", name=" + name + ", address=" + address + "]");
		}
		
		
		public void throwException() {
		    System.out.println("About to throw an exception...");
		    throw new RuntimeException("Intentional exception for AOP testing");
		}

		
}
