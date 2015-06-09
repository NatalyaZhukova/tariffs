package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public class CorporateTariff extends TariffWithInclServices {

	private int corporateCallPrice;
	private int includedCorporateCalls;
	
	public CorporateTariff() {
		
	}
	

	public CorporateTariff(String tariffName, String tariffId,
			int subscriptionFee, int innerCallPrice, int outerCallPrice,
			int internationalCallPrice, int smsPrice, int basicInternetPrice,
			int numberOfUsers, int includedInnerCalls, int includedOuterCalls,
			int includedSMS, int includedTraffic, 
			int corporateCallPrice, int includedCorporateCalls) {
		super(tariffName, tariffId, subscriptionFee, innerCallPrice, outerCallPrice,
				internationalCallPrice, smsPrice, basicInternetPrice, numberOfUsers,
				includedInnerCalls, includedOuterCalls, includedSMS, includedTraffic);
		this.corporateCallPrice = corporateCallPrice;
		this.includedCorporateCalls = includedCorporateCalls;
	}


	public int getCorporateCallPrice() {
		return corporateCallPrice;
	}

	public void setCorporateCallPrice(int corporateCallPrice)
			throws LogicalException {
		if (corporateCallPrice >= 0) {
			this.corporateCallPrice = corporateCallPrice;
		} else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getIncludedCorporateCalls() {
		return includedCorporateCalls;
	}

	public void setIncludedCorporateCalls(int includedCorporateCalls)
			throws LogicalException {
		if (includedCorporateCalls >= 0) {
			this.includedCorporateCalls = includedCorporateCalls;
		} else {
			throw new LogicalException("Value can't be negative");
		}

	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append(super.toString()).append("Corporate calls price: ")
				.append(corporateCallPrice).append('\n')
				.append("Included corporate calls: ")
				.append(includedCorporateCalls).append('\n');

		return st.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + corporateCallPrice;
		result = prime * result + includedCorporateCalls;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CorporateTariff)) {
			return false;
		}
		CorporateTariff other = (CorporateTariff) obj;
		if (corporateCallPrice != other.corporateCallPrice) {
			return false;
		}
		if (includedCorporateCalls != other.includedCorporateCalls) {
			return false;
		}
		return true;
	}

}