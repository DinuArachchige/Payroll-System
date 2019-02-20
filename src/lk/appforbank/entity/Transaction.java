package lk.appforbank.entity;

import java.util.Date;

public class Transaction implements SuperEntity{
    private int tid;
    private String tType;
    private double amount;
    private Date tdate;
    private int accountNo;

    public Transaction(int tid, String tType, double amount, Date tdate, int accountNo) {
        this.tid = tid;
        this.tType = tType;
        this.amount = amount;
        this.tdate = tdate;
        this.accountNo = accountNo;
    }

    public Transaction() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid=" + tid +
                ", tType='" + tType + '\'' +
                ", amount=" + amount +
                ", tdate=" + tdate +
                ", accountNo=" + accountNo +
                '}';
    }
}
