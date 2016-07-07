package com.tushar.common.model.living.human;

import com.tushar.common.model.living.LivingThing;
import com.tushar.common.model.living.Relations;

public class Human implements LivingThing{
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private int age;
	private Relations relations;
	
	public Human(){
		super();
	}
	
	public Human(String firstName, String lastName){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Human(String firstName, String lastName, int age){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Human(String firstName, String middleName, String lastName){
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public Human(String firstName, String middleName, String lastName, int age){
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
	}

	public Human(String firstName, String middleName, String lastName, String gender){
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public Human(String firstName, String middleName, String lastName, String gender, int age){
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Relations getRelations(){
		if(this.relations == null){
			this.relations = new Relations(this);
		}
		return relations;
	}
	
	public void setRelations(Relations relations){
		this.relations = relations;
	}
	
	public String getFullName(){
		return  (getFirstName() == null  ? "" : getFirstName()  + " " ) + 
				(getMiddleName() == null ? "" : getMiddleName() + " " ) + 
				(getLastName() == null   ? "" : getLastName());
	}
	
	public boolean isAdult(){
		return age >= 18;
	}

}