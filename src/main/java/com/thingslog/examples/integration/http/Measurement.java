package com.thingslog.examples.integration.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Measurement {
    private String name;
    private Double value;
    private Long timestamp;
    private Map<String, String> tags;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("device_name")
    private String deviceName;
    @JsonProperty("sensor_name")
    private String sensorName;
    private String dimension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                ", tags=" + tags +
                ", accountName='" + accountName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", sensorName='" + sensorName + '\'' +
                ", dimension='" + dimension + '\'' +
                '}';
    }
}
