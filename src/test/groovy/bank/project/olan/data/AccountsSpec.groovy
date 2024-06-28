package bank.project.olan.data

import spock.lang.Specification

class AccountsSpec extends Specification {

    def "an account with a non-valid userID should throw an 'Invalid userID"() {
        given:
        def notValidUserId = "olan"
        def validPassword = "TestPassw0rd_"
        def balance = 100

        when:
        // Creating an account with an invalid userID should throw an exception
        def badAccount = new Accounts(notValidUserId,validPassword,balance)

        then:


        def message = "Invalid user"
    }

    def "an account with a non-valid password should throw an exception"() {
        given:
        def validUserId = "ValidTestUser"
        def notValidPassword = "testpassword"
        def balance = 100

        when:
        // Creating an account with an invalid password should throw an exception
        def badAccountException

        then:


        badAccountException.message == "Invalid password"
    }
}
