package com.tushar.common.model.living.animal;

import java.util.List;

import com.tushar.common.model.living.human.Human;

public class Cat extends DomesticAnimal {
	
	private static final String TYPE = "CAT";
	
	public Cat(){
		super();
		this.setType(TYPE);
	}

	public Cat(String name, String breed){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
	}

	public Cat(String name, String breed, Human owner){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
		this.addOwner(owner);
	}

	public Cat(String name, String breed, List<Human> owners){
		super();
		this.setType(TYPE);
		this.setName(name);
		this.setBreed(breed);
		this.setOwners(owners);
	}
	
}