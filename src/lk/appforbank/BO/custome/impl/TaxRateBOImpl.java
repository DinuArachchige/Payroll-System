package lk.appforbank.BO.custome.impl;

import lk.appforbank.BO.custome.TaxRateBO;
import lk.appforbank.DTO.TaxRateDTO;
import lk.appforbank.dao.DAOFactory;
import lk.appforbank.dao.custome.TaxRateDAO;
import lk.appforbank.entity.TaxRate;




public class TaxRateBOImpl implements TaxRateBO {

    TaxRateDAO taxRateDAO;

    public TaxRateBOImpl() {
        taxRateDAO = DAOFactory.getInstence().getDAO(DAOFactory.DAOTypes.TAX_RATE);
    }

    @Override
    public boolean saveNewTaxRate(TaxRateDTO taxRateDTO) throws Exception {
        TaxRate taxRate = new TaxRate(taxRateDTO.getRate(), taxRateDTO.getsRate(), taxRateDTO.geteRate());
        return taxRateDAO.saveNewTaxRate(taxRate);
    }
}
