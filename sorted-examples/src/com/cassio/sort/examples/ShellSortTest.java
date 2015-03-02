package com.cassio.sort.examples;

public class ShellSortTest {

	public static void main(String[] args) {
		Integer[] sortedValues = new ShellSortTest().sortThem(
				new Integer[]{ 5000, 6, 5, 4, 300, 3, 2, 1, 0 });
		for (Integer value : sortedValues) {
			System.out.print(value + " ");
		}
	}

	public Integer[] sortThem(Integer[] numbers) {
		Integer originalSize = numbers.length;
		// generates the gap.
		Integer gap = generatesShellGap(originalSize);
		
		while (gap > 0) {
			
			for (Integer i = gap; i < originalSize; i++) {
				
				Integer valueToMoveDown = numbers[i];
				Integer postitionToGoDown = i;
				
				while (postitionToGoDown >= gap && numbers[postitionToGoDown - gap] > valueToMoveDown) {
					numbers[postitionToGoDown] = numbers[postitionToGoDown - gap]; // moving up greater value.
					postitionToGoDown = postitionToGoDown - gap;
				}
				
				numbers[postitionToGoDown] = valueToMoveDown;
			}
			gap = gap / 2;
			
		}
		return numbers;
	}

	/**
	 * @param gap
	 * @param originalSize
	 * @return
	 */
	private Integer generatesShellGap(Integer originalSize) {
		Integer gap = 1;
		while (gap < originalSize) {
			gap = gap * 3 + 1;
		}
		gap = gap / 3;
		return gap;
	}
}
