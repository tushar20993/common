package com.tushar.common.model.living.animal;

import com.tushar.common.model.living.LivingThing;

public abstract class Animal implements LivingThing{
	
	private boolean isFurry;
	private boolean hasWings;
	private boolean canSwim;
	private boolean canBreathInWater;
	private boolean canBreathOutsideWater;
	
	public Animal(){
		super();
	}
	
	public abstract String getType();
	public abstract boolean isDomesticable();

	public void isFurry(boolean isFurry){
		this.isFurry = isFurry;
	}
	
	public void hasWings(boolean hasWings){
		this.hasWings = hasWings;
	}
	
	public void canSwim(boolean canSwim){
		this.canSwim = canSwim;
	}
	
	public void canBreathInWater(boolean canBreathInWater){
		this.canBreathInWater = canBreathInWater;
	}
	
	public void canBreathOutsideWater(boolean canBreathOutsideWater){
		this.canBreathOutsideWater = canBreathOutsideWater;
	}
	
	public boolean isFurry(){
		return isFurry;
	}
	
	public boolean hasWings(){
		return hasWings;
	}
	
	public boolean canSwim(){
		return canSwim;
	}
	
	public boolean canBreathInWater(){
		return canBreathInWater;
	}
	
	public boolean canBreathOutsideWater(){
		return canBreathOutsideWater;
	}
}
