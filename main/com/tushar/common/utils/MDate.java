package com.tushar.common.utils;

import java.util.Date;


@SuppressWarnings("deprecation")
public class MDate extends Date{

	private static final long serialVersionUID = 4280154282437152459L;
	
	public MDate(){
		super();
	}

	public MDate(int yyyy, int mm, int dd){
		super(yyyy, mm, dd);
	}
	
	public MDate(String isoString){
		super(
				Integer.parseInt(isoString.split("-")[0]),
				Integer.parseInt(isoString.split("-")[1]),
				Integer.parseInt(isoString.split("-")[2])
				);
	}

	public MDate(long epoch){
		super(epoch);
	}

	public String asISOString(){
		return  getYearString() + "-" + 
				getMonthString() + "-" + 
				getDateString();
	}
	
	@Override
	public int getYear(){
		return super.getYear() + 1900;
	}
	
	public String getYearString(){
		return super.getYear() + 1900 + "";
	}
	
	public String getMonthString(){
		int month = super.getMonth();
		if(month<10){
			return "0" + month;
		}
		return month + "";
	}
	
	public String getDateString(){
		int date = super.getDate();
		if(date<10){
			return "0" + date;
		}
		return date + "";
	}
	
}