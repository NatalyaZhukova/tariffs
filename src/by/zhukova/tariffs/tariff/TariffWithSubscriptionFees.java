package by.zhukova.tariffs.tariff;

public class TariffWithSubscriptionFees extends TariffWithoutSubscriptionFees {
	
	private int includedInnerCalls;
	private int includedOuterCalls;
	private int includedSMS;
	private int includedTraffic;
	
	public TariffWithSubscriptionFees() {
		
	}
	
	public TariffWithSubscriptionFees(String tariffName, int subscriptionFee, int innerCallPrice, int outerCallPrice, 
			int internationalCallPrice, int smsPrice, int basicInternetPrice, int includedInnerCalls, int includedOuterCalls,
			int includedSMS, int includedTraffic) {
		
		super(tariffName,  innerCallPrice,  outerCallPrice,  internationalCallPrice,  smsPrice,  basicInternetPrice);
		
		this.subscriptionFee = subscriptionFee;
		this.includedInnerCalls=includedInnerCalls;
		this.includedOuterCalls=includedOuterCalls;
		this.includedSMS = includedSMS;
		this.includedTraffic = includedTraffic;
	}
	
	public int getIncludedInnerCalls() {
		return includedInnerCalls;
	}
	public void setIncludedInnerCalls(int includedInnerCalls) {
		this.includedInnerCalls = includedInnerCalls;
	}
	public int getIncludedOuterCalls() {
		return includedOuterCalls;
	}
	public void setIncludedOuterCalls(int includedOuterCalls) {
		this.includedOuterCalls = includedOuterCalls;
	}
	public int getIncludedSMS() {
		return includedSMS;
	}
	public void setIncludedSMS(int includedSMS) {
		this.includedSMS = includedSMS;
	}
	public int getIncludedTraffic() {
		return includedTraffic;
	}
	public void setIncludedTraffic(int includedTraffic) {
		this.includedTraffic = includedTraffic;
	}

	public String toString() {
		
		return super.toString()+ '\n' +
		"���������� ������: " + '\n' +
		"������ ������ ����: " + includedInnerCalls + '\n' +
		"������ � ������ ����: " + includedOuterCalls + '\n' +
		"��� �� ��� ����: " + includedSMS + '\n' +
		"���������� ��������-������: " + includedTraffic;
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
		if (!(obj instanceof TariffWithSubscriptionFees)) {
			return false;
		}
		TariffWithSubscriptionFees other = (TariffWithSubscriptionFees) obj;
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
	