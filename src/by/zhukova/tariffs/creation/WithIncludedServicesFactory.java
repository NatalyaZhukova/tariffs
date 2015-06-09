package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;

public class WithIncludedServicesFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithInclServices();
		AddDataToTariffs.addDataWithIncludedServices((TariffWithInclServices)tariff);
	
		return tariff;
	}

}
