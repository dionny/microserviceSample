package com.microservices.scheduler.dto;

/**
 * Created by dionnys on 4/5/16.
 */
public class GenerationRequest {
    private String modelId;
    private com.microservices.scheduling.dto.GenerationCriteria criteria;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public com.microservices.scheduling.dto.GenerationCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(com.microservices.scheduling.dto.GenerationCriteria criteria) {
        this.criteria = criteria;
    }
}
