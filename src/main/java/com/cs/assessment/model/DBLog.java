package com.cs.assessment.model;

import java.util.Objects;

public class DBLog {
    private final String id;
    private final long duration;
    private final String host;
    private final String type;
    private final boolean alert;


    public DBLog(String id, long duration, String host, String type, boolean alert) {
        this.id = id;
        this.duration = duration;
        this.host = host;
        this.type = type;
        this.alert = alert;
    }

    public String getId() {
        return id;
    }

    public long getDuration() {
        return duration;
    }

    public String getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public boolean isAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "DBLog{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                ", host='" + host + '\'' +
                ", type='" + type + '\'' +
                ", alert=" + alert +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBLog dbLog = (DBLog) o;
        return duration == dbLog.duration && alert == dbLog.alert && Objects.equals(id, dbLog.id) && Objects.equals(host, dbLog.host) && Objects.equals(type, dbLog.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, host, type, alert);
    }
}
