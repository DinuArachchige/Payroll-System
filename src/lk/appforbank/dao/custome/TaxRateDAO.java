package lk.appforbank.dao.custome;

import lk.appforbank.dao.CrudDAO;
import lk.appforbank.entity.TaxRate;


public interface TaxRateDAO extends CrudDAO<TaxRate,String> {
    public boolean saveNewTaxRate(TaxRate taxRate)throws Exception;
}
