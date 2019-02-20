package lk.appforbank.DTO;

public class TaxRateDTO {
    private int rate;
    private double sRate;
    private double eRate;

    public TaxRateDTO(int rate, double sRate, double eRate) {
        this.rate = rate;
        this.sRate = sRate;
        this.eRate = eRate;
    }

    public TaxRateDTO() {
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
        return "TaxRateDTO{" +
                "rate=" + rate +
                ", sRate=" + sRate +
                ", eRate=" + eRate +
                '}';
    }
}

