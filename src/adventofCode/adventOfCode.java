package adventofCode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class adventOfCode {

	public static void main(String[] args) {
		System.out.println("Welcolme to Advent of Code");
		System.out.println("Please enter the day you're running:");
		int input = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			input = scanner.nextInt();
			
			switch(input) {
			case 1 : new day1().go();
			case 2 : new day2().go();
			default : System.out.println("Day entered not valid");
			}	
			
		} catch (InputMismatchException e) {
			System.out.println("The day must be an integer");
			System.exit(0);
		} finally {
			scanner.close();
		}
	}

}
