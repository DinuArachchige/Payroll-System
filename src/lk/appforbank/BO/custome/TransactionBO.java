package lk.appforbank.BO.custome;

import lk.appforbank.BO.SuperBO;
import lk.appforbank.DTO.RemoveTransactionDTO;
import lk.appforbank.DTO.TransactionDTO;



public interface TransactionBO extends SuperBO {
    
    public boolean makeAccountTransaction(TransactionDTO tDTO)throws Exception;
    public boolean removeTransactionInGivenPeriod(RemoveTransactionDTO dto)throws Exception;
    public double getAccountBalance(int accountNo)throws Exception;
}
