package com.rdm.rdm.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdm.rdm.entity.SendToServiceEntity;
import com.rdm.rdm.entity.SendToServiceRsEntity;
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
public class SendOrderRs {

    private final Logger log = LoggerFactory.getLogger(SendOrderRs.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    private String BaseUrl = "http://localhost:8082/";

    private static final String ITEMS_URL = "packagingresult";


    public String sendRs(SendToServiceEntity sendToServiceEntity) {
        final var url = BaseUrl + ITEMS_URL;
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Packaging Result Request URL: {}", url);

        try {
            final HttpEntity<SendToServiceEntity> request = new HttpEntity<SendToServiceEntity>(
                    sendToServiceEntity, headers);

            log.info("Packaging : {}", request);

            final var responseEntity = restTemplate.exchange(url, HttpMethod.POST, request,
                    SendToServiceRsEntity.class);

            if (responseEntity.getStatusCode().isError()) {
                log.error("For Order ID: {}, error response: {} is received to create Order in Service",
                        sendToServiceEntity.getId(),
                        responseEntity.getStatusCode().getReasonPhrase());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

            }
            if (responseEntity.hasBody()) {
                log.info("Response: {}", responseEntity.getBody().getStatus());
                return responseEntity.getBody().getStatus();
            }
        } catch (Exception e) {
            log.error("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}",
                    sendToServiceEntity.getId(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        }
        return "N";
    }

}
