package com.cassio.studies.behavior.decorator;

/**
 * Provides a base juice abstraction.
 * 
 * @author Cassio
 */
public abstract class Juice {

    protected String description = "Empty";

    public String getDescription() {
	return description;
    }

    public abstract Float price();

}
