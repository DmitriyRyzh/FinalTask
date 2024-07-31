package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.ResultAssemblyEntity;
import com.rdm.rdm.entity.ResultAssemblyRsEntity;
import com.rdm.rdm.entity.ResultPackagingEntity;
import com.rdm.rdm.entity.ResultPackagingRsEntity;
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
@RequestMapping("/packagingresult")
public class PackagingResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RuntimeService runtimeService;

    @PostMapping
    public ResultPackagingRsEntity packagingResult
            (@RequestBody ResultPackagingEntity resultPackagingEntity) {

        logger.info("Packaging Complete:       "+ resultPackagingEntity.getId() + ",  "
            + resultPackagingEntity.getIsSuccess());

        HashMap<String, Object> mapVariables = new HashMap<String, Object>();

        if(resultPackagingEntity.getIsSuccess().equals("Y")){
            mapVariables.put("packagingSuccess","Y");
            mapVariables.put("status","Packaged");
        } else{
            mapVariables.put("packagingSuccess","N");
            mapVariables.put("status","NotPackaged");
        }

        runtimeService.correlateMessage("PackagingResult",
                resultPackagingEntity.getId().toString(), mapVariables);

        return new ResultPackagingRsEntity("Success");
    }
}
