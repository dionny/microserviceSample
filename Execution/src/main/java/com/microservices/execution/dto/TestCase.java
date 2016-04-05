package com.microservices.execution.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by dionnys on 4/5/16.
 */
public class TestCase implements Serializable {
    private UUID uuid;
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

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
