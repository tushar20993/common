package com.tushar.common.model.living.human;

import com.tushar.common.model.living.Gender;

public class Boy extends Human {

	public Boy(){
		super();
		this.setGender(Gender.MALE);
	}

	public Boy(String firstName, String lastName){
		super(firstName, lastName);
		this.setGender(Gender.MALE);
	}

	public Boy(String firstName, String lastName, int age){
		super(firstName, lastName, age);
		this.setGender(Gender.MALE);
	}
	
	public Boy(String firstName, String middleName, String lastName){
		super(firstName, middleName, lastName);
		this.setGender(Gender.MALE);
	}
}