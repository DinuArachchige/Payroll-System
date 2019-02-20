package lk.appforbank.dao.custome;

import lk.appforbank.dao.CrudDAO;
import lk.appforbank.entity.Custom;
import lk.appforbank.entity.Transaction;

public interface TransactionDAO extends CrudDAO<Transaction, String> {

    public boolean makeAccountTransaction(Custom custom) throws Exception;

    public boolean removeTransactionInGivenPeriod(Custom custom) throws Exception;

    public double getAccountBalance(int accountNo) throws Exception;
}
