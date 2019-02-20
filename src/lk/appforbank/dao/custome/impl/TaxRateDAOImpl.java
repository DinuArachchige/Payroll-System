package lk.appforbank.dao.custome.impl;



import lk.appforbank.dao.CrudUtil;
import lk.appforbank.dao.custome.TaxRateDAO;
import lk.appforbank.entity.TaxRate;

public class TaxRateDAOImpl implements TaxRateDAO {

    @Override
    public boolean saveNewTaxRate(TaxRate taxRate) throws Exception {
        String sql = "CALL addNewTaxRate(?,?,?)";
        int i = CrudUtil.executeUpdate(sql, taxRate.getRate(), taxRate.getsRate(), taxRate.geteRate());
        return i > 0;
    }
}
