package spring.cloud.stargate.service.account;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class Account implements Serializable {

    private String accountNumber;

    public Account() {
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
