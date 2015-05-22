package by.zhukova.tariffs.test;
import java.util.Collections;

import by.zhukova.tariffs.TariffList;
import by.zhukova.tariffs.actions.CalculateParameters;
import by.zhukova.tariffs.actions.CreateTariffList;
import by.zhukova.tariffs.actions.SortTariffsBySubscriptionFee;

public class MainTest {

	public static void main(String[] args) {
		
		TariffList list = CreateTariffList.createTariffList();
		list.print();
		System.out.println("---------------------------");
		System.out.println("Общее количество пользователей: " + CalculateParameters.calculateUsers(list));
		System.out.println("---------------------------");
		Collections.sort(list.getTariffList(), new SortTariffsBySubscriptionFee());
		
		list.print();
		
	}

}
