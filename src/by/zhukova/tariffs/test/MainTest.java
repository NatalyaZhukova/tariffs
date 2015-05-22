package by.zhukova.tariffs.test;

import by.zhukova.tariffs.actions.CalculateParameters;
import by.zhukova.tariffs.actions.CreateTariffList;
import by.zhukova.tariffs.tariff.TariffList;


public class MainTest {

	public static void main(String[] args) {
		
		TariffList list = CreateTariffList.createTariffList();
		list.print();
		System.out.println("---------------------------");
		System.out.println("����� ���������� �������������: " + CalculateParameters.calculateUsers(list));
		System.out.println("---------------------------");
		list.sortBySubscriptionFee();
		
		list.print();
		
	}

}
