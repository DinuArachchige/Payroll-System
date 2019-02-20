package lk.appforbank.DTO;

public class TransactionDTO {
    private int tid;
    private int accountNo;
    private String transactionType;
    private double amount;
    private int trackID;
    private String user ;

    public TransactionDTO(int tid, int accountNo, String transactionType, double amount, int trackID, String user) {
        this.tid = tid;
        this.accountNo = accountNo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.trackID = trackID;
        this.user = user;
    }

    public TransactionDTO() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTrackID() {
        return trackID;
    }

    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "tid=" + tid +
                ", accountNo=" + accountNo +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", trackID=" + trackID +
                ", user='" + user + '\'' +
                '}';
    }
}
