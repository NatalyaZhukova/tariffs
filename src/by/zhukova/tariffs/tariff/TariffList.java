package by.zhukova.tariffs.tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.zhukova.tariffs.actions.SortTariffsBySubscriptionFee;

public class TariffList {
	
	
	private List<BasicTariff> tariffList;
	
	public TariffList(){
		tariffList =  new ArrayList<BasicTariff>();
	}
	
	public void addNewTariff(BasicTariff tariff) {
		tariffList.add(tariff);
	}
	public int getListSize() {
		return tariffList.size();
	}
	
	public void print(){
		
		for (int i=0; i<tariffList.size(); i++) {
			System.out.println(tariffList.get(i).toString());
		}
	}
	
	public void sortBySubscriptionFee(){
		Collections.sort(tariffList, new SortTariffsBySubscriptionFee());
		
	}
	
	public BasicTariff getTariffByIndex(int index){
		BasicTariff tariff = tariffList.get(index);
		return tariff;
	}
	

}
