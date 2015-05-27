package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;

public class InternationalTariffFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new InternationalTariff();
		AddDataToTariffs.addDataInternationalTariff((InternationalTariff)tariff);

		return tariff;
	}

}
