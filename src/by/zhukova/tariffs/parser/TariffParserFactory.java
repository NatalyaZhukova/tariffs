package by.zhukova.tariffs.parser;

public class TariffParserFactory {

	private enum TypeParser {
		SAX, STAX, DOM
	}
	
	public AbstractTariffParser createTariffParser(String typeParser) {
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		switch (type){
		case DOM:
			return new DOMTariffParser();
		
		case SAX:
			return new SAXParser();
			
		case STAX:
			return new StAXParser();
		default:
			throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
		}
		
	}
}
