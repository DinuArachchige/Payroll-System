package lk.appforbank.BO;

import lk.appforbank.BO.custome.impl.AccountBOImpl;
import lk.appforbank.BO.custome.impl.TaxRateBOImpl;
import lk.appforbank.BO.custome.impl.TransactionBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    public enum BOTypes {
        ACCOUNT, TAX_RATE, TRANSACTION;
    }

    private BOFactory() {

    }

    public static BOFactory getInstence() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case ACCOUNT:
                return (T) new AccountBOImpl();
            case TAX_RATE:
                return (T) new TaxRateBOImpl();
            case TRANSACTION:
                return (T) new TransactionBOImpl();
            default:
                return null;
        }
    }
}
