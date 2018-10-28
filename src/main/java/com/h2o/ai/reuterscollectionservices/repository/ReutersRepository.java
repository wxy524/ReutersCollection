package com.h2o.ai.reuterscollectionservices.repository;

import com.h2o.ai.reuterscollectionservices.model.Reuters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ReutersRepository extends MongoRepository<Reuters, String> {

    @Query("{}")
    public Page<Reuters> findEntries(Pageable pageable);

    @Query(value = "{ 'NEWID' : ?0 }", fields="{ 'TEXT.TITLE' : '1', 'TEXT.BODY': '1', 'TEXT.DATELINE': '1', 'TEXT.content': '1'}")
    public List<Reuters> findByNewId(int newId);

    @Query(value = "{}", fields="{'_id': '1', ?0 : '1'}")
    public List<Reuters> findByField(String field);

}
