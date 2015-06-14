package by.zhukova.tariffs.parser;

import by.zhukova.tariffs.tariff.TariffList;

public interface AbstractTariffParser {
	
	TariffList buildTariffList(String source);

}
