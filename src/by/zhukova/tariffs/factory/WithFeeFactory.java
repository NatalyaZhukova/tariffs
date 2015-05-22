package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.tariff.*;

public class WithFeeFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithSubscriptionFees();
		return tariff;
	}

}
