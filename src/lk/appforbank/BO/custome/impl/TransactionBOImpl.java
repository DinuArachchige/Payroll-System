package lk.appforbank.BO.custome.impl;


import lk.appforbank.BO.custome.TransactionBO;
import lk.appforbank.DTO.RemoveTransactionDTO;
import lk.appforbank.DTO.TransactionDTO;
import lk.appforbank.dao.DAOFactory;
import lk.appforbank.dao.custome.TransactionDAO;
import lk.appforbank.entity.Custom;



public class TransactionBOImpl implements TransactionBO {

    TransactionDAO transactionDAO;

    public TransactionBOImpl() {
        transactionDAO=DAOFactory.getInstence().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    }

    @Override
    public boolean makeAccountTransaction(TransactionDTO tDTO) throws Exception {
        Custom custom=new Custom(tDTO.getTid(),tDTO.getAccountNo(),tDTO.getTransactionType(),tDTO.getAmount(),tDTO.getTrackID(),tDTO.getUser());
        return transactionDAO.makeAccountTransaction(custom);
    }

    @Override
    public boolean removeTransactionInGivenPeriod(RemoveTransactionDTO dto) throws Exception {
        Custom custom=new Custom(dto.getFromDate(),dto.getToDate());
        return transactionDAO.removeTransactionInGivenPeriod(custom);
    }

    @Override
    public double getAccountBalance(int accountNo) throws Exception {
        return transactionDAO.getAccountBalance(accountNo);
    }
}
