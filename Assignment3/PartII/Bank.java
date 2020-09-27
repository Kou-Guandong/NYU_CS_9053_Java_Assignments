import java.util.Scanner;
import java.util.*;

public class Bank {

	public static final int NUM_ACCOUNTS = 5;
	private Account[] accounts;

	public Bank() {
		// create NUM_ACCOUNTS accounts in an array
		// with each account having a starting balance
		// of $1000
		this.accounts = new Account[Bank.NUM_ACCOUNTS];
		for (int i = 0; i < NUM_ACCOUNTS; i++) {
			this.accounts[i] = new Account(1000);
		}
	}

	public Account getAccountById(int id) {
		// this should take an id, search
		// through the array of accounts until
		// it finds the account matching the id
		// and returns it, returning null if
		// it is not found
		Optional<Account> result = Arrays.stream(this.accounts).filter(x -> x.getId() == id).findAny();
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	public int numAccounts() {
		// returns the number of accounts:
		// ie, the length of the array accounts
		return this.accounts.length;
	}

	public Account[] getAllAccounts() {
		return this.accounts;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Bank bank = new Bank();
		for (;;) {
			System.out.println("Accounts:");
			Account[] accounts = bank.getAllAccounts();
			for (int i = 0; i < accounts.length; i++) {
				System.out.println("Account " + accounts[i].getId() + ": $" + accounts[i].getBalance());
			}
			System.out.print("Enter source account: ");
			int srcAccountId = in.nextInt();
			Account srcAccount = bank.getAccountById(srcAccountId);
			if (srcAccount == null) {
				System.out.println("no such account id. Starting over");
				continue;
			}
			System.out.print("Enter destination account: ");
			int destAccountId = in.nextInt();
			Account destAccount = bank.getAccountById(destAccountId);
			if (destAccount == null) {
				System.out.println("no such account id. Starting over");
				continue;
			}
			System.out.print("Enter transfer amount: ");
			double transferAmount = in.nextDouble();
			boolean withdrawlResult = srcAccount.withdraw(transferAmount);
			if (withdrawlResult) {
				destAccount.deposit(transferAmount);
			} else {
				System.out.println("cannot withdraw more money than is in account");
				continue;
			}
		}
	}
}
