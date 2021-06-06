package com.cs.assessment.services;

import com.cs.assessment.model.DBLog;
import com.cs.assessment.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.*;

import static com.cs.assessment.helper.ObjectMapperUtil.OBJECT_MAPPER;

public class LogAnalyzerService {

    private final Logger LOGGER = LoggerFactory.getLogger(LogAnalyzerService.class);

    public List<DBLog> analyzeLogs(String logFilePath) {

        Map<String, Event> eventMap = new HashMap<>();
        List<DBLog> dbLogs = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(logFilePath);
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                Event event = OBJECT_MAPPER.readValue(sc.nextLine(), Event.class);
                if (eventMap.containsKey(event.getEventId())) {
                    Event existingEvent = eventMap.get(event.getEventId());
                    long duration = Math.abs(existingEvent.getTimeStamp() - event.getTimeStamp());
                    dbLogs.add(new DBLog(event.getEventId(), duration, event.getHost(), event.getType(), duration > 4));
                    eventMap.remove(event.getEventId());
                } else {
                    eventMap.put(event.getEventId(), event);
                }
            }
            sc.close();
        } catch (Exception e) {
            LOGGER.error("Error Analyzing log files", e);
        }
        return dbLogs;
    }
}
