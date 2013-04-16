package com.tw.hiring.rover;

/**
 * @author Cassio Dias
 */
public enum Compass {
    
    NORTH(1), EAST(2), SOUTH(3), WEST(4), HELP_IM_LOST(0);

    private Integer position;
    
    Compass(Integer position){
	this.position = position;
    }
    
    public Integer getValue(){
	return this.position;
    }
    
    public static Compass getByValue(Integer value) {
	if (value != null && value > 0){
	    for (Compass c : Compass.values()) {
		if (c.getValue().equals(value))
		    return c;
	    }
	}
	return HELP_IM_LOST;
    }
    
    public static Compass getByName(String name) {
   	if (name != null){
   	    for (Compass c : Compass.values()) {
   		if (c.toString().equals(name))
   		    return c;
   	    }
   	}
   	return HELP_IM_LOST;
       }
    
}