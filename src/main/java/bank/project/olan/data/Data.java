package bank.project.olan.data;

import bank.project.olan.data.Accounts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/*
  This class is for loading data from a CSV. also saving and autorising user login. Needs a bit of work as currently save not working as expected
 */
public class Data {
    private List<Accounts> accountsList;
    private final static String CSV_FILE_NAME = "Csv/bankAccounts.CSV";

    public Data() {
        this.accountsList = loadAccountsFromCSV();
    }

    private List<Accounts> loadAccountsFromCSV() {
        List<Accounts> accounts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String userID = values[0].trim();
                String password = values[1].trim();
                int balance = Integer.parseInt(values[2].trim());

                Accounts account = new Accounts(userID, password, balance);
                accounts.add(account);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    private void saveAccountsToCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_NAME))) {
            for (Accounts account : accountsList) {
                String line = account.getUserID() + "," + account.getPassword() + "," + account.getBalance();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String userID, String password) {
        for (Accounts account : accountsList) {
            if (account.getUserID().equals(userID) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void updateAccountsList(List<Accounts> updatedAccountsList) {
        this.accountsList = updatedAccountsList;
        saveAccountsToCSV();
    }

    public void addAccount(Accounts newAccount) {
        // Check if the new account is valid
        if (isValidAccount(newAccount)) {
            // Add the new account to the in-memory list
            accountsList.add(newAccount);
            // Save the updated list to CSV
            saveAccountsToCSV();
        } else {
            // Handle invalid account (throw an exception, log an error, etc.)
            System.err.println("Invalid account. Not adding to the list.");
        }
    }

    private boolean isValidAccount(Accounts account) {
        // Implement your validation logic here
        // For example, check if the user ID and password meet your criteria
        return isValidUserId(account.getUserID()) && isValidPassword(account.getPassword());
    }

    private boolean isValidUserId(String userID) {
        // Implement your user ID validation logic here
        return userID.length() >= 6 && userID.matches("[A-Z][a-zA-Z]*");
    }

    private boolean isValidPassword(String password) {
        // Implement your password validation logic here
        return password.length() >= 8 && password.matches("[a-zA-Z0-9@#$%!].{5,13}");
    }



}



