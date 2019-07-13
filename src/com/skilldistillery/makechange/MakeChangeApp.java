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
		} // end if statement
		else {
			System.out.print("Your change will be: ");
			int change = changeEquation(cost, payment);
			whatChangeWillBe(change);

//			System.out.println(cost);
//			System.out.println(payment);
//			System.out.println(change);

		} // end of else
		kb.close();
	}// end of main

	private static void whatChangeWillBe(int change) {
		if (change >= 1000) {
			change %= 1000;
			System.out.print("1 ten, ");
//			System.out.println("****" + change);
		}

		if (change >= 500) {
			change %= 500;
			System.out.print("1 five, ");
//			System.out.println("****" + change);
		}

		if (change >= 200) {
			int dollars = change / 100;
			System.out.print(dollars + " singles, ");
			change %= 100;
//			System.out.println("****" + change);
		} else if (change >= 100) {
			int dollar = change / 100;
			System.out.print(dollar + " dollar, ");
			change %= 100;
//			System.out.println("****" + change);
		} // dollars if

		if (change >= 50) {
			int quarters = (change / 25);
			System.out.print(quarters + " quarters, ");
			change %= 25;
//			System.out.println("****" + change);
		} else if (change >= 25) {
			int quarter = (change / 25);
			System.out.print(quarter + " quarter, ");
			change %= 25;
//			System.out.println("****" + change);
		} // quarters if

		if (change >= 20) {
			int dimes = (change / 10);
			System.out.print(dimes + " dimes, ");
			change %= 10;
//			System.out.println("****" + change);
		} else if (change >= 10) {
			int dime = (change / 10);
			System.out.print(dime + " dime, ");
			change %= 10;
//			System.out.println("****" + change);
		} // dimes if

		if (change >= 5) {
			System.out.print("1 nickel, ");
			change %= 5;
//			System.out.println("****" + change);
		} // nickel if
		
		if (change > 1) {
			int pennies = (change / 1);
			System.out.print(pennies + " pennies.");
			change %= 1;
//			System.out.println("****" + change);
		} else if (change == 1) {
			System.out.print(change + " penny.");
			change %= 1;
//			System.out.println("****" + change);
		}// pennies if
		
	}// end of whatChangeWillBe

	private static int changeEquation(double cost, double payment) {
		cost *= 100;
		payment *= 100;
		int change = (int) (payment - cost);
		return change;
	}// end changeEquation

	private static boolean tooLittleOrExactMoney(double cost, double payment) {
		if (payment < cost) {
			System.out.println("You cannot buy you this item, you are too poor.");
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
