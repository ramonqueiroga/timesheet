package br.com.timesheet.infra.conversores.vraptor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@Convert(LocalDateTime.class)
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

	@Override
	public LocalDateTime convert(String value, Class<? extends LocalDateTime> type) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return LocalDateTime.parse(value, formatter);
		} catch (DateTimeParseException ex) {
			throw new ConversionException(new ConversionMessage("is_not_a_valid_integer", value));
		}
	}

}
