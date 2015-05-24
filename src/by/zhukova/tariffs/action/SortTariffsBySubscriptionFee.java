package by.zhukova.tariffs.action;

import java.util.Comparator;
import by.zhukova.tariffs.tariff.BasicTariff;

public class SortTariffsBySubscriptionFee implements Comparator<BasicTariff> {
	
	public int compare(BasicTariff tariff1, BasicTariff tariff2) {
		if (tariff1.getSubscriptionFee()>tariff2.getSubscriptionFee()) {
			return 1;
		}
		else if (tariff1.getSubscriptionFee()<tariff2.getSubscriptionFee()){
			return -1;
		}
		else {
			return 0;
		}
	}




}
