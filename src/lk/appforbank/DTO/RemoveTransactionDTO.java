package lk.appforbank.DTO;

import java.sql.Date;

public class RemoveTransactionDTO {
    private Date fromDate;
    private Date toDate;

    public RemoveTransactionDTO(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public RemoveTransactionDTO() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    @Override
    public String toString() {
        return "RemoveTransactionDTO{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
