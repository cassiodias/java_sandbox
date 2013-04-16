package com.tw.hiring.rover;

import java.util.HashSet;

public class LimitsReference {

	HashSet<String> markedPlace = new HashSet<String>();
	
	public void add(String position){
		markedPlace.add(position);
	}
	
	public Boolean exists(String key){
		return markedPlace.contains(key);
	}
	
}
