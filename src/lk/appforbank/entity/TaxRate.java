package lk.appforbank.entity;

public class TaxRate implements SuperEntity {
    private int rate;
    private double sRate;
    private double eRate;

    public TaxRate( int rate, double sRate, double eRate) {
        this.rate = rate;
        this.sRate = sRate;
        this.eRate = eRate;
    }

    public TaxRate() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public double getsRate() {
        return sRate;
    }

    public void setsRate(double sRate) {
        this.sRate = sRate;
    }

    public double geteRate() {
        return eRate;
    }

    public void seteRate(double eRate) {
        this.eRate = eRate;
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                ", rate=" + rate +
                ", sRate=" + sRate +
                ", eRate=" + eRate +
                '}';
    }
}
