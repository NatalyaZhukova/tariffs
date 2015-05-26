package by.zhukova.tariffs.tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TariffList  {
	
	
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
	
	public BasicTariff getTariffByIndex(int index){
		BasicTariff tariff = tariffList.get(index);
		return tariff;
	}

	

}
