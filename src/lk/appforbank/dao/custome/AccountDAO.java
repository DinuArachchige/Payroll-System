package lk.appforbank.dao.custome;


import lk.appforbank.dao.CrudDAO;
import lk.appforbank.entity.Account;

public interface AccountDAO extends CrudDAO<Account, String>{

    public boolean openNewAccount(Account account) throws Exception;
    
}
