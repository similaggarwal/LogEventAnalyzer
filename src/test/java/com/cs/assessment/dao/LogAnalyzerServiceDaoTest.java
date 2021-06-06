package com.cs.assessment.dao;

import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;

class LogAnalyzerServiceDaoTest {

    private LogAnalyzerDao unitUnderTest = new LogAnalyzerDao("src/test/resources/EventDB");

    @Test
    void itInsertsGivenDataInTheTable(){
        unitUnderTest.writeLogAnalysisToDB(emptyList());
    }

}