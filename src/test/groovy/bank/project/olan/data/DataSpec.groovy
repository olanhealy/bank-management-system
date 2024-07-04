package bank.project.olan.data

import spock.lang.Specification

class DataSpec extends Specification {
    Data data
    def validUserId = "OlanHealy8"
    def validPassword = "TestPassw0rd_"
    def bal = 1000
    Accounts testAccount = new Accounts(validUserId, validPassword, bal)

    void setup() {
        // Initialize the data object before each test
        data = new Data()
    }

    def "authenticateUser should return true for valid credentials"() {
        given: "test account is added to the accounts list"
        data.getAccountsList().add(testAccount)

        when: "user is trying to authenticate themselves"
        def result = data.authenticateUser(validUserId, validPassword)

        then: "result should equal true as the account should be authenticated"
        result == true
    }

    def "authenticateUser should return false for invalid credentials"() {
        given: "invalid user ID and password"
        def invalidUserID = "invalidUser"
        def invalidPassword = "invalidPassword"

        when: "user is trying to authenticate themselves"
        def result = data.authenticateUser(invalidUserID, invalidPassword)

        then: "result should equal false as the account should not be authenticated"
        result == false
    }

    def "updateAccountsList should update the accounts list and save to CSV"() {
        given: "an updated accounts list"
        def updatedAccountsList = [new Accounts("TesterOne", "TestPass__", 3000)]

        when: "the accounts list is updated"
        data.updateAccountsList(updatedAccountsList)

        then: "the accounts list should be updated"
        data.getAccountsList() == updatedAccountsList
    }

    def "addAccount should add a new account to the list and simulate saving to CSV"() {
        given: "an initial accounts list size"
        def initialSize = data.getAccountsList().size()
        def newAccount = new Accounts("NewTestUser", "NewPassword_", 500)

        when: "a new account is added"
        data.addAccount(newAccount)

        then: "the accounts list size should increase by one"
        data.getAccountsList().size() == initialSize + 1

        and: "the new account should be in the accounts list"
        data.getAccountsList().contains(newAccount)
    }
}
