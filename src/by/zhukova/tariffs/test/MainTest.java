package by.zhukova.tariffs.test;
import by.zhukova.tariffs.TariffList;
import by.zhukova.tariffs.actions.CalculateParameters;
import by.zhukova.tariffs.actions.CreateTariffList;

public class MainTest {

	public static void main(String[] args) {
		
		TariffList list = CreateTariffList.createTariffList();
		list.print();
		
		System.out.println("Общее количество пользователей: " + CalculateParameters.calculateUsers(list));
		
		
	}

}
