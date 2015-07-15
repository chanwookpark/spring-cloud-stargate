package spring.cloud.stargate.front.server.account;

import java.io.Serializable;

/**
 * @author chanwook
 */
public class Account implements Serializable {

    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
