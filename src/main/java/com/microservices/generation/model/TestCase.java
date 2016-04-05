package com.microservices.generation.model;

import java.util.List;

/**
 * Created by dionnys on 4/5/16.
 */
public class TestCase {
    private String id;
    private String modelId;
    private List<String> preconditions;
    private List<String> actions;

    public List<String> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(List<String> preconditions) {
        this.preconditions = preconditions;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getId() {
        return id;
    }
}
