package adventofCode;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class day1 {

	public static void main(String[] args) {
		System.out.println("Welcolme to Advent of Code - Day 1: Inverse Captcha");
		System.out.println("Please enter your puzzle input:");
		String input = "";
		Scanner scanner = new Scanner(System.in);
		try {
			input = scanner.nextLine();		
		} catch (NoSuchElementException e) {
			System.out.println("Input was empty!");
			System.exit(0);
		} finally {
			scanner.close();
		}
		int result = calculateCaptcha(input);
		System.out.println("Result of captcha is " + result);
	}

	private static int calculateCaptcha(String input) {
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

}
