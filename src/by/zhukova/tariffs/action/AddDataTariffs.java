package by.zhukova.tariffs.action;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.tariffs.exception.LogicalException;
import by.zhukova.tariffs.tariff.*;



public class AddDataTariffs {
	
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(AddDataTariffs.class);
	
	public TariffWithoutSubscriptionFees addDataWithoutFees(TariffWithoutSubscriptionFees tariff){
		
		tariff.setTariffName("Тариф");
		try {
			tariff.setInnerCallPrice((int)(Math.random()*1000+100));
			tariff.setOuterCallPrice((int)(Math.random()*1000+100));
			tariff.setInternationalCallPrice((int)(Math.random()*10000+100));
			tariff.setSmsPrice((int)(Math.random()*1000+10));
			tariff.setBasicInternetPrice((int)(Math.random()*1000+1000));
			tariff.setNumberOfUsers((int)(Math.random()*10000+1000));
			
		} catch (LogicalException e) {
			logger.error(e);
		}
		
		return tariff;
	}
	
	public TariffWithSubscriptionFees addDataWithFees(TariffWithSubscriptionFees tariff) {
		addDataWithoutFees(tariff);
		
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

}
