package com.example.demo.controller;

import com.example.demo.domain.dto.CustomerDto;
import com.example.demo.domain.jpa.CustomerJpa;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApiController {

    CustomerService customerService;

    @GetMapping("/api")
    public ResponseEntity<Object> startController(@RequestBody @Valid CustomerDto customerDto, @RequestHeader(value = "channel") String channel) throws JsonProcessingException {
        return new ResponseEntity<>(customerService.validateIdentification(customerDto, channel), HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<Object> saveController(@RequestBody @Valid CustomerJpa customerJpa) {
        return new ResponseEntity<>(customerService.saverCustomer(customerJpa), HttpStatus.OK);
    }

}
