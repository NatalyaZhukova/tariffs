package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public class TariffWithInclServices extends BasicTariff {

	private int includedInnerCalls;
	private int includedOuterCalls;
	private int includedSMS;
	private int includedTraffic;

	public TariffWithInclServices() {

	}

	public TariffWithInclServices(String tariffName, String tariffId,
			int subscriptionFee, int innerCallPrice, int outerCallPrice,
			int internationalCallPrice, int smsPrice, int basicInternetPrice,
			int numberOfUsers, int includedInnerCalls, int includedOuterCalls,
			int includedSMS, int includedTraffic) {
		super(tariffName, tariffId, subscriptionFee, innerCallPrice,
				outerCallPrice, internationalCallPrice, smsPrice,
				basicInternetPrice, numberOfUsers);
		this.includedInnerCalls = includedInnerCalls;
		this.includedOuterCalls = includedOuterCalls;
		this.includedSMS = includedSMS;
		this.includedTraffic = includedTraffic;

	}

	public int getIncludedInnerCalls() {
		return includedInnerCalls;
	}

	public void setIncludedInnerCalls(int includedInnerCalls)
			throws LogicalException {
		if (includedInnerCalls >= 0) {
			this.includedInnerCalls = includedInnerCalls;

		} else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getIncludedOuterCalls() {
		return includedOuterCalls;
	}

	public void setIncludedOuterCalls(int includedOuterCalls)
			throws LogicalException {
		if (includedOuterCalls >= 0) {
			this.includedOuterCalls = includedOuterCalls;

		} else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public int getIncludedSMS() {
		return includedSMS;
	}

	public void setIncludedSMS(int includedSMS) throws LogicalException {
		if (includedSMS >= 0) {
			this.includedSMS = includedSMS;
		} else {
			throw new LogicalException("Value can't be negative");

		}
	}

	public int getIncludedTraffic() {
		return includedTraffic;
	}

	public void setIncludedTraffic(int includedTraffic) throws LogicalException {
		if (includedTraffic >= 0) {
			this.includedTraffic = includedTraffic;

		} else {
			throw new LogicalException("Value can't be negative");
		}
	}

	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append(super.toString()).append("Included inner calls: ")
				.append(includedInnerCalls).append('\n')
				.append("Included outer calls: ").append(includedOuterCalls)
				.append('\n').append("Included SMS: ").append(includedSMS)
				.append('\n').append("Included internet traffic: ")
				.append(includedTraffic).append('\n');

		return st.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + includedInnerCalls;
		result = prime * result + includedOuterCalls;
		result = prime * result + includedSMS;
		result = prime * result + includedTraffic;
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
		if (!(obj instanceof TariffWithInclServices)) {
			return false;
		}
		TariffWithInclServices other = (TariffWithInclServices) obj;
		if (includedInnerCalls != other.includedInnerCalls) {
			return false;
		}
		if (includedOuterCalls != other.includedOuterCalls) {
			return false;
		}
		if (includedSMS != other.includedSMS) {
			return false;
		}
		if (includedTraffic != other.includedTraffic) {
			return false;
		}
		return true;
	}
	
	
}
