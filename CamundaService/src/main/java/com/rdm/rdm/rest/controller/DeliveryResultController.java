package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.ResultAssemblyEntity;
import com.rdm.rdm.entity.ResultAssemblyRsEntity;
import com.rdm.rdm.entity.ResultDeliveryEntity;
import com.rdm.rdm.entity.ResultDeliveryRsEntity;
import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/deliveryresult")
public class DeliveryResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RuntimeService runtimeService;

    @PostMapping
    public ResultDeliveryRsEntity deliveryResult
            (@RequestBody ResultDeliveryEntity resultDeliveryEntity) {

        logger.info("Delivery Complete:       "+ resultDeliveryEntity.getId() + ",  "
            + resultDeliveryEntity.getIsSuccess());

        HashMap<String, Object> mapVariables = new HashMap<String, Object>();

        if(resultDeliveryEntity.getIsSuccess().equals("Y")){
            mapVariables.put("deliverySuccess","Y");
            mapVariables.put("status","Delivered");
        } else{
            mapVariables.put("deliverySuccess","N");
            mapVariables.put("status","NotDelivered");
        }

        runtimeService.correlateMessage("DeliveryResult",
                resultDeliveryEntity.getId().toString(), mapVariables);

        return new ResultDeliveryRsEntity("Success");
    }
}
