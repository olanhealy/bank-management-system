package bank.project.olan.data;

import bank.project.olan.data.Accounts;

public class Transactions {


    /*
    This class is for managing the different transactions you would typically be able to do with a bank.
    You are able to view balance, deposit, withdraw,  deposit or make a transaction to another customer of the bamk.
    To make a transaction, you will need to know the other customers id (I plan time depending on changing every customer to be given a
    generated code sort of similar to a Iban. So my bank is Olans Banker Empire So maybe having a code like OLAXXXXXXXXXX.
    This is bank Init followed by 10 digits to provide a more secure service

    */

    public static String viewBal(Accounts acc) {
        int bal = acc.getBalance();
        return "Your bank balance is: €" + bal;
    }

    public static void deposit(Accounts acc, String amt) {
        try {
            int amount = Integer.parseInt(amt);

            if (amount > 0) {
                int currentBal = acc.getBalance();
                int newBal = currentBal + amount;
                acc.setBalance(newBal);

                System.out.println("Deposit successful. Your new balance: €" + newBal);
            } else {
                System.out.println("Invalid deposit amount. Please enter a positive integer.");
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            System.out.println("Invalid input. Please enter a valid integer amount for deposit.");
        }
    }

    public static void withdraw(Accounts acc, String amt) {
        try {
            int amount = Integer.parseInt(amt);
            int currentBal = acc.getBalance();


            if (currentBal >= amount && amount > 0) {
                int newBal = currentBal - amount;
                acc.setBalance(newBal);

                System.out.println("Withdraw successful. Your new balance is: €" + newBal);
            } else {
                System.out.println("Insufficent funds for withdrawl.");
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            System.out.println("Invalid input. Please enter a valid integer amount for deposit.");
        }

    }


    public static void transfer(Accounts sender, Accounts recipient, String amt) {
        try {
            int amount = Integer.parseInt(amt);
            int senderBal = sender.getBalance();


            if (senderBal >= amount && amount > 0) {
                int newSenderBal = senderBal - amount;
                sender.setBalance(newSenderBal);

                int recipientBal = recipient.getBalance();
                ;
                int newRecipientBal = recipientBal + amount;
                recipient.setBalance(newRecipientBal);
                System.out.println("Transfer successful. Your new balance is: €" + newSenderBal);
            } else {
                // Insufficient funds
                System.out.println("Insufficient funds for the transfer.");
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            System.out.println("Invalid input. Please enter a valid integer amount for deposit.");
        }
    }
}



