package com.cassio.studies.behavior.decorator;

public class SugarDecorator extends JuiceDecorator {

	private Juice juiceToBeDecorate;
	
	public SugarDecorator(Juice juice) {
		this.juiceToBeDecorate = juice;
	}
	
	@Override
	public String getDescription() {
		return juiceToBeDecorate.getDescription() + " with Sugar";
	}
	
	@Override
	public Float price() {
		// there is no price addition. 
		return juiceToBeDecorate.price();
	}

}
