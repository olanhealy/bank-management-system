package bank.project.olan.data;

import java.util.Random;

public class Accounts {

    private String userId;
    private String password;
    private int bal;

    private final String iban;

    /*
    This class is setters and getters for the accounts which will be used in the Bank Management System.
    Need User Id and password for logins.
    Need Balance to keep track of an accounts balance.

    */

    public Accounts(String userId, String password, int bal ) {
        this.userId = userId;
        this.password = password;
        this.bal = bal;
        this.iban = generateIban();
    }

    public String getUserID() {
        return userId;
    }

    public void setUserID(String userId) {
        if (isValidUserId(userId)) {
            this.userId = userId;
        } else {
            // Handle invalid userID (throw an exception, log an error, etc.)
            throw new IllegalArgumentException("Invalid userID");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return bal;
    }

    public void setBalance(int bal) {
        this.bal = bal;
    }

    public String getIban() {
        return iban;
    }

    private String generateIban() {
        // Generate a random 10-digit number
        Random random = new Random();
        int randomNumber = random.nextInt(1000000000);

        // Format the number as a 10-digit string
        String randomDigits = String.format("%010d", randomNumber);

        // Combine "OLA" with the random digits to form the IBAN
        return "OLA" + randomDigits;
    }

    private boolean isValidUserId(String userID) {

        return userID.length() >= 6 && userID.matches("[A-Z][a-zA-Z]*");

    }

    private boolean isValidPassword(String password) {

        return userId.length() >= 8 && userId.matches("[a-zA-Z0-9@#$%!].{5,13}");
    }

    @Override
    public String toString() {
        return userId + "," + password  + "," + bal + "," + iban;
    }
}

