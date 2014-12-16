package com.cassio.studies.behavior.decorator;

/**
 * Decoration:
 *   Description + with peppermint;
 *   add 0.05 at the final price.
 *   
 * @author Cassio
 */
public class PeppermintDecorator extends JuiceDecorator {

    private Juice juiceToBeDecorate;

    public PeppermintDecorator(Juice juice) {
	this.juiceToBeDecorate = juice;
    }

    @Override
    public String getDescription() {
	return juiceToBeDecorate.getDescription() + " with peppermint";
    }

    @Override
    public Float price() {
	return juiceToBeDecorate.price() + 0.05F;
    }

}
