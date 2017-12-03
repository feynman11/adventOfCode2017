package adventofCode;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class day3 {

	public void go() {
		System.out.println("Welcolme to Advent of Code - Day 3: Spiral Memory");
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
		//Calculate closes square number to input
		double steps = getSteps(Double.parseDouble(input));
		
		
		System.out.println("Number of steps to input is " + steps);
		//Part 2
		//https://oeis.org/A141481

	}

	private double getSteps(double input) {
		double root = Math.ceil(Math.sqrt(input));
		double curRadius = root % 2 != 0 ? root : root + 1; 
		double numRadius = (curRadius - 1)/2;
		double cycle = input - (Math.pow((curRadius -2),2));
		double innerOffset = cycle % (curRadius - 1);
		return numRadius + Math.abs(innerOffset - numRadius);
	}
	
	

}
