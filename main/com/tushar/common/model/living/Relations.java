package com.tushar.common.model.living;

import java.util.ArrayList;
import java.util.List;

import com.tushar.common.model.living.animal.Animal;
import com.tushar.common.model.living.animal.DomesticAnimal;
import com.tushar.common.model.living.human.Human;

/**
 * @author Tushar Aggarwal
 *
 */
public class Relations {

	private Human self;
	private List<Human> parents;
	private List<Human> children;
	private List<Human> siblings;
	private List<Human> friends;
	private List<Animal> pets;
	
	public Relations(Human self){
		super();
		this.parents = new ArrayList<Human>();
		this.children = new ArrayList<Human>();
		this.siblings = new ArrayList<Human>();
		this.friends = new ArrayList<Human>();
		this.pets = new ArrayList<Animal>();
		this.self = self;
	}
	
	public List<Human> getParents() {
		return parents;
	}
	
	public void setParents(List<Human> parents) {
		this.parents = parents;
	}
	
	public List<Human> getChildren() {
		return children;
	}
	
	public void setChildren(List<Human> children) {
		this.children = children;
	}
	
	public List<Human> getSiblings() {
		return siblings;
	}
	
	public void setSiblings(List<Human> siblings) {
		this.siblings = siblings;
	}
	
	public List<Human> getFriends() {
		return friends;
	}

	public void setFriends(List<Human> friends) {
		this.friends = friends;
	}
	
	public List<Animal> getPets(){
		if(this.pets == null){
			this.pets = new ArrayList<Animal>(); 
		}
		return pets;
	}
	
	public void setPets(List<Animal> pets){
		this.pets = pets;
	}

	public boolean addParent(Human parent){
		if(self.equals(parent)){
			return false;
		}
		if(!this.parents.contains(parent)){
			this.parents.add(parent);
			parent.getRelations().addChild(self);
			parent.getRelations().addChildren(self.getRelations().getSiblings());
			return true;
		}
		return false;
	}
	
	public void addParents(List<Human> parents){
		for(Human parent: parents){
			this.addParent(parent);
		}
	}
	
	public boolean addChild(Human child){
		if(self.equals(child)){
			return false;
		}
		if(!this.children.contains(child)){
			this.children.add(child);
			child.getRelations().addSiblings(self.getRelations().getChildren());
			child.getRelations().addParent(self);
			return true;
		}
		return false;
	}
	
	public void addChildren(List<Human> children){
		for(Human child: children){
			this.addChild(child);
		}
	}
	
	public boolean addSibling(Human sibling){
		if(self.equals(sibling)){
			return false;
		}
		if(!this.siblings.contains(sibling)){
			this.siblings.add(sibling);
			sibling.getRelations().addSibling(self);
			sibling.getRelations().addParents(self.getRelations().getParents());
			return true;
		}
		return false;
	}
	
	public void addSiblings(List<Human> siblings){
		for(Human sibling: siblings){
			this.addSibling(sibling);
		}
	}
	
	public boolean addFriend(Human friend){
		if(self.equals(friend)){
			return false;
		}
		if(!this.friends.contains(friend)){
			this.friends.add(friend);
			friend.getRelations().addFriend(self);
			return true;
		}
		return false;
	}
	
	public void addFriends(List<Human> friends){
		for(Human friend: friends){
			this.addFriend(friend);
		}
	}
	
	public boolean addPet(DomesticAnimal pet){
		if(!this.pets.contains(pet)){
			this.pets.add(pet);
			pet.addOwner(self);
			return true;
		}
		return false;
	}
	
	public void addPets(List<DomesticAnimal> pets){
		for(DomesticAnimal pet: pets){
			addPet(pet);
		}
	}
	
	public boolean hasChildren(){
		return !this.children.isEmpty();
	}
	
	public boolean hasParents(){
		return !this.parents.isEmpty();
	}
	
	public boolean hasSiblings(){
		return !this.siblings.isEmpty();
	}
	
	public boolean hasFriends(){
		return !this.friends.isEmpty();
	}
	
	public boolean hasPets(){
		return !this.pets.isEmpty();
	}
	
	public List<Human> getFamily(){
		List<Human> family = new ArrayList<Human>();
		family.addAll(getChildren());
		family.addAll(getParents());
		family.addAll(getParents());
		return family;
	}
}