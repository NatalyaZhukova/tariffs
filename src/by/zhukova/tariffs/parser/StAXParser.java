package by.zhukova.tariffs.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import by.zhukova.tariffs.exception.LogicalException;
import by.zhukova.tariffs.tariff.BasicTariff;
import by.zhukova.tariffs.tariff.CorporateTariff;
import by.zhukova.tariffs.tariff.InternationalTariff;
import by.zhukova.tariffs.tariff.TariffList;
import by.zhukova.tariffs.tariff.TariffWithInclServices;
import by.zhukova.tariffs.tariff.TariffWithoutIncServices;

public class StAXParser implements AbstractTariffParser {

	private XMLInputFactory factory;
	private XMLStreamReader reader;
	private TariffList list;
	private BasicTariff tariff;
	
	static Logger logger = Logger.getLogger(DOMTariffParser.class);

	public StAXParser() {
		factory = XMLInputFactory.newFactory();
	}

	public TariffList buildTariffList(String source) {
		list = new TariffList();

		try {
			reader = factory.createXMLStreamReader(new FileInputStream(source));

			while (reader.hasNext()) {
				int res = reader.next();
				if (res == reader.START_ELEMENT) {
					String name = reader.getLocalName();
					switch (name) {
					case TariffTypes.WITHOUT_SERVICES:
						tariff = new TariffWithoutIncServices();
						tariff = buildWithoutServices(reader, tariff);
						list.addNewTariff(tariff);
						break;
					case TariffTypes.WITH_SERVICES:
						tariff = new TariffWithInclServices();
						buildWithServices(reader, tariff);
						list.addNewTariff(tariff);
						break;
					case TariffTypes.INTERNATIONAL:
						tariff = new InternationalTariff();
						buildInternational(reader, tariff);
						list.addNewTariff(tariff);
						break;
					case TariffTypes.CORPORATE:
						tariff = new CorporateTariff();
						buildCorporate(reader, tariff);
						list.addNewTariff(tariff);
						break;
					

					}

				}
			}
		} catch (FileNotFoundException | XMLStreamException
				| NumberFormatException | LogicalException e) {
			logger.error(e);
		}

		return list;
	}

	private void buildBasicPart(XMLStreamReader reader, BasicTariff tariff)
			throws XMLStreamException, NumberFormatException, LogicalException {
		tariff.setTariffId(reader.getAttributeValue(0));

		while (reader.hasNext()) {
			int res;
			res = reader.next();
			if (res == reader.START_ELEMENT) {

				String field = reader.getLocalName();
				
				if (field.equals(TariffFields.NAME)) {
					tariff.setTariffName(reader.getElementText());
				}

				else if (field.equals(TariffFields.IN_CALL_PRICE)) {
					tariff.setInnerCallPrice(Integer.parseInt(reader
							.getElementText()));

				} else if (field.equals(TariffFields.OUT_CALL_PRICE)) {
					tariff.setOuterCallPrice(Integer.parseInt(reader
							.getElementText()));
				} else if (field.equals(TariffFields.INT_CALL_PRICE)) {
					tariff.setInternationalCallPrice(Integer.parseInt(reader
							.getElementText()));

				} else if (field.equals(TariffFields.SMS_PRICE)) {
					tariff.setSmsPrice(Integer.parseInt(reader.getElementText()));
					
				} else if (field.equals(TariffFields.INTERNET_PRICE)) {
					tariff.setBasicInternetPrice(Integer.parseInt(reader
							.getElementText()));
				} else if (field.equals(TariffFields.USERS)) {
					tariff.setNumberOfUsers(Integer.parseInt(reader
							.getElementText()));
				} else if (field.equals(TariffFields.SUBSCR_FEE)) {
					tariff.setSubscriptionFee(Integer.parseInt(reader
							.getElementText()));
					break;
				} 

			} 
			
		}
		
		

	}

	private TariffWithoutIncServices buildWithoutServices(XMLStreamReader reader, BasicTariff tariff) throws NumberFormatException, XMLStreamException, LogicalException {
		buildBasicPart(reader, tariff);
		TariffWithoutIncServices thisTariff = (TariffWithoutIncServices) tariff;
		while (reader.hasNext()) {
			int res;
			res = reader.next();
			if (res == reader.START_ELEMENT) {
				String field = reader.getLocalName();
				if (field.equals(TariffFields.HAS_NO_INC_SERVICES)) {
					thisTariff.setHasNoIncludedServices(Boolean.parseBoolean(reader.getElementText()));
				break;
				}
			}
			}
		return thisTariff;
		
	}
	
	private void buildWithServices(XMLStreamReader reader, BasicTariff tariff) throws NumberFormatException, XMLStreamException, LogicalException {
		buildBasicPart(reader, tariff);
		TariffWithInclServices thisTariff = (TariffWithInclServices) tariff;
		while (reader.hasNext()) {
			int res;
			res = reader.next();
			if (res == reader.START_ELEMENT) {
				String field = reader.getLocalName();
				if (field.equals(TariffFields.INC_IN_CALLS)) {
					thisTariff.setIncludedInnerCalls(Integer.parseInt(reader.getElementText()));
					
				} else if (field.equals(TariffFields.INC_OUT_CALLS)) {
					thisTariff.setIncludedOuterCalls(Integer.parseInt(reader.getElementText()));
					
				} else if (field.equals(TariffFields.INC_SMS)) {
					thisTariff.setIncludedSMS(Integer.parseInt(reader.getElementText()));
					
				} else if (field.equals(TariffFields.INC_TRAFFIC)) {
					thisTariff.setIncludedTraffic(Integer.parseInt(reader.getElementText()));
				break;	
				}
			}
			}
	}
	
	private void buildInternational(XMLStreamReader reader, BasicTariff tariff) throws NumberFormatException, XMLStreamException, LogicalException {
		buildWithServices(reader, tariff);
		InternationalTariff thisTariff = (InternationalTariff) tariff;
		while (reader.hasNext()) {
			int res = reader.next();
			if (res == reader.START_ELEMENT) {
				String field = reader.getLocalName();
				if (field.equals(TariffFields.INC_INT_CALLS)) {
					thisTariff.setIncludedInternationalCalls(Integer.parseInt(reader.getElementText()));
					break;
				}
			}
		}
	}
	
	private void buildCorporate(XMLStreamReader reader, BasicTariff tariff) throws NumberFormatException, XMLStreamException, LogicalException {
		buildWithServices(reader, tariff);
		CorporateTariff thisTariff = (CorporateTariff) tariff;
		while (reader.hasNext()) {
			int res = reader.next();
			if (res == reader.START_ELEMENT) {
				String field = reader.getLocalName();
				if (field.equals(TariffFields.CORP_CALL_PRICE)) {
					thisTariff.setCorporateCallPrice(Integer.parseInt(reader.getElementText()));
					
				} else if (field.equals(TariffFields.INC_CORP_CALLS)) {
					thisTariff.setIncludedCorporateCalls(Integer.parseInt(reader.getElementText()));
					break;
				}
			}
		}
	}

}
