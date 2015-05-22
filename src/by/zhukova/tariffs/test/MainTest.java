package by.zhukova.tariffs.test;
import by.zhukova.tariffs.TariffList;
import by.zhukova.tariffs.actions.CreateTariffList;

public class MainTest {

	public static void main(String[] args) {
		
		TariffList list = CreateTariffList.createTariffList();
		
		for (int i=0; i<list.getListSize(); i++) {
			System.out.println(list.getTariffList().get(i).toString());
		}
		
		
	}

}
