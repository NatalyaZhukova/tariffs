package by.zhukova.tariffs.tariff;

public class TariffWithoutSubscriptionFees extends BasicTariff {
	

		
		protected String tariffName;
		protected int subscriptionFee;
		
		protected int innerCallPrice;
		protected int outerCallPrice;
		protected int internationalCallPrice;
		
		protected int smsPrice;
		
		protected int basicInternetPrice;
		
		public TariffWithoutSubscriptionFees() {
			this.subscriptionFee = 0;
		}
		
		public TariffWithoutSubscriptionFees(String tariffName, int innerCallPrice, int outerCallPrice, 
				int internationalCallPrice, int smsPrice, int basicInternetPrice) {
			
			this.subscriptionFee = 0;
			this.tariffName = tariffName;
			this.innerCallPrice = innerCallPrice;
			this.outerCallPrice = outerCallPrice;
			this.internationalCallPrice = internationalCallPrice;
			this.smsPrice = smsPrice;
			this.basicInternetPrice = basicInternetPrice;
		
		}
		
		

		public String getTariffName() {
			return tariffName;
		}

		public void setTariffName(String tariffName) {
			this.tariffName = tariffName;
		}
		
		public int getSubscriptionFee() {
			return subscriptionFee;
		}
		public void setSubscriptionFee(int subscriptionFee) {
			this.subscriptionFee = subscriptionFee;
		}

		public int getInnerCallPrice() {
			return innerCallPrice;
		}

		public void setInnerCallPrice(int innerCallPrice) {
			this.innerCallPrice = innerCallPrice;
		}
		
		public int getOuterCallPrice() {
			return outerCallPrice;
		}

		public void setOuterCallPrice(int outerCallPrice) {
			this.outerCallPrice = outerCallPrice;
		}

		
		public int getSmsPrice() {
			return smsPrice;
		}
		
		public void setSmsPrice(int smsPrice) {
			this.smsPrice = smsPrice;
		}

		
		public int getBasicInternetPrice() {
			return basicInternetPrice;
		}

		
		public void setBasicInternetPrice(int basicInternetPrice) {
			this.basicInternetPrice = basicInternetPrice;
		}

		public int getInternationalCallPrice() {
			return internationalCallPrice;
		}

		public void setInternationalCallPrice(int internationalCallPrice) {
			this.internationalCallPrice = internationalCallPrice;
		}
		
		public String toString() {
			
			return tariffName + ":" + '\n' + "��������� ������ � ����� ����: " + innerCallPrice + '\n' +
					"��������� ������ � ������ ����: " + outerCallPrice + '\n' +
					"��������� ������ ��� ������ �� �������: " + internationalCallPrice + '\n' +
					"��������� ���: " + smsPrice + '\n' +
					"��������� 1 �� ��������-�������: " + basicInternetPrice +'\n' +
					"����������� ����� � �����: " + subscriptionFee;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + basicInternetPrice;
			result = prime * result + innerCallPrice;
			result = prime * result + internationalCallPrice;
			result = prime * result + outerCallPrice;
			result = prime * result + smsPrice;
			result = prime * result + subscriptionFee;
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
			if (!(obj instanceof TariffWithoutSubscriptionFees)) {
				return false;
			}
			TariffWithoutSubscriptionFees other = (TariffWithoutSubscriptionFees) obj;
			if (basicInternetPrice != other.basicInternetPrice) {
				return false;
			}
			if (innerCallPrice != other.innerCallPrice) {
				return false;
			}
			if (internationalCallPrice != other.internationalCallPrice) {
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
	
	
	

