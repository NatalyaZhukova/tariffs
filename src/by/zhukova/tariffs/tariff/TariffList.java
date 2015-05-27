package by.zhukova.tariffs.tariff;

import java.util.ArrayList;
import java.util.List;

public class TariffList {

	private List<BasicTariff> tariffList;

	public TariffList() {
		tariffList = new ArrayList<BasicTariff>();
	}

	public void addNewTariff(BasicTariff tariff) {
		tariffList.add(tariff);
	}

	public int getListSize() {
		return tariffList.size();
	}

	public BasicTariff getTariffByIndex(int index) {
		BasicTariff tariff = tariffList.get(index);
		return tariff;
	}

	public List<BasicTariff> getListOfTariffs() { // for sort only
		return tariffList;
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		for (int i = 0; i < tariffList.size(); i++) {
			st.append(tariffList.get(i).toString());
			st.append("                              ").append('\n');
		}
		return st.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tariffList == null) ? 0 : tariffList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TariffList)) {
			return false;
		}
		TariffList other = (TariffList) obj;
		if (tariffList == null) {
			if (other.tariffList != null) {
				return false;
			}
		} else if (!tariffList.equals(other.tariffList)) {
			return false;
		}
		return true;
	}

}
