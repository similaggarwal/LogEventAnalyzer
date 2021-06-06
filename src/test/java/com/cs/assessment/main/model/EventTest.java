package com.cs.assessment.main.model;

import com.cs.assessment.model.Event;
import com.cs.assessment.model.EventState;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void eventParser() throws IOException {
        String s = "{\"id\" : \"1\" , \"state\": \"STARTED\" , \"type\" : \"Application_LOG\" , \"host\" : \"12345\" , \"timestamp\": 1622874574312 }";
        Event event = objectMapper.readValue(s, Event.class);
        assertEquals(event , new Event("1", EventState.STARTED, "12345", "Application_LOG", 1622874574312l));
    }
}
