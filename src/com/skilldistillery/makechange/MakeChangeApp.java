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
		} else {
			int change = changeEquation(cost, payment);
			exactChange(change);
			changeInBills(change);
		} // end if statement
		kb.close();
	}// end of main

	private static void changeInBills(int change) {
		change = twenties(change);
		change = ten(change);
		change = five(change);
		change = singles(change);
		change = quarters(change);
		change = dimes(change);
		change = nickel(change);
		change = pennies(change);
	}

	private static void exactChange(int change) {
		double exactChange = ((double) change) / 100;
		System.out.println("Your change is: $" + exactChange);
		System.out.print("Here is ");
	}// end exactChange

	private static int twenties(int twentiesChange) {
		int twenties = 0;
		if (twentiesChange >= 4000) {
			twenties = twentiesChange / 2000;
			System.out.print(twenties + " twenties");
			twentiesChange %= 2000;
			amIDone(twentiesChange);
//		System.out.println("****" + twentiesChange);
		} else if (twentiesChange >= 2000) {
			twenties = twentiesChange / 2000;
			System.out.print(twenties + " twenty");
			twentiesChange %= 2000;
			amIDone(twentiesChange);
//			System.out.println("****" + twentiesChange);
		}
		return twentiesChange;
	}

	private static int ten(int tenChange) {
		if (tenChange >= 1000) {
			tenChange %= 1000;
			System.out.print("1 ten");
			amIDone(tenChange);
		}
//			System.out.println("****" + tenChange);
		return tenChange;
	}// end tens

	private static int five(int fiveChange) {
		if (fiveChange >= 500) {
			fiveChange %= 500;
			System.out.print("1 five");
			amIDone(fiveChange);
		}
//			System.out.println("****" + fiveChange);
		return fiveChange;
	}// end fives

	private static int singles(int dollarsChange) {
		int dollars = 0;
		if (dollarsChange >= 200) {
			dollars = dollarsChange / 100;
			System.out.print(dollars + " singles");
			dollarsChange %= 100;
			amIDone(dollarsChange);
//			System.out.println("****" + dollarsChange);
		} else if (dollarsChange >= 100) {
			dollars = dollarsChange / 100;
			System.out.print(dollars + " dollar");
			dollarsChange %= 100;
			amIDone(dollarsChange);
//			System.out.println("****" + dollarsChange);
		}
		return dollarsChange;
	}// end singles

	private static int quarters(int quartersChange) {
		if (quartersChange >= 50) {
			int quarters = (quartersChange / 25);
			System.out.print(quarters + " quarters");
			quartersChange %= 25;
			amIDone(quartersChange);
//			System.out.println("****" + quartersChange);
		} else if (quartersChange >= 25) {
			int quarter = (quartersChange / 25);
			System.out.print(quarter + " quarter");
			quartersChange %= 25;
			amIDone(quartersChange);
//			System.out.println("****" + quartersChange);
		}
		return quartersChange;
	}// end quarters

	private static int dimes(int dimesChange) {
		if (dimesChange >= 20) {
			int dimes = (dimesChange / 10);
			System.out.print(dimes + " dimes");
			dimesChange %= 10;
			amIDone(dimesChange);
//			System.out.println("****" + dimesChange);
		} else if (dimesChange >= 10) {
			int dime = (dimesChange / 10);
			System.out.print(dime + " dime");
			dimesChange %= 10;
			amIDone(dimesChange);
//			System.out.println("****" + dimesChange);
		} //
		return dimesChange;
	}// end dimes

	private static int nickel(int nickelChange) {
		if (nickelChange >= 5) {
			System.out.print("1 nickel");
			nickelChange %= 5;
			amIDone(nickelChange);
//			System.out.println("****" + nickelChange);
		}
		return nickelChange;
	}// end nickel

	private static int pennies(int penniesChange) {
		if (penniesChange > 1) {
			int pennies = (penniesChange / 1);
			System.out.print(pennies + " pennies.");
			penniesChange %= 1;
//			System.out.println("****" + penniesChange);
		} else if (penniesChange == 1) {
			System.out.print(penniesChange + " penny.");
			penniesChange %= 1;
//			System.out.println("****" + penniesChange);
		}
		return penniesChange;
	}// end Pennies

	private static void amIDone(int remainder) {
		if (remainder == 0) {
			System.out.println(".  Please come again.");
		} else
			System.out.print(", ");
	}// end amIDone

	private static int changeEquation(double cost, double payment) {
		cost *= 100;
		payment *= 100;
		int change = (int) (payment - cost);
		return change;
	}// end changeEquation

	private static boolean tooLittleOrExactMoney(double cost, double payment) {
		if (payment < cost) {
			System.out.println("You don't have enough money for this purchase.");
			return (false);
		} // end if statement
		else if (payment == cost) {
			System.out.println("You paid with exact change.  Have a terrific day!");
			return (false);
		} // end else if
		else {
			return (true);
		} // end else
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
