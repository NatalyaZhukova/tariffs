package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;

public class WithoutIncludedServicesFactory implements AbstractFactory {
	
	

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithoutIncludedServices();
		AddDataToTariffs.addDataWithoutIncludedServices(tariff);
		
		return tariff;
	}
	
	

}
