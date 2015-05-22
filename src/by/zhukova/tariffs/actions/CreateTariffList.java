package by.zhukova.tariffs.actions;

import by.zhukova.tariffs.TariffList;
import by.zhukova.tariffs.factory.*;
import by.zhukova.tariffs.tariff.*;

public  class CreateTariffList {
	
	public static TariffList createTariffList() {
		TariffList list = new TariffList();
		
		for(int i=0; i<10; i++) {
			Creator creator = new Creator();
			AddDataTariffs addData = new AddDataTariffs();
			
			if (i%3==0) {
				creator.setAbstractFactory(new WithoutFeeFactory());
				creator.action();
				TariffWithoutSubscriptionFees tariff = (TariffWithoutSubscriptionFees)creator.getBasicTariff();
				addData.addDataWithoutFees(tariff);
				list.addNewTariff(tariff);
				
			}
			else {
				creator.setAbstractFactory(new WithFeeFactory());
				creator.action();
				TariffWithSubscriptionFees tariff = (TariffWithSubscriptionFees)creator.getBasicTariff();
				addData.addDataWithFees(tariff);
				list.addNewTariff(tariff);
			}
			
			
		}
		return list;
		
	}
	

}
