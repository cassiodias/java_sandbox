package com.tw.hiring.rover;

public abstract class Rover<T> {

	protected Integer positionX = 0;

	protected Integer positionY = 0;

	protected Integer facingTo = Compass.NORTH.getValue();

	public abstract T startingAtPosition(Integer x, Integer y, Integer facing);

	public abstract void goWalk();

	public abstract Boolean isCrashedWith(Rover<?> anotherRover);

	public String whereIAm() {
		return new StringBuilder(positionX.toString()).append(" ")
				.append(positionY.toString()).append(" ")
				.append(Compass.getByValue(facingTo)).toString();
	}

	public String whereIAmBy(String byData) {
		if (byData.equals(DataPosition.POSITION_X.toString())) {
			return positionX.toString();
		} else if (byData.equals(DataPosition.POSITION_Y.toString())) {
			return positionY.toString();
		} else if (byData.equals(DataPosition.FRONT_OF.toString())) {
			return Compass.getByValue(facingTo).toString();
		}
		// none of them, return by default: complete data.
		return whereIAm();
	}

}
