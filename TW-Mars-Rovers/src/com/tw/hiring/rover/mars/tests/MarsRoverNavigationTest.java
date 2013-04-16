package com.tw.hiring.rover.mars.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.hiring.rover.Compass;
import com.tw.hiring.rover.mars.MarsRover;

/**
 * @author Cassio Dias
 */
public class MarsRoverNavigationTest {

	private BufferedReader br;

	private static final String FILE_NAME = "marscommand.txt";

	@Before
	public void setUp() throws Exception {
		// simple load file to read the rover´s commands.
		try {
			FileInputStream fstream = new FileInputStream(new File(getClass()
					.getResource(MarsRoverNavigationTest.FILE_NAME).toURI()));
			br = new BufferedReader(new InputStreamReader(new DataInputStream(
					fstream)));
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	@Test
	public void testMovement() {
		String strLine = null;
		MarsRover rover = new MarsRover();
		try {
			while ((strLine = br.readLine()) != null) {
				if (strLine.charAt(0) != '#') {

					String inputCommand = strLine.split(";")[0];
					String commands = (inputCommand.split(",")[0]).trim();

					String expected = strLine.split(";")[1].trim();

					String startPosition = (inputCommand.split(",")[1]).trim();
					String[] startPositionSplitted = startPosition.split(" ");

					rover.withRoute(commands).startingAtPosition(
							Integer.valueOf(startPositionSplitted[0]),
							Integer.valueOf(startPositionSplitted[1]),
							Compass.getByName(startPositionSplitted[2])
									.getValue());
					rover.goWalk();
					assertEquals(
							"Attention, rover didnt take the correct path...",
							expected, rover.whereIAm());
				}
			}
		} catch (IOException e) {
			fail("Oppps, fail to read input data.");
		}

	}

	@After
	public void tearDown() throws Exception {
		br.close();
	}

}