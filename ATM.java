/*
@Author @Nelson
*/
package atm_Test;

import java.util.Scanner;

package atm_Test;

import java.util.Scanner;

public class ATM {

	private static final Scanner userInput = new Scanner(System.in);
	private static double balance;
	private static int depositCount = 0;
	private static int dailyDepositAmount = 0;
	private static int dailyWithdrawalAmount = 0;
	private static int withdrawalCount = 0;

	public ATM(int balance) {
		ATM.balance = balance;
	}

	public static void main(String[] args) {
		// Instantiate the AtmProgram with a balance of 50000.
		ATM startBalance = new ATM(150000);
		startProgram();
	}

	public static void startProgram() {
		// Display menu
		// Start by prompting the user to enter an action.
		System.out.println("********************************************************");
		System.out.println("Please select option" + "\n" + "1. Balance" + "\n" + "2. Deposit" + "\n" + "3. Withdraw"
				+ "\n" + "4. Quit");
		int option = userInput.nextInt();

		switch (option) {
		case 1:
			System.out.println("********************************************************");
			System.out.println("BALANCE" + "\n" + getBalance());
			quitTransaction();

			break;
		case 2:
			// Verify that the deposit count in the day does not exceed 4.
			System.out.println("********************************************************");
			if (getDepositCount() >= 4) {
				System.out.println("Max Deposit number of time is 4");
				quitTransaction();
			}
			// Prompt user to enter amount.
			setDepositCount();
			System.out.println("Enter Amount to deposit: ");
			double amount = userInput.nextDouble();
			if (amount > 40000) {
				System.out.println("Max Deposit is 40000");
				quitTransaction();
			}
			// Verify that the amount deposited is not less than 1.
			else if (amount < 1) {
				System.out.println("Minimum Deposit is 1");
				quitTransaction();
			}
			// Verify that the total amount deposited for a day is not greater than 150000.
			if (getDailyDepositAmount() > 150000 || ((getDailyDepositAmount() + amount) > 150000)) {
				System.out.println("Total maximum deposit allowed in a day is 150000");
				quitTransaction();
			}
			// Make Deposit
			setDeposit(amount);
			setDailyDepositAmount(amount);
			System.out.println("New Balance: " + getBalance());
			System.out.println("Total deposit for today is: " + getDailyDepositAmount() + "\n"
					+ "No of times deposited today:" + getDepositCount());
			quitTransaction();

			break;
		case 3:
			System.out.println("********************************************************");
			// Verify that the maximum withdrawal count for the day does not exceed 3.
			if (getWithdrawalCount() >= 3) {
				System.out.println("Max number of withdrawal in a day is 3");
				quitTransaction();
			}
			// Get amount to withdraw.
			System.out.println("Enter the amount you want to withdraw: ");
			double amt = (userInput.nextDouble());
			if (amt > 20000) {
				System.out.println("Withdraw 20000 per transaction");
				quitTransaction();
			}
			// Verify that the amount to withdraw is not less than 1.
			if (amt < 1) {
				System.out.println("Minimum allowed withdrawal is 1");
				quitTransaction();
			}
			// Verify that the amount to withdraw in the day is not greater than 50000.
			if (getDailyWithdrawalAmount() > 50000) {
				System.out.println("Maximum deposit allowed in a day is 50000");
				quitTransaction();
			}
			// Verify that the amount to withdraw is not larger than amount in the account.
			if (getBalance() < amt) {
				System.out.println("Insufficient Funds!! " + getBalance());
				quitTransaction();
			}
			// Withdrawal
			setWithdrawalCount();
			setDailyWithdrawalAmount(amt);
			makeWithdrawal(amt);
			if (balance < 0) {
				System.out.println("Insufficient Funds");
				quitTransaction();
			} else {
				System.out.println("New Balance\t\t" + getBalance());
				System.out.println("Amount Withdrawn: " + getDailyWithdrawalAmount() + "" + getWithdrawalCount());
				quitTransaction();
				break;
			}
		case 4:
			System.out.println("********************************************************");
			// Verify that the user wishes to quit.
			quitTransaction();
			break;
		default:
			// Checks that an invalid input is handled.
			System.out.println("Invalid choice!!!");
			quitTransaction();
			break;
		}
	}

	public static void quitTransaction() {
		System.out.println(
				"\n" + "Do you wish to end your Transaction?\n\nPress 1 For another transaction\n\nPress 2 To exit");
		// Scanner userInput = new Scanner(System.in);
		int anotherTransaction = userInput.nextInt();
		if (anotherTransaction == 1) {
			startProgram();
		} else if (anotherTransaction == 2) {
			System.out.println("Thanks You");
			System.exit(0);
		} else {
			System.out.println("Invalid choice\n\n");
			System.exit(0);
		}

	}

	// getter and setter methods for the program.
	public static double getBalance() {
		return balance;
	}

	public static void setDeposit(double amount) {

		ATM.balance = amount + balance;

	}

	public static int getDepositCount() {
		return depositCount;
	}

	public static void setDepositCount() {
		depositCount += 1;

	}

	public static void setDailyDepositAmount(double amount) {
		dailyDepositAmount += amount;
	}

	public static int getDailyDepositAmount() {
		return dailyDepositAmount;
	}

	public static int getDailyWithdrawalAmount() {
		return dailyWithdrawalAmount;
	}

	public static void setDailyWithdrawalAmount(double amt) {
		dailyWithdrawalAmount += amt;

	}

	public static void setWithdrawalCount() {
		withdrawalCount += 1;
	}

	public static int getWithdrawalCount() {
		return withdrawalCount;
	}

	private static void makeWithdrawal(double amt) {
		balance -= amt;
	}

}
