package lk.appforbank.BO.custome;


import lk.appforbank.BO.SuperBO;
import lk.appforbank.DTO.TaxRateDTO;

public interface TaxRateBO extends SuperBO {
    public boolean saveNewTaxRate(TaxRateDTO taxRateDTO)throws Exception;
}
