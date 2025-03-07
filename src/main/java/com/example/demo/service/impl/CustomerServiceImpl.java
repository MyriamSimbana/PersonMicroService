package com.example.demo.service.impl;

import com.example.demo.domain.dto.CustomerDto;
import com.example.demo.domain.dto.errorDto.ErrorDto;
import com.example.demo.domain.jpa.CustomerJpa;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CustomerServiceImpl implements CustomerService {

    ObjectMapper objectMapper = new ObjectMapper();
    CustomerRepository customerRepository;

    @Override
    public String validateIdentification(CustomerDto customerDto,String channel) throws JsonProcessingException {
        log.info("channel send:{} toBodyRequest:{}",channel,objectMapper.writeValueAsString(customerDto));
        if(customerDto.isActive()){
            return "OK";//customerDto.getIdentification().length()==10?"validado":"error";
        }
        throw new BadRequestException(ErrorDto.builder().message("Customer is inactive").status(400).build());

    }

    @Override
    public Integer saverCustomer(CustomerJpa customerJpa) {
        return customerRepository.save(customerJpa).getId();
    }

}
