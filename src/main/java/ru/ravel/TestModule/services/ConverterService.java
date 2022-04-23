package ru.ravel.TestModule.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.ravel.TestModule.jaxb.Envelope;

@Service
public class ConverterService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String convertEnvelopeToString(Envelope envelope) throws JsonProcessingException {
        return objectMapper.writeValueAsString(envelope);
    }

}
