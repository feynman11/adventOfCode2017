package adventofCode;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class day1 {

	public void go() {
		System.out.println("Welcolme to Advent of Code - Day 1: Inverse Captcha");
		System.out.println("Please enter your puzzle input:");
		String input = "";
		Scanner scanner = new Scanner(System.in);
		try {
			input = scanner.nextLine();		
		} catch (NoSuchElementException e) {
			System.out.println("Input was empty!");
			throw e;
		} finally {
			scanner.close();
		}
		int result1 = calculateCaptcha1(input);
		int result2 = calculateCaptcha2(input);
		System.out.println("Result of captcha (part 1) is " + result1);
		System.out.println("Result of captcha (part 2) is " + result2);
		
	}

	private static int calculateCaptcha1(String input) {
		int[] inputArray = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			inputArray[i] = input.charAt(i) - '0';
		}
		int result = 0;
		int last = inputArray[inputArray.length -1];
		for (int j = 0; j < inputArray.length; j++) {
			if(last == inputArray[j]) {
				result = result + last;
			}
			last = inputArray[j];
		}
		return result;
		
	}
	
	private static int calculateCaptcha2(String input) {
		int[] inputArray = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			inputArray[i] = input.charAt(i) - '0';
		}
		int result = 0;
		int inputArrayLength = inputArray.length;
		int compareIndex = (inputArrayLength) / 2;
		for (int j = 0; j < inputArrayLength; j++) {
			if(inputArray[compareIndex] == inputArray[j]) {
				result = result + inputArray[compareIndex];
			}
			compareIndex++;
			if (compareIndex >= inputArrayLength) {
				compareIndex = compareIndex - inputArrayLength;
			}
		}
		return result;
		
	}

}
