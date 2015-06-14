package by.zhukova.tariffs.parser;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.zhukova.tariffs.exception.LogicalException;
import by.zhukova.tariffs.tariff.BasicTariff;
import by.zhukova.tariffs.tariff.CorporateTariff;
import by.zhukova.tariffs.tariff.InternationalTariff;
import by.zhukova.tariffs.tariff.TariffList;
import by.zhukova.tariffs.tariff.TariffWithInclServices;
import by.zhukova.tariffs.tariff.TariffWithoutIncServices;

public class TariffHandler extends DefaultHandler {
	private TariffList list;
	private BasicTariff tariff;
	private String currentName;

	static Logger logger = Logger.getLogger(TariffHandler.class);

	public TariffList getTariffs() {
		return list;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		switch (localName) {
		case "tariff-list":
			list = new TariffList();
			break;
		case TariffTypes.WITHOUT_SERVICES:
			tariff = new TariffWithoutIncServices();
			tariff.setTariffId(attributes.getValue(0));
			break;
		case TariffTypes.WITH_SERVICES:
			tariff = new TariffWithInclServices();
			tariff.setTariffId(attributes.getValue(0));
			break;
		case TariffTypes.INTERNATIONAL:
			tariff = new InternationalTariff();
			tariff.setTariffId(attributes.getValue(0));
			break;
		case TariffTypes.CORPORATE:
			tariff = new CorporateTariff();
			tariff.setTariffId(attributes.getValue(0));
			break;
		default:
			 currentName = localName;
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ((localName.equals(TariffTypes.WITHOUT_SERVICES))
				|| (localName.equals(TariffTypes.WITH_SERVICES))
				|| (localName.equals(TariffTypes.INTERNATIONAL))
				|| (localName.equals(TariffTypes.CORPORATE))) {
			list.addNewTariff(tariff);
		}
		else {
			currentName="";
		}

	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		String s = new String(ch, start, length).trim();
		if (currentName != null) {
			switch (currentName) {

			case TariffFields.NAME:
				tariff.setTariffName(s);
				break;
				
			case TariffFields.IN_CALL_PRICE:

				try {
					tariff.setInnerCallPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e1) {
					logger.error(e1);
				}
				break;

			case TariffFields.OUT_CALL_PRICE:

				try {
					tariff.setOuterCallPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e1) {
					logger.error(e1);
				}

				break;
			case TariffFields.SUBSCR_FEE:
				try {
					tariff.setSubscriptionFee(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e1) {
					logger.error(e1);
				}
				
				break;
				
			case TariffFields.USERS:
				try {
					tariff.setNumberOfUsers(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e1) {
					logger.error(e1);
				}
				break;
			case TariffFields.INT_CALL_PRICE:

				try {
					tariff.setInternationalCallPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e1) {
					logger.error(e1);
				}

				break; 
			case TariffFields.CORP_CALL_PRICE:
				CorporateTariff thisTariff = (CorporateTariff) tariff;
				try {
					thisTariff.setCorporateCallPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
                  
			case TariffFields.SMS_PRICE:
				try {
					tariff.setSmsPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
			case TariffFields.INTERNET_PRICE:
				try {
					tariff.setBasicInternetPrice(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}

				break;
			case TariffFields.HAS_NO_INC_SERVICES:
				TariffWithoutIncServices thisTariff2 = (TariffWithoutIncServices) tariff;
			thisTariff2.setHasNoIncludedServices(Boolean.parseBoolean(s));
			break;
			
			case TariffFields.INC_IN_CALLS:
				TariffWithInclServices thisTariff3 = (TariffWithInclServices) tariff;
				try {
					thisTariff3.setIncludedInnerCalls(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break; 
			case TariffFields.INC_OUT_CALLS:
				TariffWithInclServices thisTariff4 = (TariffWithInclServices) tariff;
				try {
					thisTariff4.setIncludedOuterCalls(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
			case TariffFields.INC_INT_CALLS:
				InternationalTariff thisTariff5 = (InternationalTariff) tariff;
				try {
					thisTariff5.setIncludedInternationalCalls(Integer
							.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
			case TariffFields.INC_SMS:
				TariffWithInclServices thisTariff6 = (TariffWithInclServices) tariff;
				try {
					thisTariff6.setIncludedSMS(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
			case TariffFields.INC_TRAFFIC:
				TariffWithInclServices thisTariff7 = (TariffWithInclServices) tariff;
				try {
					thisTariff7.setIncludedTraffic(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break;
			case TariffFields.INC_CORP_CALLS:
				CorporateTariff thisTariff8 = (CorporateTariff) tariff;
				try {
					thisTariff8.setIncludedCorporateCalls(Integer.parseInt(s));
				} catch (NumberFormatException | LogicalException e) {
					logger.error(e);
				}
				break; 

			}
		}

	}

}
