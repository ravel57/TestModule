package ru.ravel.TestModule.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ravel.TestModule.dto.Envelope;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String rootGetMapping(){
        return "index";
    }

    @PostMapping(
            value = "/sendPayment",
            consumes = { MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Object> rootPostMapping(@RequestBody Envelope envelope){
        return ResponseEntity.status(HttpStatus.OK).body(envelope);
    }

}
