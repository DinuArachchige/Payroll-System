package lk.appforbank.dao;


import lk.appforbank.dao.custome.impl.AccountDAOImpl;
import lk.appforbank.dao.custome.impl.TaxDAOImpl;
import lk.appforbank.dao.custome.impl.TaxRateDAOImpl;
import lk.appforbank.dao.custome.impl.TrackUserDAOImpl;
import lk.appforbank.dao.custome.impl.TransactionDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public enum DAOTypes{
        ACCOUNT,TAX,TAX_RATE,TRACK_USER,TRANSACTION;
    }
    private DAOFactory(){

    }
    public static DAOFactory getInstence(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public <T>T getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ACCOUNT:
                return (T) new AccountDAOImpl();
            case TAX:
                return (T) new TaxDAOImpl();
            case TAX_RATE:
                return (T) new TaxRateDAOImpl();
            case TRACK_USER:
                return (T) new TrackUserDAOImpl();
            case TRANSACTION:
                return (T) new TransactionDAOImpl();
            default:
                return null;
        }
    }
}
