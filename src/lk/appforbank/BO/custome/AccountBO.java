package lk.appforbank.BO.custome;

import lk.appforbank.BO.SuperBO;
import lk.appforbank.DTO.AccountDTO;






public interface AccountBO extends SuperBO{
    public boolean openNewAccount(AccountDTO accountDTO)throws Exception;
}
