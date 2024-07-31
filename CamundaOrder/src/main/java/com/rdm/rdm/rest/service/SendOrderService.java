package com.rdm.rdm.rest.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rdm.rdm.entity.OrderOutput;
import com.rdm.rdm.entity.SendOrderRsEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class SendOrderService {
    private final Logger log = LoggerFactory.getLogger(SendOrderService.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    private String checkItemsBaseUrl = "http://localhost:8082/";

    private static final String ITEMS_URL = "order";

    public String sendOrder(OrderOutput orderOutput) {
        final var url = checkItemsBaseUrl + ITEMS_URL;
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Order Request URL: {}", url);

        try {
            final HttpEntity<OrderOutput> request = new HttpEntity<OrderOutput>(orderOutput, headers);

            log.info("Object: {}", request);
            final var responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, SendOrderRsEntity.class);

            System.out.println("Response Code: " + responseEntity.getStatusCode());
            if (responseEntity.getStatusCode().isError()) {
                log.error("For Order ID: {}, error response: {} is received to create Order in Service",
                        orderOutput.getId(),
                        responseEntity.getStatusCode().getReasonPhrase());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

            }
            if (responseEntity.hasBody()) {
                log.info("Response: {}", responseEntity.getBody().getIsSuccess());
                return responseEntity.getBody().getIsSuccess();
            }
        } catch (Exception e) {
            log.error("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}",
                    orderOutput.getId(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        }
        return "N";
    }
}
