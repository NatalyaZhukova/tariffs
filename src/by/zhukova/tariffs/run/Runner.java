package by.zhukova.tariffs.run;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.tariffs.action.*;
import by.zhukova.tariffs.tariff.TariffList;


public class Runner {
	
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(Runner.class);

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
