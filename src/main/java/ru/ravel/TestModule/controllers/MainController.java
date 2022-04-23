package ru.ravel.TestModule.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ravel.TestModule.jaxb.Envelope;
import ru.ravel.TestModule.services.ConverterService;

import javax.xml.bind.UnmarshalException;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ConverterService converterService;

    @GetMapping
    public String rootGetMapping() {
        return "index";
    }

    @PostMapping(
            value = "/sendPayment",
            consumes = {MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> rootPostMapping(@RequestBody Envelope envelope) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(converterService.convertEnvelopeToString(envelope));
        } catch (JsonProcessingException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> ExceptionHandlerMapping(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof UnmarshalException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unmarshal exception");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
