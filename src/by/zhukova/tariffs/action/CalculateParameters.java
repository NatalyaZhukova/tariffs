package by.zhukova.tariffs.action;

import by.zhukova.tariffs.tariff.TariffList;

public class CalculateParameters {
	
	public static int  calculateUsers(TariffList list) {
		
		int sumOfUsers=0;
		
		for (int i=0; i<list.getListSize(); i++){
			sumOfUsers+=list.getTariffByIndex(i).getNumberOfUsers();
		}
	
		return sumOfUsers;
		
	}

}
