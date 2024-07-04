package bank.project.olan.cli;

import bank.project.olan.data.Accounts;
import bank.project.olan.data.Data;

import java.util.Scanner;

public class BankInterface {


    public static void main(String args[]) {
        BankInterfaceSetup setup = new BankInterfaceSetup();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the OLA Bank Interface!");
        System.out.println("Would you like to login as");
        System.out.println("A)dmin");
        System.out.println("U)ser");
        System.out.println("Note, type A for 'Admin', U for 'User");
        String input = scanner.nextLine();
        if (input.equals("A")) {
            System.out.println("Welcome back, admin.......");
            System.out.println("Would you like to: ");
            System.out.println("V)iew Accounts");
            System.out.println("U)pdate Account details");
            System.out.println("R)eturn to login page");
            System.out.println("Note, type V for 'View Accounts', U for 'Update Account details', R for 'Return to login page'");

            String inputAdmin = scanner.nextLine();
            switch (inputAdmin) {
                case "V":
                    //TODO
                    break;
                case "U" :
                    //TODO
                    break;
                case "R" :

                    break;
                default:
                    System.out.println("Please provide a valid option");

            }




        } else if (input.equals("U")) {
            System.out.println("Welcome to OLA banking interface");
            System.out.println("Would you like to: ");
            System.out.println("M)ake Account");
            System.out.println("L)ogin");
            System.out.println("Note, type M for 'Make Account', L for 'Login'");
            String inputOne = scanner.nextLine();

            switch (inputOne) {
                case "M":
                    setup.createAccount();
                    break;
                case "L":
                    setup.login();

//                    System.out.println("Would you like to: ");
//                    System.out.println("V)iew Balance ");
//                    System.out.println("D)eposit Money ");
//                    System.out.println("W)ithdraw Money");
//                    System.out.println("T)ransfer Money");
//                    System.out.println("Note, type V for 'View Balance', D for 'Deposit Money', W for 'Withdraw Money, T for 'Transfer money'");
                    String transactionInput = scanner.nextLine();
                    switch (transactionInput) {
                        case "V":
                            //TODO
                            break;
                        case "D":
                            //TODO
                            break;
                        case "W":
                            //TODO
                            break;
                        case "T":
                            //TODO
                            break;
                        default:
                            System.out.println("Please provide a valid option");
            }
                    break;
                default:
                    System.out.println("Please provide a valid option");
            }

            //TODO

        }
    }
}
