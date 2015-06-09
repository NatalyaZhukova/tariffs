package by.zhukova.tariffs.run;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.zhukova.tariffs.action.*;
import by.zhukova.tariffs.parser.DOMTariffParser;
import by.zhukova.tariffs.tariff.TariffList;


public class Runner {
	
	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		
		DOMTariffParser parser = new DOMTariffParser();
		TariffList list = parser.buildTariffList("mobileTariffs.xml");
		System.out.println(list.toString());
		
		System.out.println("общее количество пользователей: " + TariffsActions.calculateUsers(list));
			System.out.println(list.toString());
			System.out.println("---------------------------");
			TariffList sortedList = TariffsActions.sortTariffsBy(list, new SubscriptionFeeComparator());
			System.out.println(sortedList.toString());
			System.out.println("---------------------------");
			SearchTariffs search = new SearchTariffs();
			TariffList search1 = search.searchByInnerCallPrice(list, 200, 500);
			System.out.println(search1.toString());
		
		
		
		
	}

}
