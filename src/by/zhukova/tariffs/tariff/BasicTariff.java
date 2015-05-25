package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public abstract class BasicTariff {
	
	protected String tariffName;
	protected String tariffId;
	protected int subscriptionFee;
	
	protected int innerCallPrice;
	protected int outerCallPrice;
	protected int internationalCallPrice;
	
	protected int smsPrice;
	protected int basicInternetPrice;
	protected int numberOfUsers;
	
	public BasicTariff() {
		
	}
	
	public BasicTariff(String tariffName, String tariffId, int subscriptionFee,
			int innerCallPrice, int outerCallPrice, int internationalCallPrice,
			int smsPrice, int basicInternetPrice, int numberOfUsers) {
		
		this.tariffName = tariffName;
		this.tariffId = tariffId;
		this.subscriptionFee = subscriptionFee;
		this.innerCallPrice = innerCallPrice;
		this.outerCallPrice = outerCallPrice;
		this.internationalCallPrice = internationalCallPrice;
		this.smsPrice = smsPrice;
		this.basicInternetPrice = basicInternetPrice;
		this.numberOfUsers = numberOfUsers;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getTariffId() {
		return tariffId;
	}

	public void setTariffId(String tariffId) {
		this.tariffId = tariffId;
	}

	public int getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setMonthlyFee(int subscriptionFee) throws LogicalException {
		if (subscriptionFee>=0){
		this.subscriptionFee = subscriptionFee;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getInnerCallPrice() {
		return innerCallPrice;
	}

	public void setInnerCallPrice(int innerCallPrice) throws LogicalException {
		if (innerCallPrice>=0) {
		this.innerCallPrice = innerCallPrice;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getOuterCallPrice() {
		return outerCallPrice;
	}

	public void setOuterCallPrice(int outerCallPrice) throws LogicalException {
		if (outerCallPrice>=0){
		this.outerCallPrice = outerCallPrice;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getInternationalCallPrice() {
		return internationalCallPrice;
	}

	public void setInternationalCallPrice(int internationalCallPrice) throws LogicalException {
		if (internationalCallPrice>=0){
		this.internationalCallPrice = internationalCallPrice;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getSmsPrice() {
		return smsPrice;
	}

	public void setSmsPrice(int smsPrice) throws LogicalException {
		if (smsPrice>=0){
		this.smsPrice = smsPrice;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getBasicInternetPrice() {
		return basicInternetPrice;
	}

	public void setBasicInternetPrice(int basicInternetPrice) throws LogicalException {
		if (basicInternetPrice>=0) {
		this.basicInternetPrice = basicInternetPrice;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) throws LogicalException {
		if (numberOfUsers>=0){
		this.numberOfUsers = numberOfUsers;
		}
		else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public String toString() {
		
		StringBuilder st = new StringBuilder();
		st.append("ID of tariff: ");
		st.append(tariffId);
		st.append('\n');
		st.append("Name of tariff: ");
		st.append(tariffName);
		st.append('\n');
		st.append("Subscription fee: ");
		st.append(subscriptionFee);
		st.append('\n');
		st.append("Price of inner calls (in minute): ");
		st.append(innerCallPrice);
		st.append('\n');
		st.append("Price of outer calls (in minute): ");
		st.append(outerCallPrice);
		st.append('\n');
		st.append("Price of international calls (in minute): ");
		st.append(internationalCallPrice);
		st.append('\n');
		st.append("Price of SMS: ");
		st.append(smsPrice);
		st.append('\n');
		st.append("Price of internet traffic (1 mb): ");
		st.append(basicInternetPrice);
		st.append('\n');
		st.append("Number of tariff's users: ");
		st.append(numberOfUsers);
		st.append('\n');
		
		return st.toString();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basicInternetPrice;
		result = prime * result + innerCallPrice;
		result = prime * result + internationalCallPrice;
		result = prime * result + numberOfUsers;
		result = prime * result + outerCallPrice;
		result = prime * result + smsPrice;
		result = prime * result + subscriptionFee;
		result = prime * result
				+ ((tariffId == null) ? 0 : tariffId.hashCode());
		result = prime * result
				+ ((tariffName == null) ? 0 : tariffName.hashCode());
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
		if (!(obj instanceof BasicTariff)) {
			return false;
		}
		BasicTariff other = (BasicTariff) obj;
		if (basicInternetPrice != other.basicInternetPrice) {
			return false;
		}
		if (innerCallPrice != other.innerCallPrice) {
			return false;
		}
		if (internationalCallPrice != other.internationalCallPrice) {
			return false;
		}
		if (numberOfUsers != other.numberOfUsers) {
			return false;
		}
		if (outerCallPrice != other.outerCallPrice) {
			return false;
		}
		if (smsPrice != other.smsPrice) {
			return false;
		}
		if (subscriptionFee != other.subscriptionFee) {
			return false;
		}
		if (tariffId == null) {
			if (other.tariffId != null) {
				return false;
			}
		} else if (!tariffId.equals(other.tariffId)) {
			return false;
		}
		if (tariffName == null) {
			if (other.tariffName != null) {
				return false;
			}
		} else if (!tariffName.equals(other.tariffName)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	

	
}
	

