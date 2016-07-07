package com.tushar.common.model.living.animal;

import java.util.List;

import com.tushar.common.model.living.human.Human;

public class Dog extends DomesticAnimal {

	private static final String TYPE = "DOG";
	
	public Dog(){
		super();
		this.setType(TYPE);
	}
	
	public Dog(String name, String breed){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
	}

	public Dog(String name, String breed, Human owner){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
		this.addOwner(owner);
	}
	

	public Dog(String name, String breed, List<Human> owners){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
		this.setOwners(owners);
	}
	
}