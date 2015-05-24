package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public  interface BasicTariff {
	
	public abstract String getTariffName();
	public abstract void setTariffName(String tariffName);
	
	public abstract int getSubscriptionFee();
	public abstract void setSubscriptionFee(int subscriptionFee) throws LogicalException;

	public abstract int getInnerCallPrice();
	public abstract void setInnerCallPrice(int innerCallPrice) throws LogicalException;
	
	public abstract int getOuterCallPrice();
	public abstract void setOuterCallPrice(int outerCallPrice) throws LogicalException;

	
	public abstract int getSmsPrice();
	public abstract void setSmsPrice(int smsPrice) throws LogicalException;
	
	public abstract int getBasicInternetPrice();
	public abstract void setBasicInternetPrice(int basicInternetPrice) throws LogicalException; 

	public abstract int getNumberOfUsers();
	public abstract void setNumberOfUsers(int numberOfUsers) throws LogicalException;

	public abstract int getInternationalCallPrice();
	public abstract void setInternationalCallPrice(int internationalCallPrice) throws LogicalException;
	
	public abstract String toString();
	public abstract int hashCode();
	public abstract boolean equals(Object obj);
	
}
	

