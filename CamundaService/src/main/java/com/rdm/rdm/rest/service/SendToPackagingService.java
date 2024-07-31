package com.rdm.rdm.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdm.rdm.entity.OrderToAssembly;
import com.rdm.rdm.entity.OrderToAssemblyRs;
import com.rdm.rdm.entity.OrderToPackaging;
import com.rdm.rdm.entity.OrderToPackagingRs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class SendToPackagingService {

    private final Logger log = LoggerFactory.getLogger(SendToPackagingService.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    private String BaseUrl = "http://localhost:8083/";

    private static final String ITEMS_URL = "packaging";

    public String SendToPackaging(OrderToPackaging orderToPackaging) {
        final var url = BaseUrl + ITEMS_URL;
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Send to Packaging Request URL: {}", url);

        try {
            final var request = new HttpEntity<>(orderToPackaging, headers);
            final var responseEntity = restTemplate.postForEntity(url, request, OrderToPackagingRs.class);
            if (responseEntity.getStatusCode().isError()) {
                log.error("For Order ID: {}, error response: {} is received to check Items",
                        orderToPackaging.getId(),
                        responseEntity.getStatusCode().getReasonPhrase());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "INTERNAL_SERVER_ERROR");
            }
            if (responseEntity.hasBody()) {
                log.info("Order to Packaging Response: {}", responseEntity.getBody().getIsSuccess());
                return responseEntity.getBody().getIsSuccess();
            }
        } catch (Exception e) {
            log.error("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}",
                    orderToPackaging.getId(), ExceptionUtils.getRootCauseMessage(e));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        }
        return "N";
    }

}
