package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;


public class CorporateTariffFactory implements AbstractFactory {

	@Override
	public BasicTariff createTariff() {
		BasicTariff tariff = new CorporateTariff();
		AddDataToTariffs.addDataCorporateTariff((CorporateTariff)tariff);

		return tariff;
	}

}
