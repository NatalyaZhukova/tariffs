package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.actions.AddDataTariffs;
import by.zhukova.tariffs.tariff.*;

public class WithFeeFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithSubscriptionFees();
		AddDataTariffs add = new AddDataTariffs();
		add.addDataWithFees((TariffWithSubscriptionFees)tariff);
		return tariff;
	}

}
