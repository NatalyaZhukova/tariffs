package by.zhukova.tariffs.actions;

import by.zhukova.tariffs.tariff.*;

public class AddDataTariffs {
	
	public TariffWithoutSubscriptionFees addDataWithoutFees(TariffWithoutSubscriptionFees tariff){
		
		tariff.setTariffName("Тариф");
		tariff.setInnerCallPrice((int)(Math.random()*1000+100));
		tariff.setOuterCallPrice((int)(Math.random()*1000+100));
		tariff.setInternationalCallPrice((int)(Math.random()*10000+100));
		tariff.setSmsPrice((int)(Math.random()*1000+10));
		tariff.setBasicInternetPrice((int)(Math.random()*1000+1000));
		
		return tariff;
	}
	
	public TariffWithSubscriptionFees addDataWithFees(TariffWithSubscriptionFees tariff) {
		addDataWithoutFees(tariff);
		
		tariff.setIncludedInnerCalls((int)(Math.random()*1000));
		tariff.setIncludedOuterCalls((int)(Math.random()*1000));
		tariff.setIncludedSMS((int)(Math.random()*1000));
		tariff.setIncludedTraffic((int)(Math.random()*1000));
		
		return tariff;
		
	}

}
