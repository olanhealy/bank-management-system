package bank.project.olan.data

import spock.lang.Specification
import spock.mock.MockFactory

class DataSpec extends Specification {
        Data data


    def validUserId = "OlanHealy8"
    def validPassword = "TestPassw0rd_"
    def bal = 1000
    Accounts testAccount = new Accounts(validUserId,validPassword,bal)


    def "authenticateUser should return true for valid credentials"() {
        given:
        "test account is added to the accounts list"
        data
        testAccount
        data.getAccountsList().add(testAccount)


        when:
        "user is trying to autehticate themselves "
        def result = data.authenticateUser(validUserId, validPassword)

        then:
        "result should equal true as the account should be authenticated"
        result == true
    }


    def "authenticateUser should return false for invalid credentials"() {
        given:
        def data = new Data()
        def invalidUserID = "invalidUser"
        def invalidPassword = "invalidPassword"

        when:
        def result = data.authenticateUser(invalidUserID, invalidPassword)

        then:
        result == false
    }

    def "updateAccountsList should update the accounts list and save to CSV"() {
        given:
        def data = new Data()
        def updatedAccountsList = [new Accounts("TesterOne", "TestPass__", 3000)]

        when:
        data.updateAccountsList(updatedAccountsList)

        then:
        data.getAccountsList() == updatedAccountsList
    }


    def "addAccount should add a new account to the list and simulate saving to CSV"() {
        given:
        def initialSize = data.getAccountsList().size()
        def newAccount = new Accounts("NewTestUser", "NewPassword_", 500)

        when:
        data.addAccount(newAccount)

        then:
        1 * data.addAccount(newAccount)

        and:
        0 * data.saveAccountsToCSV() >> {
            // Do nothing, just mock the behavior
        }

        and:
        data.getAccountsList().size() == initialSize + 1
        data.getAccountsList().contains(newAccount)
    }

}

