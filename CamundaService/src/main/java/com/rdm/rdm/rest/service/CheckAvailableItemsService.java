package com.rdm.rdm.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdm.rdm.entity.CheckItemsEntity;
import com.rdm.rdm.entity.CheckItemsRsEntity;
import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.OrderEntityRs;
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
public class CheckAvailableItemsService {

    private final Logger log = LoggerFactory.getLogger(CheckAvailableItemsService.class);

    //@Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    private String checkItemsBaseUrl = "http://localhost:8080/";

    private static final String ITEMS_URL = "checkitems";

    public String checkItems(CheckItemsEntity checkItemsEntity) {

        final var url = checkItemsBaseUrl + ITEMS_URL ;
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Items Available Request URL: {}", url);

        String available = "N";

        try {
            final HttpEntity<CheckItemsEntity> request = new HttpEntity<CheckItemsEntity>(checkItemsEntity, headers);
            final var responseEntity = restTemplate.exchange(url, HttpMethod.POST,
                    request, CheckItemsRsEntity.class);

            available = responseEntity.getBody().getAvailable();
            if (responseEntity.getStatusCode().isError()) {
                log.error("For Order ID: {}, error response: {} is received to check Items",
                        checkItemsEntity.getOrderID(),
                        responseEntity.getStatusCode().getReasonPhrase());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "INTERNAL_SERVER_ERROR");
            }
            if (responseEntity.hasBody()) {
                log.info("Is Items in warehouse Response: {}", responseEntity.getBody().getAvailable());
                return responseEntity.getBody().getAvailable();
            }
        } catch (Exception e) {
            log.error("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}",
                    checkItemsEntity.getOrderID(), ExceptionUtils.getRootCauseMessage(e));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        }
        return available;
    }

}
