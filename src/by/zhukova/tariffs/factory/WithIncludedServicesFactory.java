package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.action.AddDataTariffs;
import by.zhukova.tariffs.tariff.*;

public class WithIncludedServicesFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithIncludedServices();
	
		return tariff;
	}

}
