package bank.project.olan.data

import bank.project.olan.data.Accounts
import bank.project.olan.data.Transactions
import spock.lang.Specification

/*
 We used Groovy testing in work. Had to add in a dependency for it was fairly easy. Gonna try log stuff from now on in ReadMe
*/

class TransactionsSpec extends Specification {
    /*
    Just defining a tester bank account which will be used for them
    */
    def balance = 1000
    def name = "tester"
    def password = "Coyi_12_45"
    def testAccount = new Accounts(name,password,balance)


    def nameTransfer = "transfer"
    def passwordTransfer = "HelloWorld2023_"
    def transferAccount = new Accounts(nameTransfer, passwordTransfer, balance)

    def "viewBal should display the correct balance"() {
        given:
        testAccount

        when:
        "account filled out correctly"

        then:
        Transactions.viewBal(testAccount) == "Your bank balance is: €1000"
    }

    def "deposit should increase the balance correctly"() {
        given:
        testAccount

        when:
        "account filled out correctly"
        Transactions.deposit(testAccount, "500")

        then:
        testAccount.getBalance() == balance + 500
    }

    def "deposit should not accept negative amounts"() {
        given:
        testAccount

        when:
        "trying to deposit a negative amount"
        Transactions.deposit(testAccount, "-200")

        then:
        testAccount.getBalance() == balance
    }

    def "deposit should not accept non-integer amounts"() {
        given:
        testAccount

        when:
        "trying to deposit a non-integer amount"
        Transactions.deposit(testAccount, "abc")

        then:
        testAccount.getBalance() == balance
    }

    def "withdraw should decrease the balance correctly"() {
        given:
        testAccount

        when:
        "account filled out correctly"
        Transactions.withdraw(testAccount, "500")

        then:
        testAccount.getBalance() == balance - 500

    }

    def "withdraw should not accept negative amounts" () {
        given:
        testAccount

        when:
        "trying to withdraw a negative amount"
        Transactions.withdraw(testAccount, "-200")

        then:
        testAccount.getBalance() == balance
    }

    def "withdraw should not accept non-integer amounts"() {
        given:
        testAccount

        when:
        "trying to withdraw a non-integer amount"
        Transactions.withdraw(testAccount, "***")

        then:
        testAccount.getBalance() == balance
    }

    def "withdraw should not accept a larger withdrawal then what is in the account "() {
        given:
        testAccount

        when:
        "a larger sum of money than the account holds is attempted to be withdrew"
        Transactions.withdraw(testAccount, "2000")

        then:
        testAccount.getBalance() == balance
    }

    def "transfer should increase the recipient's balance && sender account should if a valid transfer is made" () {
        given:
        testAccount
        transferAccount

        when:
        "test account makes a valid transfer to transfer account"
        Transactions.transfer(testAccount, transferAccount, "200")

        then:
        testAccount.getBalance() == balance - 200
        transferAccount.getBalance() == balance + 200
    }

    def "transfer should not accept negative amounts" () {
        given:
        testAccount
        transferAccount

        when:
        "a negative value is attempted to be transferred"
        Transactions.transfer(testAccount, transferAccount,"-200")

        then:
        testAccount.getBalance() == balance
        transferAccount.getBalance() == balance

    }

    def "transfer should not accept non-integer values" () {
        given:
        testAccount
        transferAccount

        when:
        "a non-integer value is attempted to be transferred"
        Transactions.transfer(testAccount, transferAccount, "xyz")

        then:
        testAccount.getBalance() == balance
        transferAccount.getBalance() == balance
    }

    def "transfer should not accept a larger transfer then what is in the account" () {
        given:
        testAccount
        transferAccount

        when:
        "a larger sum of money than the account holds is attempted to be transferred"
        Transactions.transfer(testAccount, transferAccount, "2000")

        then:
        testAccount.getBalance() == balance
        transferAccount.getBalance() == balance
    }





}