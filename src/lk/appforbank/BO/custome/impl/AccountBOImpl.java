package lk.appforbank.BO.custome.impl;



import lk.appforbank.BO.custome.AccountBO;
import lk.appforbank.DTO.AccountDTO;
import lk.appforbank.dao.DAOFactory;


import lk.appforbank.dao.custome.AccountDAO;
import lk.appforbank.entity.Account;

public class AccountBOImpl implements AccountBO {
    AccountDAO accountDAO;

    public AccountBOImpl(){
        accountDAO=(AccountDAO)DAOFactory.getInstence().getDAO(DAOFactory.DAOTypes.ACCOUNT);
    }

    @Override
    public boolean openNewAccount(AccountDTO accountDTO) throws Exception {
         
        Account acc = new Account(accountDTO.getAccountNo(),accountDTO.getOpening_date(),accountDTO.getAccount_type());
        return accountDAO.openNewAccount(acc);
    }
}
