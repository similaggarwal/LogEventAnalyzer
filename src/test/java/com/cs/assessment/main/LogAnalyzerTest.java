package com.cs.assessment.main;

import com.cs.assessment.model.DBLog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogAnalyzerTest {

    LogAnalyzer unitUnderTest = new LogAnalyzer();

    @Test
    void itCalculatesDuration() {
        List<DBLog> dbLogs = unitUnderTest.analyzeLogs("src/test/resources/server.log");
        var dbLog = new DBLog("1", 6, "12345", "Application_LOG", true);
        assertEquals(dbLogs.size(), 1);
        assertTrue(dbLogs.contains(dbLog));
    }

}