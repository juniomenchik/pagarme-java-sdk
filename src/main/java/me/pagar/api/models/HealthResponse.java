/*
 * PagarmeApiSDKLib
 */
package me.pagar.api.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Map;

public class HealthResponse {
    private String status;
    private String service;
    private String description;
    private String timestamp;
    private Map<String, Object> sdk;
    private Map<String, Object> api;

    @JsonGetter("status")
    public String getStatus() {
        return status;
    }

    @JsonGetter("service")
    public String getService() {
        return service;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonGetter("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonGetter("sdk")
    public Map<String, Object> getSdk() {
        return sdk;
    }

    @JsonGetter("api")
    public Map<String, Object> getApi() {
        return api;
    }
}