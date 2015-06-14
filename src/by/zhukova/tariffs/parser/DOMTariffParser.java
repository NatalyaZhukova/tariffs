package by.zhukova.tariffs.parser;

import javax.xml.parsers.*;

import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import by.zhukova.tariffs.exception.LogicalException;
import by.zhukova.tariffs.tariff.BasicTariff;
import by.zhukova.tariffs.tariff.CorporateTariff;
import by.zhukova.tariffs.tariff.InternationalTariff;
import by.zhukova.tariffs.tariff.TariffList;
import by.zhukova.tariffs.tariff.TariffWithInclServices;
import by.zhukova.tariffs.tariff.TariffWithoutIncServices;

import java.io.*;

public class DOMTariffParser implements AbstractTariffParser {

	static Logger logger = Logger.getLogger(DOMTariffParser.class);

	private DocumentBuilderFactory factory = DocumentBuilderFactory
			.newInstance();
	private DocumentBuilder builder = null;
	private Document doc = null;
	private BasicTariff tariff = null;

	public TariffList buildTariffList(String source) {
		TariffList list = new TariffList();

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			logger.error(e1);
		}
		File f = new File(source);
		try {
			doc = builder.parse(f);
		} catch (SAXException | IOException e1) {
			logger.error(e1);
		}

		Element root = doc.getDocumentElement();

		NodeList nList = root.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			if (nList.item(i) instanceof Element) {

				NodeList childs = nList.item(i).getChildNodes();
				Element element = (Element) childs;
				String elementType = element.getNodeName();
				switch (elementType) {
				case TariffTypes.WITHOUT_SERVICES:
					tariff = new TariffWithoutIncServices();
					try {
						buildWithoutServices(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case TariffTypes.WITH_SERVICES:
					tariff = new TariffWithInclServices();
					try {
						buildWithServices(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case TariffTypes.INTERNATIONAL:
					tariff = new InternationalTariff();
					try {
						buildInternTariff(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case TariffTypes.CORPORATE:
					tariff = new CorporateTariff();
					try {
						buildCorpTariff(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;

				default:
					logger.error("Unknown type of tariff");
				}

			}

		}
		return list;
	}

	private String getElementTextContent(Element el, String elementName) {
		NodeList nList = el.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

	private void buildBasicPart(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {

		if (element != null) {
			tariff.setTariffId(element.getAttribute("id"));
			tariff.setTariffName(getElementTextContent(element,
					TariffFields.NAME));
			tariff.setSubscriptionFee(Integer.parseInt(getElementTextContent(
					element, TariffFields.SUBSCR_FEE)));
			tariff.setInnerCallPrice(Integer.parseInt(getElementTextContent(
					element, TariffFields.IN_CALL_PRICE)));
			tariff.setOuterCallPrice(Integer.parseInt(getElementTextContent(
					element, TariffFields.OUT_CALL_PRICE)));
			tariff.setSmsPrice(Integer.parseInt(getElementTextContent(element,
					TariffFields.SMS_PRICE)));
			tariff.setBasicInternetPrice(Integer
					.parseInt(getElementTextContent(element,
							TariffFields.INTERNET_PRICE)));
			tariff.setInternationalCallPrice(Integer
					.parseInt(getElementTextContent(element,
							TariffFields.INT_CALL_PRICE)));
			tariff.setNumberOfUsers(Integer.parseInt(getElementTextContent(
					element, TariffFields.USERS)));
		} else {
			throw new LogicalException("element can't be null");
		}
	}

	private void buildWithoutServices(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildBasicPart(element, tariff);
		TariffWithoutIncServices thisTariff = (TariffWithoutIncServices) tariff;
		thisTariff.setHasNoIncludedServices(Boolean
				.parseBoolean(getElementTextContent(element,
						TariffFields.HAS_NO_INC_SERVICES)));
	}

	private void buildWithServices(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildBasicPart(element, tariff);
		TariffWithInclServices thisTariff = (TariffWithInclServices) tariff;
		thisTariff.setIncludedInnerCalls(Integer
				.parseInt(getElementTextContent(element,
						TariffFields.INC_IN_CALLS)));
		thisTariff.setIncludedOuterCalls(Integer
				.parseInt(getElementTextContent(element,
						TariffFields.INC_OUT_CALLS)));
		thisTariff.setIncludedSMS(Integer.parseInt(getElementTextContent(
				element, TariffFields.INC_SMS)));
		thisTariff.setIncludedTraffic(Integer.parseInt(getElementTextContent(
				element, TariffFields.INC_TRAFFIC)));
	}

	private void buildCorpTariff(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildWithServices(element, tariff);
		CorporateTariff thisTariff = (CorporateTariff) tariff;
		thisTariff.setCorporateCallPrice(Integer
				.parseInt(getElementTextContent(element,
						TariffFields.CORP_CALL_PRICE)));
		thisTariff.setIncludedCorporateCalls(Integer
				.parseInt(getElementTextContent(element,
						TariffFields.INC_CORP_CALLS)));

	}

	private void buildInternTariff(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildWithServices(element, tariff);
		InternationalTariff thisTariff = (InternationalTariff) tariff;
		thisTariff.setIncludedInternationalCalls(Integer
				.parseInt(getElementTextContent(element,
						TariffFields.INC_INT_CALLS)));

	}
}
