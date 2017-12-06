package adventofCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day6 {

	public void go() {
		System.out.println("Welcolme to Advent of Code - Day 6: Memory Reallocation");
		String input = getInput();
		String[] inputArray = input.split("\\s");
		int[] blocks = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			blocks[i] = Integer.parseInt(inputArray[i]);
		}
		// Calculate closes square number to input
		reAllocate(blocks);
	}

	private void reAllocate(int[] blocks) {
		List<int[]> blockList = new ArrayList<int[]>();
		int steps = 0;
		boolean part2 = true;
		int firstRepeatStep = 0;
		int[] firstRepeat = null;
		while (true) {
			if (isInList(blockList, blocks)) {
				if (!part2) {
					System.out.println("Number of steps for part 1 is " + steps);
					break;					
				} else {
					if(firstRepeat == null) {
						firstRepeat = blocks.clone();
						firstRepeatStep = steps;					
					} else {
						if(Arrays.equals(firstRepeat, blocks)) {
							System.out.println("Number of steps for part 1 is " + firstRepeatStep);
							System.out.println("Number of steps for part 2 is " + (steps - firstRepeatStep));
							break;
						}
						
					}
				}
			} else {
				blockList.add(blocks.clone());
			}
			int max = 0;
			int maxIndex = 0;
			for (int i = 0; i < blocks.length; i++) {
				if (blocks[i] > max) {
					max = blocks[i];
					maxIndex = i;
				}
			}
			int index = (maxIndex == blocks.length - 1) ? 0 : maxIndex + 1;
			while (max >= 1) {
				blocks[index]++;
				blocks[maxIndex]--;
				index = (index == blocks.length - 1) ? 0 : index + 1;
				max--;
			}
			steps++;
		}
	}

	public static boolean isInList(final List<int[]> list, final int[] candidate) {
		return list.stream().anyMatch(a -> Arrays.equals(a, candidate));
	}

	private String getInput() {
		 return "5 1 10 0 1 7 13 14 3 12 8 10 7 12 0 6";
	}

}
