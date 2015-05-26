package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public class InternationalTariff extends TariffWithIncludedServices {

	private int includedInternationalCalls;

	public InternationalTariff() {

	}

	public InternationalTariff(String tariffName, String tariffId,
			int subscriptionFee, int innerCallPrice, int outerCallPrice,
			int internationalCallPrice, int smsPrice, int basicInternetPrice,
			int numberOfUsers, int includedInnerCalls, int includedOuterCalls,
			int includedSMS, int includedTraffic, int includedInternationalCalls) {
		super(tariffName, tariffId, subscriptionFee, innerCallPrice,
				outerCallPrice, internationalCallPrice, smsPrice,
				basicInternetPrice, numberOfUsers, includedInnerCalls,
				includedOuterCalls, includedSMS, includedTraffic);
		this.includedInternationalCalls = includedInternationalCalls;
	}

	public int getIncludedInternationalCalls() {
		return includedInternationalCalls;
	}

	public void setIncludedInternationalCalls(int includedInternationalCalls)
			throws LogicalException {
		if (includedInternationalCalls >= 0) {
			this.includedInternationalCalls = includedInternationalCalls;
		} else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append(super.toString()).append("Included international calls: ")
				.append(includedInternationalCalls).append('\n');

		return st.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + includedInternationalCalls;
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
		if (!(obj instanceof InternationalTariff)) {
			return false;
		}
		InternationalTariff other = (InternationalTariff) obj;
		if (includedInternationalCalls != other.includedInternationalCalls) {
			return false;
		}
		return true;
	}
	
	
}