package com.h2o.ai.reuterscollectionservices.services;


import com.h2o.ai.reuterscollectionservices.model.Reuters;
import com.h2o.ai.reuterscollectionservices.repository.ReutersRepository;
import com.h2o.ai.reuterscollectionservices.response.Content;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DAOServicesImpl implements DAOServices{

    private final static Logger LOGGER = LogManager.getLogger(DAOServicesImpl.class);

    @Autowired
    private ReutersRepository reutersRepository;

    @Override
    public List<Reuters> listReutersEntry(int start, int offset) throws Exception{

        Page<Reuters> list = reutersRepository.findEntries(PageRequest.of(start, offset));

        if(list == null || list.getContent().size() == 0) {
            LOGGER.error("start + : " + start + " offset " + offset + "  is out of bound");
            throw new IllegalArgumentException("Requested entry is out of bound");
        }

        return list.getContent();
    }

    @Override
    public Content findContentByNewId(int newId) throws Exception {
        List<Reuters> list = reutersRepository.findByNewId(newId);

        Content content = null;

        if(list == null || list.isEmpty()) {
            LOGGER.error("Could not find newid " + newId + " in the DB");
            throw new IllegalArgumentException("Cound not find such element");
        } else {
            Reuters reuter = list.get(0);
            content = new Content()
                    .title(reuter.getTitle())
                    .body(reuter.getBody())
                    .content(reuter.getContent())
                    .dateLine(reuter.getDateLine());
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Found content by newId " + newId);
            }
        }
        return content;
    }

    @Override
    public List<Reuters> findByField(String field) throws Exception {
        List<Reuters> list = reutersRepository.findByField(field);
        if(list == null || list.isEmpty()) {
            LOGGER.error("Could not find field " + field + " in the DB");
            throw new IllegalArgumentException("Cound not find such element");
        }

        return list;
    }
}
