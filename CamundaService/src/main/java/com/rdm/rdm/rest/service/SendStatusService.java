package com.rdm.rdm.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdm.rdm.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class SendStatusService {

    private final Logger log = LoggerFactory.getLogger(SendToPackagingService.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ObjectMapper objectMapper;

    private String BaseUrl = "http://localhost:8081/";


    private static final String ITEMS_URL = "changeStatus";

    public String SendStatus(ChangeStatusEntity changeStatusEntity) {
        final var url = BaseUrl + ITEMS_URL;
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Send to Change Order Status: {}", url);

        try {
            final HttpEntity<ChangeStatusEntity> request =
                    new HttpEntity<ChangeStatusEntity>(changeStatusEntity, headers);
            final var responseEntity = restTemplate.exchange(url, HttpMethod.POST,
                    request, ChangeStatusEntityRs.class);

            if (responseEntity.getStatusCode().isError()) {
                log.error("For Order ID: {}, error response: {} is received to check Items",
                        changeStatusEntity.getId(),
                        responseEntity.getStatusCode().getReasonPhrase());
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "INTERNAL_SERVER_ERROR");
            }
            if (responseEntity.hasBody()) {
                log.info("Change Status Response: {}",
                        responseEntity.getBody().getIsSuccess());
                return responseEntity.getBody().getIsSuccess();
            }
        } catch (Exception e) {
            log.error("For Order ID: {}, cannot create Order in Customer Microservice for reason: {}",
                    changeStatusEntity.getId(), ExceptionUtils.getRootCauseMessage(e));
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD_REQUEST");
        }
        return "Y";
    }

}
