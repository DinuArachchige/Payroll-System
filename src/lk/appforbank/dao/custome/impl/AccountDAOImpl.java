package lk.appforbank.dao.custome.impl;


import lk.appforbank.dao.CrudUtil;
import lk.appforbank.dao.custome.AccountDAO;
import lk.appforbank.entity.Account;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public boolean openNewAccount(Account account) throws Exception {
        String sql = "CALL createAccount(?,?,?)";
        int i = CrudUtil.executeUpdate(sql, account.getAccountNo(), account.getOpening_date(), account.getAccount_type());
        return i > 0;

    }
}
