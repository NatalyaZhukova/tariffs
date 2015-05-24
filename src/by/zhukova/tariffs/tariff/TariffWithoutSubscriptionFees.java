package by.zhukova.tariffs.tariff;

import by.zhukova.tariffs.exception.LogicalException;

public class TariffWithoutSubscriptionFees implements BasicTariff {
	

		
		protected String tariffName;
		protected int subscriptionFee;
		
		protected int innerCallPrice;
		protected int outerCallPrice;
		protected int internationalCallPrice;
		
		protected int smsPrice;
		
		protected int basicInternetPrice;
		
		protected int numberOfUsers;
		
		public TariffWithoutSubscriptionFees() {
			this.subscriptionFee = 0;
		}
		
		public TariffWithoutSubscriptionFees(String tariffName, int innerCallPrice, int outerCallPrice, 
				int internationalCallPrice, int smsPrice, int basicInternetPrice, int numOfUsers) {
			
			this.subscriptionFee = 0;
			this.tariffName = tariffName;
			this.innerCallPrice = innerCallPrice;
			this.outerCallPrice = outerCallPrice;
			this.internationalCallPrice = internationalCallPrice;
			this.smsPrice = smsPrice;
			this.basicInternetPrice = basicInternetPrice;
			this.numberOfUsers = numOfUsers;
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
		public void setSubscriptionFee(int subscriptionFee) throws LogicalException {
			if (subscriptionFee<0) {
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
				this.subscriptionFee = subscriptionFee;
			}
		}

		public int getInnerCallPrice() {
			return innerCallPrice;
		}

		public void setInnerCallPrice(int innerCallPrice) throws LogicalException {
			if (innerCallPrice<0) {
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
				this.innerCallPrice = innerCallPrice;
			}
		}
		
		public int getOuterCallPrice() {
			return outerCallPrice;
		}

		public void setOuterCallPrice(int outerCallPrice) throws LogicalException {
			if (outerCallPrice<0) {
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
				this.outerCallPrice = outerCallPrice;
			}
		}

		
		public int getSmsPrice() {
			return smsPrice;
		}
		
		public void setSmsPrice(int smsPrice) throws LogicalException {
			if (smsPrice<0){
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
			this.smsPrice = smsPrice;
			}
		}

		
		public int getBasicInternetPrice() {
			return basicInternetPrice;
		}

		
		public void setBasicInternetPrice(int basicInternetPrice) throws LogicalException {
			if (basicInternetPrice<0){
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
			this.basicInternetPrice = basicInternetPrice;
			}
		
		}

		public int getNumberOfUsers() {
			return numberOfUsers;
		}

		public void setNumberOfUsers(int numberOfUsers) throws LogicalException {
			if (numberOfUsers<0){
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
			this.numberOfUsers = numberOfUsers;
			}
		}

		public int getInternationalCallPrice() {
			return internationalCallPrice;
		}

		public void setInternationalCallPrice(int internationalCallPrice) throws LogicalException {
			if (internationalCallPrice<0) {
				throw new LogicalException(LogicalException.CANNOT_BE_NEGATIVE);
			}
			else {
			this.internationalCallPrice = internationalCallPrice;
			}
		}
		
		public String toString() {
			
			return tariffName + ":" + '\n' +
					"Количество абонентов: " + numberOfUsers + '\n'
					+ "Стоимость минуты в своей сети: " + innerCallPrice + '\n' +
					"Стоимость минуты в другие сети: " + outerCallPrice + '\n' +
					"Стоимость минуты при звонке за границу: " + internationalCallPrice + '\n' +
					"Стоимость СМС: " + smsPrice + '\n' +
					"Стоимость 1 мб интернет-трафика: " + basicInternetPrice +'\n' +
					"Абонентская плата в месяц: " + subscriptionFee;
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
	
	
	


