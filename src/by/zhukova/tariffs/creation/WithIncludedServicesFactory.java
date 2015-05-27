package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;

public class WithIncludedServicesFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithIncludedServices();
		AddDataToTariffs.addDataWithIncludedServices((TariffWithIncludedServices)tariff);
	
		return tariff;
	}

}
