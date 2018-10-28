package com.h2o.ai.reuterscollectionservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "reuters008")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reuters {

    @Id
    private String id;

    @Field("LEWISSPLIT")
    private String lewiSplit;

    @Field("COMPANIES")
    private String companies;

    @Field("PLACES")
    private String places;

    @Field("CGISPLIT")
    private String cgiSplit;

    @Field("NEWID")
    private String newId;

    private Date date;

    @Field("OLDID")
    private String oldId;

    @Field("TEXT")
    private String text;

    @Field("TEXT.TITLE")
    private String title;

    @Field("TEXT.BODY")
    private String body;

    @Field("TEXT.DATELINE")
    private String dateLine;

    @Field("TEXT.content")
    private String content;

    @Field("TOPICS")
    private List<?> topics;

    @PersistenceConstructor
    Reuters(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getDateLine() {
        return dateLine;
    }

    public String getContent() {
        return content;
    }

    public String getNewId() {
        return newId;
    }

    public  String getOldId() {
        return oldId;
    }

    public String getCgiSplit() {
        return cgiSplit;
    }

    public String getCompanies() {
        return companies;
    }

    public String getLewiSplit() {
        return lewiSplit;
    }

    public String getPlaces() {
        return places;
    }

    public List<?> getTopics() { return topics; }
}
