package com.h2o.ai.reuterscollectionservices.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Content {

    private String title;
    private String body;
    private String note;
    private String dateLine;
    private String content;

    public Content() {

    }

    public Content(String title, String body, String note, String dateLine, String content) {
        this.title = title;
        this.body = body;
        this.note = note;
        this.dateLine = dateLine;
        this.content = content;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("Title")
    public String getTitle() {
        return this.title;
    }

    @JsonProperty("Body")
    public String getBody() {
        return this.body;
    }

    @JsonProperty("DateLine")
    public String getDateLine() {
        return this.dateLine;
    }

    @JsonProperty("Content")
    public String getContent() {
        return this.content;
    }

    public Content build() {
        return this;
    }

    public Content title(String title) {
        this.title = title == null ? title : title.replace("\n", "");
        return this;
    }

    public Content body(String body) {
        this.body = body == null ? body :body.replace("\n", "");
        return this;
    }

    public Content dateLine(String dateLine) {
        this.dateLine = dateLine == null ? dateLine : dateLine.replace("\n", "");
        return this;
    }

    public Content content(String content) {
        this.content = content == null ? content : content.replace("\n", "");
        return this;
    }
}
