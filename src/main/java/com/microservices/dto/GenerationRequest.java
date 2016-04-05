package com.microservices.dto;

/**
 * Created by dionnys on 4/5/16.
 */
public class GenerationRequest {
    private String modelId;
    private GenerationCriteria criteria;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public GenerationCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(GenerationCriteria criteria) {
        this.criteria = criteria;
    }
}
