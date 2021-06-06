package com.cs.assessment.main.dao;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;

class LogAnalyzerDaoTest {

    private LogAnalyzerDao unitUnderTest = new LogAnalyzerDao("src/test/resources/EventDB");

    @Test
    void itInsertsGivenDataInTheTable(){
        unitUnderTest.writeLogAnalysisToDB(emptyList());
    }

}