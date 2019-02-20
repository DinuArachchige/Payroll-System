package lk.appforbank.entity;

public class Tax implements SuperEntity {
    private int taxid;
    private int tid;
    private double taxAmount;

    public Tax(int taxid, int tid, double taxAmount) {
        this.taxid = taxid;
        this.tid = tid;
        this.taxAmount = taxAmount;
    }

    public Tax() {
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public int getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxid=" + taxid +
                ", tid=" + tid +
                ", taxAmount=" + taxAmount +
                '}';
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }
}
