package by.zhukova.tariffs.factory;

import by.zhukova.tariffs.tariff.BasicTariff;

public class Creator {

	private AbstractFactory abstractFactory;
	private BasicTariff basicTariff;
	
	public void action() {
		basicTariff = abstractFactory.createTariff();
	}
	public void setAbstractFactory(AbstractFactory factory) {
		abstractFactory = factory;
	}
}
