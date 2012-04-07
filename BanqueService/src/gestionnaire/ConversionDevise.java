package gestionnaire;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import net.restfulwebservices.www.DataContracts._2008._01.Currency;
import net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode;
import net.restfulwebservices.www.ServiceContracts._2008._01.CurrencyServiceLocator;
import net.restfulwebservices.www.ServiceContracts._2008._01.ICurrencyService;

import FaultContracts.GOTLServices._2008._01.DefaultFaultContract;

public class ConversionDevise {
	
	public ConversionDevise(){}
	
	public double convertir (String source, String cible, double montant){
		try {
			ICurrencyService service = new CurrencyServiceLocator().getBasicHttpBinding_ICurrencyService();
			Currency currency = service.getConversionRate(CurrencyCode.fromString(source.toUpperCase()), CurrencyCode.fromString(cible.toUpperCase()));
			Double rate = currency.getRate();
			
			return rate*montant;
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (DefaultFaultContract e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
