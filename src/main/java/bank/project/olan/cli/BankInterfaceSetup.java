package bank.project.olan.cli;

import bank.project.olan.data.Accounts;
import bank.project.olan.data.Data;

import java.util.Scanner;

public class BankInterfaceSetup {
    private Data data = new Data();
    private final Scanner scanner = new Scanner(System.in);

    // Helper method to authenticate the user and get the corresponding account
    private static Accounts authenticateAndGetAccount(Data data, String userId, String password) {
        for (Accounts account : data.getAccountsList()) {
            if (account.getUserID().equals(userId) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public void createAccount() {
        System.out.println("Please provide a User ID (Must be a minimum of 8 6 characters");
        String newUserId = scanner.nextLine();
        System.out.println("Please provide a secure password (Must be a minimum of 8 characters, containing at least One Uppercase, number and special ('*_' etc.) characters");
        String userPassword = scanner.nextLine();
        System.out.println("Provide an amount you are able to set your balance too");
        int userBalance = Integer.parseInt(scanner.nextLine());
        Accounts userAccount = new Accounts(newUserId, userPassword, userBalance);
        System.out.println("Thank you for creating an account, your generated Iban is: " + userAccount.getIban());
        data.addAccount(userAccount);
    }

    public void viewBal() {
        //TODO
    }

    public void deposit() {
        //TODO
    }

    public void withdraw() {
        //TODO
    }

    public void transfer(){
        //TODO
    }

}
