package by.zhukova.tariffs.creation;

import by.zhukova.tariffs.tariff.*;

public class CreateTariffList {

	public static TariffList createTariffList() {
		TariffList list = new TariffList();

		for (int i = 0; i < 10; i++) {
			Creator creator = new Creator();
			int tariffType = (int) (Math.random() * 4 + 1);

			switch (tariffType) {

			case 1:
				creator.setAbstractFactory(new WithoutIncludedServicesFactory());
				creator.action();
				TariffWithoutIncServices tariff = (TariffWithoutIncServices) creator
						.getBasicTariff();
				list.addNewTariff(tariff);
				break;

			case 2:
				creator.setAbstractFactory(new WithIncludedServicesFactory());
				creator.action();
				TariffWithInclServices tariff1 = (TariffWithInclServices) creator
						.getBasicTariff();
				list.addNewTariff(tariff1);
				break;

			case 3:
				creator.setAbstractFactory(new CorporateTariffFactory());
				creator.action();
				CorporateTariff tariff2 = (CorporateTariff) creator
						.getBasicTariff();
				list.addNewTariff(tariff2);
				break;
			default:
				creator.setAbstractFactory(new InternationalTariffFactory());
				creator.action();
				InternationalTariff tariff3 = (InternationalTariff) creator
						.getBasicTariff();
				list.addNewTariff(tariff3);
				break;

			}

		}
		return list;
	}

}
