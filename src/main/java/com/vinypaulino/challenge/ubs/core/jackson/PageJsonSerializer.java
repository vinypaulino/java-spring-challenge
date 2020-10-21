package com.vinypaulino.challenge.ubs.core.jackson;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class PageJsonSerializer extends JsonSerializer<Page<?>> {

	@Override
	public void serialize(Page<?> page, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		gen.writeStartObject();
		gen.writeNumberField("current_page", page.getNumber());
		gen.writeNumberField("per_page", page.getSize());
		gen.writeNumberField("total_entries", page.getTotalElements());
		gen.writeNumberField("total_pages", page.getTotalPages());
		gen.writeObjectField("entries", page.getContent());
		
		
		gen.writeEndObject();
	}

}
