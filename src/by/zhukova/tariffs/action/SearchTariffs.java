package by.zhukova.tariffs.action;

import by.zhukova.tariffs.tariff.*;

public class SearchTariffs {

	public TariffList searchByInnerCallPrice(TariffList list, int minPrice,
			int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int innerCallPrice = list.getTariffByIndex(i).getInnerCallPrice();

			if ((innerCallPrice >= minPrice) && (innerCallPrice <= maxPrice)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchByOuterCallPrice(TariffList list, int minPrice,
			int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int outerCallPrice = list.getTariffByIndex(i).getOuterCallPrice();

			if ((outerCallPrice >= minPrice) && (outerCallPrice <= maxPrice)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchBySMSPrice(TariffList list, int minPrice,
			int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int smsPrice = list.getTariffByIndex(i).getSmsPrice();

			if ((smsPrice >= minPrice) && (smsPrice <= maxPrice)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchByBasicInternetPrice(TariffList list, int minPrice,
			int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int basicInternetPrice = list.getTariffByIndex(i)
					.getBasicInternetPrice();

			if ((basicInternetPrice >= minPrice)
					&& (basicInternetPrice <= maxPrice)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchBySubscriptionFee(TariffList list, int minFee,
			int maxFee) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int subscriptionFee = list.getTariffByIndex(i).getSubscriptionFee();

			if ((subscriptionFee >= minFee) && (subscriptionFee <= maxFee)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchByInternationalCallPrice(TariffList list,
			int minPrice, int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {
			int internationalCallPrice = list.getTariffByIndex(i)
					.getInternationalCallPrice();

			if ((internationalCallPrice >= minPrice)
					&& (internationalCallPrice <= maxPrice)) {
				searchResults.addNewTariff(list.getTariffByIndex(i));
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedInnerCalls(TariffList list, int minCalls,
			int maxCalls) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof TariffWithIncludedServices) {
				TariffWithIncludedServices tariff = (TariffWithIncludedServices) list
						.getTariffByIndex(i);
				int includedInnerCalls = tariff.getIncludedInnerCalls();

				if ((includedInnerCalls >= minCalls)
						&& (includedInnerCalls <= maxCalls)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedOuterCalls(TariffList list, int minCalls,
			int maxCalls) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof TariffWithIncludedServices) {
				TariffWithIncludedServices tariff = (TariffWithIncludedServices) list
						.getTariffByIndex(i);
				int includedOuterCalls = tariff.getIncludedOuterCalls();

				if ((includedOuterCalls >= minCalls)
						&& (includedOuterCalls <= maxCalls)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedSMS(TariffList list, int minSMS,
			int maxSMS) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof TariffWithIncludedServices) {
				TariffWithIncludedServices tariff = (TariffWithIncludedServices) list
						.getTariffByIndex(i);
				int includedSMS = tariff.getIncludedSMS();

				if ((includedSMS >= minSMS) && (includedSMS <= maxSMS)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedInternetTraffic(TariffList list,
			int minTraffic, int maxTraffic) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof TariffWithIncludedServices) {
				TariffWithIncludedServices tariff = (TariffWithIncludedServices) list
						.getTariffByIndex(i);
				int includedTraffic = tariff.getIncludedTraffic();

				if ((includedTraffic >= minTraffic)
						&& (includedTraffic <= maxTraffic)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedInternationalCalls(TariffList list,
			int minCalls, int maxCalls) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof InternationalTariff) {
				InternationalTariff tariff = (InternationalTariff) list
						.getTariffByIndex(i);
				int includedInternationalCalls = tariff
						.getIncludedInternationalCalls();

				if ((includedInternationalCalls >= minCalls)
						&& (includedInternationalCalls <= maxCalls)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByIncludedCorporateCalls(TariffList list,
			int minCalls, int maxCalls) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof CorporateTariff) {
				CorporateTariff tariff = (CorporateTariff) list
						.getTariffByIndex(i);
				int includedCorporateCalls = tariff.getIncludedCorporateCalls();

				if ((includedCorporateCalls >= minCalls)
						&& (includedCorporateCalls <= maxCalls)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

	public TariffList searchByCorporateCallPrice(TariffList list, int minPrice,
			int maxPrice) {

		TariffList searchResults = new TariffList();

		for (int i = 0; i < list.getListSize(); i++) {

			if (list.getTariffByIndex(i) instanceof CorporateTariff) {
				CorporateTariff tariff = (CorporateTariff) list
						.getTariffByIndex(i);
				int corporateCallPrice = tariff.getCorporateCallPrice();

				if ((corporateCallPrice >= minPrice)
						&& (corporateCallPrice <= maxPrice)) {
					searchResults.addNewTariff(list.getTariffByIndex(i));
				}
			}
		}
		return searchResults;
	}

}
