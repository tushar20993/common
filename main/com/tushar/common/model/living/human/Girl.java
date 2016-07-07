package com.tushar.common.model.living.human;

import com.tushar.common.model.living.Gender;

public class Girl extends Human {

	public Girl(){
		super();
		this.setGender(Gender.FEMALE);
	}

	public Girl(String firstName, String lastName){
		super(firstName, lastName);
		this.setGender(Gender.FEMALE);
	}

	public Girl(String firstName, String lastName, int age){
		super(firstName, lastName, age);
		this.setGender(Gender.FEMALE);
	}
	
	public Girl(String firstName, String middleName, String lastName){
		super(firstName, middleName, lastName);
		this.setGender(Gender.FEMALE);
	}
}