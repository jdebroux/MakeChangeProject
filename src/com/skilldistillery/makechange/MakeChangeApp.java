package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double cost = askUser1(kb);
		double payment = askUser2(kb);
		boolean hasEnough$ = tooLittleOrExactMoney(cost, payment);
		if (hasEnough$ == false) {
			System.exit(0);
		}//end if statement
		else {
			
		}// end of else
		kb.close();
	}// end of main

	private static boolean tooLittleOrExactMoney(double cost, double payment) {
		if (payment < cost) {
			System.out.println("You cannot buy you this item, you are too poor.");
			return (false);
		}//end if statement
		else if (payment == cost) {
			System.out.println("You paid with exact change.  Have a terrific day!");
			return (false);
		}//end else if
		else {
			return (true);
		}//end else
	}// end tooLittleMoney

	private static double askUser1(Scanner user1) {
		System.out.print("How much is the item being purchased? ");
		double cost = user1.nextDouble();
		return cost;
	}// end of askUser1

	public static double askUser2(Scanner user2) {
		System.out.print("How much are you paying with? ");
		double payment = user2.nextDouble();
		return payment;

	}// end of askUser2
}// end of class
