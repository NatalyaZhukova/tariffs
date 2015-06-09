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

public class DOMTariffParser {

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
				case "without-fee-tariff":
					tariff = new TariffWithoutIncServices();
					try {
						buildWithoutServices(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case "with-fee-tariff":
					tariff = new TariffWithInclServices();
					try {
						buildWithServices(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case "international-tariff":
					tariff = new InternationalTariff();
					try {
						buildInternTariff(element, tariff);
						list.addNewTariff(tariff);
					} catch (NumberFormatException | LogicalException e) {
						logger.error(e);
					}

					break;
				case "corporate-tariff":
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
					break;
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

		if (element.getAttribute("id") != null) {
			tariff.setTariffId(element.getAttribute("id"));
		} else {
			throw new LogicalException("ID can't be null");
		}

		tariff.setTariffName(getElementTextContent(element, "name"));
		tariff.setSubscriptionFee(Integer.parseInt(getElementTextContent(
				element, "subscr-fee")));
		tariff.setInnerCallPrice(Integer.parseInt(getElementTextContent(
				element, "in-call-price")));
		tariff.setOuterCallPrice(Integer.parseInt(getElementTextContent(
				element, "out-call-price")));
		tariff.setSmsPrice(Integer.parseInt(getElementTextContent(element,
				"sms-price")));
		tariff.setBasicInternetPrice(Integer.parseInt(getElementTextContent(
				element, "internet-price")));
		tariff.setInternationalCallPrice(Integer
				.parseInt(getElementTextContent(element, "int-call-price")));
		tariff.setNumberOfUsers(Integer.parseInt(getElementTextContent(element,
				"num-of-users")));
	}

	private void buildWithoutServices(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildBasicPart(element, tariff);
		TariffWithoutIncServices thisTariff = (TariffWithoutIncServices) tariff;
		thisTariff.setHasNoIncludedServices(Boolean
				.parseBoolean(getElementTextContent(element,
						"has-no-inc-services")));
	}

	private void buildWithServices(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildBasicPart(element, tariff);
		TariffWithInclServices thisTariff = (TariffWithInclServices) tariff;
		thisTariff.setIncludedInnerCalls(Integer
				.parseInt(getElementTextContent(element, "inc-in-calls")));
		thisTariff.setIncludedOuterCalls(Integer
				.parseInt(getElementTextContent(element, "inc-out-calls")));
		thisTariff.setIncludedSMS(Integer.parseInt(getElementTextContent(
				element, "inc-sms")));
		thisTariff.setIncludedTraffic(Integer.parseInt(getElementTextContent(
				element, "inc-traffic")));
	}

	private void buildCorpTariff(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildWithServices(element, tariff);
		CorporateTariff thisTariff = (CorporateTariff) tariff;
		thisTariff.setCorporateCallPrice(Integer
				.parseInt(getElementTextContent(element, "corp-call-price")));
		thisTariff.setIncludedCorporateCalls(Integer
				.parseInt(getElementTextContent(element, "inc-corp-calls")));

	}

	private void buildInternTariff(Element element, BasicTariff tariff)
			throws NumberFormatException, LogicalException {
		buildWithServices(element, tariff);
		InternationalTariff thisTariff = (InternationalTariff) tariff;
		thisTariff.setIncludedInternationalCalls(Integer
				.parseInt(getElementTextContent(element, "inc-int-calls")));

	}
}
