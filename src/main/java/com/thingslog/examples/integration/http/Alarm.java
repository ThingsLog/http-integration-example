package com.thingslog.examples.integration.http;

public class Alarm {
    private String alarmType;

    private Long date;

    private Long startDate;

    private Long endDate;

    private String deviceNumber;

    private String description;

    private Integer sensorIndex;

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSensorIndex() {
        return sensorIndex;
    }

    public void setSensorIndex(Integer sensorIndex) {
        this.sensorIndex = sensorIndex;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "alarmType='" + alarmType + '\'' +
                ", date=" + date +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", deviceNumber='" + deviceNumber + '\'' +
                ", description='" + description + '\'' +
                ", sensorIndex=" + sensorIndex +
                '}';
    }
}
