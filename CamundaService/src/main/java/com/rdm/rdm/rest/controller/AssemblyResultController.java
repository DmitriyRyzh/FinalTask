package com.rdm.rdm.rest.controller;

import com.rdm.rdm.entity.OrderEntity;
import com.rdm.rdm.entity.ResultAssemblyEntity;
import com.rdm.rdm.entity.ResultAssemblyRsEntity;
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
@RequestMapping("/assemblyresult")
public class AssemblyResultController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RuntimeService runtimeService;


    @PostMapping//(consumes = "application/json")
    public ResultAssemblyRsEntity assemblyResult
            (@RequestBody ResultAssemblyEntity resultAssemblyEntity) {
        logger.info("Assembling Complete:       "+ resultAssemblyEntity.getId() + ",  "
            + resultAssemblyEntity.getIsSuccess());

        HashMap<String, Object> mapVariables = new HashMap<String, Object>();

        if(resultAssemblyEntity.getIsSuccess().equals("Y")){
            mapVariables.put("assemblySuccess","Y");
            mapVariables.put("status","Assembled");
        } else{
            mapVariables.put("assemblySuccess","N");
            mapVariables.put("status","NotAssembled");
        }

        runtimeService.correlateMessage("AssemblyResult",
                resultAssemblyEntity.getId().toString(), mapVariables);

        return new ResultAssemblyRsEntity("Success");
    }
}
