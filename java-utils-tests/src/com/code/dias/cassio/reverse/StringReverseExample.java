package com.code.dias.cassio.reverse;

public class StringReverseExample {

    /**
     * Simple inversion
     *  
     * @param args
     */
    public static void main(String[] args) {
	String[] someString = { "3", "2", "1" };
	String temp;

	int goLeft = 0;
	int goRight = someString.length - 1;

	while (goLeft < goRight) {
	    temp = someString[goLeft];
	    someString[goLeft] = someString[goRight];
	    someString[goRight] = temp;

	    goLeft++;
	    goRight--;
	}

	for (int i = 0; i < someString.length; i++) {
	    System.out.println(someString[i]);
	}

    }

}
