package by.zhukova.tariffs.action;

import java.util.Collections;
import java.util.Comparator;

import by.zhukova.tariffs.tariff.*;

public class TariffsActions {

	public static int calculateUsers(TariffList list) {

		int sumOfUsers = 0;

		for (int i = 0; i < list.getListSize(); i++) {
			sumOfUsers += list.getTariffByIndex(i).getNumberOfUsers();
		}
		return sumOfUsers;

	}

	public static TariffList sortTariffsBy(TariffList tariffList,
			Comparator<BasicTariff> compare) {
		Collections.sort(tariffList.getListOfTariffs(), compare);
		return tariffList;

	}

}
