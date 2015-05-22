package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.tariff.*;

public class WithoutFeeFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithoutSubscriptionFees();
		return tariff;
	}

}
