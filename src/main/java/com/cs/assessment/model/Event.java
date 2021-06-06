package com.cs.assessment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Event {

    private String eventId;
    private EventState eventState;
    private String host;
    private String type;
    private long timeStamp;

    @JsonCreator
    public Event(@JsonProperty("id") String eventId,
                 @JsonProperty("state") EventState eventState,
                 @JsonProperty("host") String host,
                 @JsonProperty("type") String type,
                 @JsonProperty("timestamp")long timeStamp) {
        this.eventId = eventId;
        this.eventState = eventState;
        this.host = host;
        this.type = type;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return timeStamp == event.timeStamp && Objects.equals(eventId, event.eventId) && eventState == event.eventState && Objects.equals(host, event.host) && Objects.equals(type, event.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventState, host, type, timeStamp);
    }

    public String getEventId() {
        return eventId;
    }

    public EventState getEventState() {
        return eventState;
    }

    public String getHost() {
        return host;
    }

    public String getType() {
        return type;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventState=" + eventState +
                ", host='" + host + '\'' +
                ", type='" + type + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
