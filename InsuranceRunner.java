package ie.atu.dip;

import java.util.Scanner;

public class InsuranceRunner {
	public static void main (String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your age: ");
			int age = input.nextInt();
			
			System.out.println("How many accidents did you have? ");
			int accidents = input.nextInt();
			
			Calculator calculator = new Calculator();
			int cost = calculator.calculateInsurance(age, accidents);
			System.out.println("Total amount to pay: " + cost);
			
			if (accidents > 6) {
				Calculator.isInsuranceDenied(age, accidents);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
