package com.tushar.common.model.living.animal;

import java.util.ArrayList;
import java.util.List;

import com.tushar.common.model.living.human.Human;

public abstract class DomesticAnimal extends Animal {

	private String name;
	private String type;
	private String breed;
	private List<Human> owners;
	
	public DomesticAnimal(){
		super();
		this.owners = new ArrayList<Human>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public List<Human> getOwners() {
		return owners;
	}
	public void setOwners(List<Human> owners) {
		this.owners = owners;
	}
	
	public boolean addOwner(Human owner){
		if(!owners.contains(owner)){
			owners.add(owner);
			owner.getRelations().addPet(this);
			return true;
		}
		return false;
	}
	
	public void addOwners(List<Human> owners){
		for(Human owner : owners){
			addOwner(owner);
		}
	}
	
	@Override
	public boolean isDomesticable(){
		return true;
	}
}
