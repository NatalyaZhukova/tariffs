package by.zhukova.tariffs.tariff;

public class TariffWithoutIncludedServices extends BasicTariff {

	private boolean hasNoIncludedServices;

	public TariffWithoutIncludedServices() {
		super();
		this.hasNoIncludedServices = true;
	}

	public TariffWithoutIncludedServices(String tariffName, String tariffId,
			int subscriptionFee, int innerCallPrice, int outerCallPrice,
			int internationalCallPrice, int smsPrice, int basicInternetPrice,
			int numberOfUsers) {
		super(tariffName, tariffId, subscriptionFee, innerCallPrice,
				outerCallPrice, internationalCallPrice, smsPrice,
				basicInternetPrice, numberOfUsers);
		this.hasNoIncludedServices = true;

	}

	public boolean getHasNoIncludedServices() {
		return hasNoIncludedServices;
	}
	
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (hasNoIncludedServices ? 1231 : 1237);
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
		if (!(obj instanceof TariffWithoutIncludedServices)) {
			return false;
		}
		TariffWithoutIncludedServices other = (TariffWithoutIncludedServices) obj;
		if (hasNoIncludedServices != other.hasNoIncludedServices) {
			return false;
		}
		return true;
	}
	
	

}