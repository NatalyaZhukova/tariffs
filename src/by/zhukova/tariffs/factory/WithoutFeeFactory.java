package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.action.AddDataTariffs;
import by.zhukova.tariffs.tariff.*;

public class WithoutFeeFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new TariffWithoutSubscriptionFees();
		AddDataTariffs add = new AddDataTariffs();
		add.addDataWithoutFees((TariffWithoutSubscriptionFees)tariff);
		return tariff;
	}

}
