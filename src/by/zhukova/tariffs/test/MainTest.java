package by.zhukova.tariffs.test;

import by.zhukova.tariffs.action.*;
import by.zhukova.tariffs.tariff.TariffList;


public class MainTest {

	public static void main(String[] args) {
		
		TariffList list = CreateTariffList.createTariffList();
		System.out.println("Общее количество пользователей: " + CalculateParameters.calculateUsers(list));
		System.out.println("---------------------------");
		list.sortBy(new SortTariffsBySubscriptionFee());
		list.print();
		System.out.println("---------------------------");
		SearchTariffs search = new SearchTariffs();
		TariffList search1 = search.searchByInnerCallPrice(list, 200, 500);
		search1.print();
		
		
	}

}
