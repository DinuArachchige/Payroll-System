package lk.appforbank.entity;

import java.sql.Date;

public class Account implements SuperEntity {

    private int accountNo;
    private Date opening_date;
    private String account_type;

    public Account(int accountNo, Date opening_date, String account_type) {
        this.accountNo = accountNo;
        this.opening_date = opening_date;
        this.account_type = account_type;
    }

    public Account() {
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    @Override
    public String toString() {
        return "Account{"
                + "accountNo=" + accountNo
                + ", opening_date=" + opening_date
                + ", account_type='" + account_type + '\''
                + '}';
    }
}
