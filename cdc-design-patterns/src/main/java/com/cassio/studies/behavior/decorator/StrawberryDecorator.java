package com.cassio.studies.behavior.decorator;

/**
 * Decoration:
 *   Description + with strawberry;
 *   add 1 at the final price.
 *   
 * @author Cassio
 */
public class StrawberryDecorator extends JuiceDecorator {

    private Juice juiceToBeDecorate;

    public StrawberryDecorator(Juice juice) {
	this.juiceToBeDecorate = juice;
    }

    @Override
    public String getDescription() {
	return juiceToBeDecorate.getDescription() + " with strawberry";
    }

    @Override
    public Float price() {
	return juiceToBeDecorate.price() + 1F;
    }

}
