package com.tw.hiring.rover.mars;

import com.tw.hiring.rover.Compass;
import com.tw.hiring.rover.Rover;

/**
 * @author Cassio Dias http://cassiodias.com.br
 */
public class NasaLauncher {

	public static void main(String args[]) {
		
		
		
		Rover<MarsRover> rover1 = new MarsRover().withRoute("LMLMLMLMM")
				.startingAtPosition(1, 2, Compass.NORTH.getValue());
		rover1.goWalk();

		Rover<MarsRover> rover2 = new MarsRover().withRoute("MMRMMRMRRM")
				.startingAtPosition(3, 3, Compass.EAST.getValue());
		rover2.goWalk();

		System.out.println(rover1.whereIAm()); // 1,3, North
		System.out.println(rover2.whereIAm()); // 5,1, East
	}

}
