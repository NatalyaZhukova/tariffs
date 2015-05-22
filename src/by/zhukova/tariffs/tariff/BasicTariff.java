package by.zhukova.tariffs.tariff;

public  interface BasicTariff {
	
	public abstract String getTariffName();
	public abstract void setTariffName(String tariffName);
	
	public abstract int getSubscriptionFee();
	public abstract void setSubscriptionFee(int subscriptionFee);

	public abstract int getInnerCallPrice();
	public abstract void setInnerCallPrice(int innerCallPrice);
	
	public abstract int getOuterCallPrice();
	public abstract void setOuterCallPrice(int outerCallPrice);

	
	public abstract int getSmsPrice();
	public abstract void setSmsPrice(int smsPrice);
	
	public abstract int getBasicInternetPrice();
	public abstract void setBasicInternetPrice(int basicInternetPrice); 

	public abstract int getNumberOfUsers();
	public abstract void setNumberOfUsers(int numberOfUsers);

	public abstract int getInternationalCallPrice();
	public abstract void setInternationalCallPrice(int internationalCallPrice);
	
	public abstract String toString();
	public abstract int hashCode();
	public abstract boolean equals(Object obj);
	
}
	

