package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double cost = askUser1(kb);
		double payment = askUser2(kb);
		boolean hasEnough$ = false;
		while (payment < cost) {
			tooLittleOrExactMoney(cost, payment);
			cost = cost - payment;
			payment = askUser2(kb);
		}
		hasEnough$ = tooLittleOrExactMoney(cost, payment);
		if (hasEnough$ == false) {
			System.exit(0);
		} else {
			int change = changeEquation(cost, payment);
			changeType(change);
			changeInBills(change);
		} // end if statement
		kb.close();
	}// end of main

	private static void changeInBills(int change) {
		change = hundreds(change);
		change = fifties(change);
		change = twenties(change);
		change = ten(change);
		change = five(change);
		change = singles(change);
		change = quarters(change);
		change = dimes(change);
		change = nickel(change);
		change = pennies(change);
	}// end changeInBills

	private static void changeType(int change) {
		double exactChange = ((double) change) / 100;

		System.out.print("Customer change is: $" + exactChange + ".");
		System.out.print("\n\nPay the customer: \n\n* ");
	}// end exactChange

	private static int hundreds(int hundredsChange) {
		int hundreds = 0;
		if (hundredsChange >= 20000) {
			hundreds = hundredsChange / 10000;
			System.out.print(hundreds + " hundred dollar bills");
			hundredsChange %= 10000;
			amIDone(hundredsChange);
//		System.out.println("****" + hundredsChange);
		} else if (hundredsChange >= 10000) {
			hundreds = hundredsChange / 10000;
			System.out.print(hundreds + " hundred dollar bill");
			hundredsChange %= 10000;
			amIDone(hundredsChange);
//			System.out.println("****" + hundredsChange);
		}
		return hundredsChange;
	}// end hundereds

	private static int fifties(int fiftiesChange) {
		if (fiftiesChange >= 5000) {
			fiftiesChange %= 5000;
			System.out.print("1 fifty dollar bill");
			amIDone(fiftiesChange);
		}
//			System.out.println("****" + fiftiesChange);
		return fiftiesChange;
	}// end fifties

	private static int twenties(int twentiesChange) {
		int twenties = 0;
		if (twentiesChange >= 4000) {
			twenties = twentiesChange / 2000;
			System.out.print(twenties + " twenty dollar bills");
			twentiesChange %= 2000;
			amIDone(twentiesChange);
//		System.out.println("****" + twentiesChange);
		} else if (twentiesChange >= 2000) {
			twenties = twentiesChange / 2000;
			System.out.print(twenties + " twenty dollar bill");
			twentiesChange %= 2000;
			amIDone(twentiesChange);
//			System.out.println("****" + twentiesChange);
		}
		return twentiesChange;
	}// end twenties

	private static int ten(int tenChange) {
		if (tenChange >= 1000) {
			tenChange %= 1000;
			System.out.print("1 ten dollar bill");
			amIDone(tenChange);
		}
//			System.out.println("****" + tenChange);
		return tenChange;
	}// end ten

	private static int five(int fiveChange) {
		if (fiveChange >= 500) {
			fiveChange %= 500;
			System.out.print("1 five dollar bill");
			amIDone(fiveChange);
		}
//			System.out.println("****" + fiveChange);
		return fiveChange;
	}// end five

	private static int singles(int dollarsChange) {
		int dollars = 0;
		if (dollarsChange >= 200) {
			dollars = dollarsChange / 100;
			System.out.print(dollars + " single dollar bills");
			dollarsChange %= 100;
			amIDone(dollarsChange);
//			System.out.println("****" + dollarsChange);
		} else if (dollarsChange >= 100) {
			dollars = dollarsChange / 100;
			System.out.print(dollars + " dollar bill");
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
			System.out.print(pennies + " pennies");
			penniesChange %= 1;
			amIDone(penniesChange);
//			System.out.println("****" + penniesChange);
		} else if (penniesChange == 1) {
			System.out.print(penniesChange + " penny");
			penniesChange %= 1;
			amIDone(penniesChange);
//			System.out.println("****" + penniesChange);
		}
		return penniesChange;
	}// end Pennies

	private static void amIDone(int remainder) {
		if (remainder == 0) {
			System.out.println(". *\n");
			System.out.println("\t\t************************************");
			System.out.println("\t\t* Thank them for shopping with us! *");
			System.out.println("\t\t************************************");
		} else
			System.out.print(", ");
	}// end amIDone

	private static int changeEquation(double cost, double payment) {
		int change = (int) (payment - cost);
		return change;
	}// end changeEquation

	private static boolean tooLittleOrExactMoney(double cost, double payment) {
		if (payment < cost) {
			System.out.println("Customer did not provide enough money for this purchase.");
			double balance = cost - payment;
			balance /= 100;
			System.out.println("\nRemaining balance owed: " + balance + "\n");
			return (true);
		} // end if statement
		else if (payment == cost) {
			System.out.println("\nCustomer paid with exact change.\n");
			System.out.println("\t\t************************************");
			System.out.println("\t\t* Thank them for shopping with us! *");
			System.out.println("\t\t************************************");
			return (false);
		} // end else if
		else {
			return (true);
		} // end else
	}// end tooLittleMoney

	private static int askUser1(Scanner user1) {
		System.out.print("Purchase Total: ");
		double cost = user1.nextDouble();
		int costAsI = (int) (cost * 100);
		return costAsI;
	}// end of askUser1

	public static int askUser2(Scanner user2) {
		System.out.print("Payment Amount: ");
		double payment = user2.nextDouble();
		int paymentAsI = (int) (payment * 100);
		return paymentAsI;
	}// end of askUser2
}// end of class
