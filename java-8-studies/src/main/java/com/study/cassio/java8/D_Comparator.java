package com.study.cassio.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D_Comparator {

	public static void main(String[] args) {
		List<String> someWords = Arrays
				.asList("ZZZ", "003", "XX", "AAA", "001");

		System.out.println("Natural order \n");
		someWords.sort(Comparator.naturalOrder());
		for (String word : someWords) {
			System.out.println(word);
		}

		System.out.println("Reverse order \n");
		someWords.sort(Comparator.reverseOrder());

		for (String word : someWords) {
			System.out.println(word);
		}

	}

}
