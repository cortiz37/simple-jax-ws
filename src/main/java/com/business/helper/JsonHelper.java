package com.business.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import javax.enterprise.context.Dependent;
import java.io.IOException;

@Dependent
public class JsonHelper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void merge(Object existing, Object input) throws IOException {
        final ObjectReader objectReader = objectMapper.readerForUpdating(existing);
        objectReader.readValue(objectMapper.writeValueAsBytes(input));
    }
}