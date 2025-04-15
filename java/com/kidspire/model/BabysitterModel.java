package com.kidspire.model;

public class BabysitterModel {
	
	private int babysitterId;
	private String firstName;
	private String lastName;
	private int experience;
	private int age;
	private String gender;
	private int contactNumber;
	private String status;
	public BabysitterModel(int babysitterId,String firstName,String lastName, int experience, int age, String gender,int contactNumber,String status) {
		super();
		this.babysitterId=babysitterId;
		this.firstName = firstName;
		this.lastName=lastName;
		this.experience = experience;
		this.age = age;
		this.gender = gender;
		this.contactNumber=contactNumber;
		this.status=status;
		
	}
	public BabysitterModel(int babysitterId) {
		this.babysitterId=babysitterId;
	}
	public int getBabysitterId() {
		return babysitterId;
	}
	public void setBaysitterId(int babysitterId) {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName =lastName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setStatus(int contactNumber) {
		this.contactNumber=contactNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
