package by.zhukova.tariffs.parser;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import by.zhukova.tariffs.tariff.TariffList;

public class SAXParser implements AbstractTariffParser  {
	
	private TariffList list;
	private TariffHandler th;
	private XMLReader reader;
	
	static Logger logger = Logger.getLogger(SAXParser.class);
	
	public SAXParser(){
		th = new TariffHandler();
		try {
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(th);
		} catch (SAXException e) {
			logger.error(e);
		}
		
	}

	public TariffList buildTariffList(String source) {
		try {
			reader.parse(source);
		} catch (IOException | SAXException e) {
			logger.error(e);
		}

		 list = th.getTariffs();

		return list;
	}

	


}