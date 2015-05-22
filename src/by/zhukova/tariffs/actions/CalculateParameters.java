package by.zhukova.tariffs.actions;

import by.zhukova.tariffs.TariffList;

public class CalculateParameters {
	
	public static int  calculateUsers(TariffList list) {
		
		int sumOfUsers=0;
		
		for (int i=0; i<list.getListSize(); i++){
			
			sumOfUsers+=list.getTariffList().get(i).getNumberOfUsers();
		}
		
		
		return sumOfUsers;
		
	}

}