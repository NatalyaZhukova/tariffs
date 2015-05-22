package by.zhukova.tariffs;

import java.util.ArrayList;
import java.util.List;

import by.zhukova.tariffs.tariff.BasicTariff;

public class TariffList {
	
	
	private List<BasicTariff> tariffList;
	
	public TariffList(){
		tariffList =  new ArrayList<BasicTariff>();
	}

	public List<BasicTariff> getTariffList() {
		return tariffList;
	}

	public void setTariffList(List<BasicTariff> tariffList) {
		this.tariffList = tariffList;
	}
	
	public void addNewTariff(BasicTariff tariff) {
		tariffList.add(tariff);
	}
	public int getListSize() {
		return tariffList.size();
	}
	

}
