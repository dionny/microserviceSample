package com.microservices.scheduler.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScheduledExecution {
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getHref() {
        return "http://localhost:9002/executions/" + uuid;
    }
}
