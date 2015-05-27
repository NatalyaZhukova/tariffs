package by.zhukova.tariffs.creation;

import org.apache.log4j.Logger;

import by.zhukova.tariffs.exception.LogicalException;
import by.zhukova.tariffs.tariff.*;

public class AddDataToTariffs {
	
	static Logger logger = Logger.getLogger(AddDataToTariffs.class);
	
	//методы-заглушки для заполнения объектов данными
	
	public static BasicTariff addDataWithoutIncludedServices(BasicTariff tariff){
		
		tariff.setTariffName("Tariff without subscription fee");
		tariff.setTariffId(new Integer((int)(Math.random()*1000+100)).toString());
		try {
			tariff.setInnerCallPrice((int)(Math.random()*1000+100));
			tariff.setOuterCallPrice((int)(Math.random()*1000+100));
			tariff.setInternationalCallPrice((int)(Math.random()*10000+100));
			tariff.setSmsPrice((int)(Math.random()*1000+10));
			tariff.setBasicInternetPrice((int)(Math.random()*1000+1000));
			tariff.setNumberOfUsers((int)(Math.random()*10000+1000));
			tariff.setSubscriptionFee(0);
			
		} catch (LogicalException e) {
			logger.error(e);
		}
		
		return tariff;
	}
	
	public static TariffWithIncludedServices addDataWithIncludedServices(TariffWithIncludedServices tariff) {
		addDataWithoutIncludedServices(tariff);
		tariff.setTariffName("Tariff with subscription fee");
		try {
			tariff.setSubscriptionFee((int)(Math.random()*100000+10000));
			tariff.setIncludedInnerCalls((int)(Math.random()*1000));
			tariff.setIncludedOuterCalls((int)(Math.random()*1000));
			tariff.setIncludedSMS((int)(Math.random()*1000));
			tariff.setIncludedTraffic((int)(Math.random()*1000));
			
		} catch (LogicalException e) {
			logger.error(e);
		}
		return tariff;
	}
	
	public static CorporateTariff addDataCorporateTariff(CorporateTariff tariff) {
		addDataWithoutIncludedServices(tariff);
		addDataWithIncludedServices(tariff);
		tariff.setTariffName("Corporative Tariff");
		
		try {
			tariff.setCorporateCallPrice((int)(Math.random()*1000+1000));
			tariff.setIncludedCorporateCalls((int)(Math.random()*1000));
		} catch (LogicalException e) {
			logger.error(e);
		}
		
		return tariff;
	}
	
	public static InternationalTariff addDataInternationalTariff(InternationalTariff tariff) {
		addDataWithoutIncludedServices(tariff);
		addDataWithIncludedServices(tariff);
		tariff.setTariffName("International Tariff");
		
		try {
			tariff.setIncludedInternationalCalls((int)(Math.random()*1000));
		} catch (LogicalException e) {
			logger.error(e);
		}
		
		return tariff;
	}

}
