package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.println("Number: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Holder: ");
		String holder = scanner.nextLine();
		System.out.print("Initial balance: ");
		double balance = scanner.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = scanner.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("Enter amount for withdraw: ");
		double amount = scanner.nextDouble();
		try {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f" , account.getBalance());
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
