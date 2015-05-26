package by.zhukova.tariffs.factory;


import by.zhukova.tariffs.tariff.*;

public class WithoutIncludedServicesFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithoutIncludedServices();
		
		return tariff;
	}

}
