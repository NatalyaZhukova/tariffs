package by.zhukova.tariffs.test;
import by.zhukova.tariffs.tariff.*;

public class MainTest {

	public static void main(String[] args) {
		
		TariffWithoutSubscriptionFees first = new TariffWithoutSubscriptionFees("Тариф 1", 153, 32, 532, 512, 324);
		TariffWithSubscriptionFees second = new TariffWithSubscriptionFees("Тариф 2", 15000, 323, 52, 622, 642, 624, 1000, 0, 0, 1000);
		
		System.out.println(first.toString());
		System.out.println(second.toString());

	}

}
