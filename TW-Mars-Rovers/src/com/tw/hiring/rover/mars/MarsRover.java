package com.tw.hiring.rover.mars;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import com.tw.hiring.rover.Compass;
import com.tw.hiring.rover.LimitsReference;
import com.tw.hiring.rover.Rover;

/**
 * @author Cassio Dias.
 */
public class MarsRover extends Rover<MarsRover> {

	private String commands;
	private LimitsReference limitReference;

	public MarsRover(Integer xLimit, Integer yLimit, LimitsReference limit) {
		// default position (0,0,NORTH) at super class.
		super();
		this.limitReference = limit;
	}

	@Override
	public void goWalk() {
		for (int idx = 0, length = commands.length(); idx < length; idx++) {
			handleMovimentsByCommands(commands.charAt(idx));
		}
	}

	private void handleMovimentsByCommands(Character command) {
		if (command.equals('L')) {
			left();
		} else if (command.equals('R')) {
			right();
		} else if (command.equals('M')) {
			move();
		}
	}

	private void move() {
		if (facingTo.equals(Compass.NORTH.getValue())) {

			Integer tempPosY = positionY + 1;
			if (limitReference.exists(positionX.toString() + " "
					+ tempPosY.toString())) {
				throw new RuntimeException("Sttopped by flagged position.");
			} 

			positionY++;
			
			

		} else if (facingTo.equals(Compass.EAST.getValue())) {
			positionX++;

		} else if (facingTo.equals(Compass.SOUTH.getValue())) {
			positionY--;

		} else if (facingTo.equals(Compass.WEST.getValue())) {
			positionX--;
		}
	}

	// if it´s in NORTH, go to WEST.
	private void left() {
		Integer currentPosition = --facingTo;
		facingTo = currentPosition < Compass.NORTH.getValue() ? Compass.WEST
				.getValue() : Compass.getByValue(currentPosition).getValue();
	}

	// if it´s in WEST, go to NORTH.
	private void right() {
		Integer currentPosition = ++facingTo;
		facingTo = currentPosition > Compass.WEST.getValue() ? Compass.NORTH
				.getValue() : Compass.getByValue(currentPosition).getValue();
	}

	@Override
	public MarsRover startingAtPosition(Integer x, Integer y, Integer facing) {
		positionX = x;
		positionY = y;
		facingTo = facing;
		return this;
	}

	// Just a future thought :)
	@Override
	public Boolean isCrashedWith(Rover<?> anotherRover) {
		return false;
	}

	/*
	 * Command route is only for MarsRover - VenusRover not necessarily will
	 * need the same kind of command structure.
	 */
	public MarsRover withRoute(String commands) {
		this.commands = commands;
		return this;
	}

}