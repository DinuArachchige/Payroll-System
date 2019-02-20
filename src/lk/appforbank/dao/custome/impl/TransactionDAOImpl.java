package lk.appforbank.dao.custome.impl;

import java.sql.ResultSet;
import lk.appforbank.dao.CrudUtil;
import lk.appforbank.dao.custome.TransactionDAO;
import lk.appforbank.entity.Custom;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public boolean makeAccountTransaction(Custom c) throws Exception {
        String sql = "CALL transaction(?,?,?,CURRENT_TIMESTAMP(),?,?,?);";
        int i = CrudUtil.executeUpdate(sql, c.getTid(), c.getTransactionType(), c.getAmount(), c.getAccountNo(), c.getTrackID(), c.getUser());
        return i > 0;
    }

    @Override
    public boolean removeTransactionInGivenPeriod(Custom custom) throws Exception {
        String sql = "CALL removeTransaction(?,?);";
        int i = CrudUtil.executeUpdate(sql, custom.getFromDate(), custom.getToDate());
        return i > 0;
    }

    @Override
    public double getAccountBalance(int accountNo) throws Exception {
        String sql = "CALL viewBalance(?,@accountBalance);";
        ResultSet resultSet = CrudUtil.executeQuery(sql, accountNo);
        if (resultSet.next()) {
            return resultSet.getDouble(1);
        }
        return 0.0;
    }
}
