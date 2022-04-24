package ru.ravel.TestModule.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ravel.TestModule.jaxb.Envelope;
import ru.ravel.TestModule.services.ConverterService;

import javax.servlet.http.HttpSession;
import javax.xml.bind.UnmarshalException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
@Log4j
public class MainController {

    @Autowired
    ConverterService converterService;

    Map<String, String> sessionResults = new HashMap<>();


    @GetMapping
    public String rootGetMapping() {
        return "index";
    }


    @PostMapping(value = "/sendPayment",
            consumes = {MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> rootPostMapping(@RequestBody Envelope envelope,
                                                  HttpSession httpSession) {
        try {
            String paresJson = converterService.convertEnvelopeToString(envelope);
            log.info(paresJson);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(paresJson);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            sessionResults.put(httpSession.getId(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/errorpage")
    public String errorPageGetMapping(HttpSession httpSession) {
        httpSession.setAttribute("errorMessage", sessionResults.get(httpSession.getId()));
        return "errorpage";
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> ExceptionHandlerMapping(HttpMessageNotReadableException e,
                                                          HttpSession httpSession) {
        if (e.getCause() instanceof UnmarshalException) {
            sessionResults.put(httpSession.getId(), e.getMessage());
        }
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
