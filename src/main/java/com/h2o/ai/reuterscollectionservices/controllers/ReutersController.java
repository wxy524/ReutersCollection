package com.h2o.ai.reuterscollectionservices.controllers;


import com.h2o.ai.reuterscollectionservices.model.Reuters;
import com.h2o.ai.reuterscollectionservices.response.Content;
import com.h2o.ai.reuterscollectionservices.services.DAOServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReutersController {

    private final static Logger LOGGER = LogManager.getLogger(ReutersController.class);

    @Autowired
    private DAOServices daoServices;

    @GetMapping(value = "reuters_list")
    @ResponseBody
    @ApiOperation(
            value = "Return all the objects in the particular range",
            notes = "Return all the objects in the particular range",
            response = JSONArray.class
    )
    public List<Reuters> getContent(@ApiParam(value = "The start point of object, default value is 0", example = "0", required = false)
                                        @RequestParam(value = "start", defaultValue = "0") int start,
                                    @ApiParam(value = "The offset of the range, default value is 100", example = "100", required = false)
                                    @RequestParam(value = "offset", defaultValue = "100") int offset) throws Exception{
        return daoServices.listReutersEntry(start, offset);
    }

    @GetMapping("findByField")
    @ResponseBody
    @ApiOperation(
            value = "Return all rows for one particular field",
            notes = "Return all rows for one particular field",
            response = JSONArray.class
    )
    public List<Reuters> findByFields(@ApiParam(value = "The field which will be returned", required = true)
                                          @RequestParam("field") String field) throws Exception{
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Fetching data by fileds");
        }
        return daoServices.findByField(field);
    }

    @GetMapping("findById")
    @ResponseBody
    @ApiOperation(
            value = "Return the content by particualr newId",
            notes = "Return the content by particualr newId",
            response = Content.class
    )
    public Content findContentByNewId(@ApiParam(value = "New ID for the object which is required", example = "8999", required = true)
                                          @RequestParam("newId") int newId)throws Exception{
        return daoServices.findContentByNewId(newId);
    }
}
