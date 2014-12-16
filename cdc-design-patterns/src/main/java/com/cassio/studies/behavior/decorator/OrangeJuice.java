package com.cassio.studies.behavior.decorator;

/**
 * Base class to be decorated.
 * 
 * @author Cassio
 */
public class OrangeJuice extends Juice {

    public OrangeJuice() {
	super.description = "Orange juice";
    }

    @Override
    public Float price() {
	return 1.0F;
    }

}
