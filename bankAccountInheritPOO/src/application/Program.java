package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
	public static void main(String[] args) {

		// CASTING
		// DOWNCASTING
		// UPCASTING

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		System.out.println(acc);

		// UPCASTING

		Account acc1 = bacc; // BusinessAccount is an Account, because of that it can be assigned to a
								// BussinessAccount object to an account object.
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);
		acc1.getBalance();

		// DOWNCASTING

		BusinessAccount acc4 = (BusinessAccount) acc2; // downcasting is only possible by casting first
		acc4.loan(0);

		// BusinessAccount acc5 = (BusinnesAccount)acc3;
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}

		// Testing Override in SavingsAccount and Override in BussinesAccount(using Super() to guarantee an account rule, and a new rule was also implemented.)
		
		// Using Normal Account
		Account acc6 = new Account(1005, "Alex", 1000.0);
		acc6.withdraw(200.0);
		System.out.println(
				"(There was a $5 discount from a regular account)\n Accont Balance = " 
						+ acc6.getBalance());
		
		// Using SavingsAccount
		Account acc7 = new SavingsAccount(1006, "Joao", 1000.0, 0.01);
		acc7.withdraw(200.0);
		System.out.println(
				"(There was no $5 discount as a regular account, because it is a Savings Account where the withdrawal method was replaced, where there was no discount)\n Accont Balance = "
						+ acc7.getBalance());
		
		// Using BusinessAccount
		Account acc8 = new BusinessAccount(1007, "Bob", 1000.0, 500.0);
		acc8.withdraw(200.0);
		System.out.println(
				"(There was $5 discount as a regular account, in addition, there is also a +$2 discount)\n Accont Balance = "
						+ acc8.getBalance());

	}
}
