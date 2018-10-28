package com.h2o.ai.reuterscollectionservices.services;

import com.h2o.ai.reuterscollectionservices.model.Reuters;
import com.h2o.ai.reuterscollectionservices.response.Content;

import java.util.List;

public interface DAOServices {

    public List<Reuters> listReutersEntry(int start, int offset) throws Exception;

    public Content findContentByNewId(int newId) throws Exception;

    public List<Reuters> findByField(String filed) throws Exception;
}
