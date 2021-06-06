package com.cs.assessment.main.dao;

import com.cs.assessment.model.DBLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LogAnalyzerDao {

    private Connection conn;
    private final Logger LOGGER = LoggerFactory.getLogger(LogAnalyzerDao.class);

    public LogAnalyzerDao(String dbPath) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection(
                    "jdbc:hsqldb:file:" + dbPath, "SA", "");
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Error Creating Database", e);
            e.printStackTrace();
        }
    }

    public void writeLogAnalysisToDB(List<DBLog> dbLogList) {
        try {
            Statement statement = conn.createStatement();
            createEventAnalysisTable(statement);
            for(DBLog dbLog : dbLogList) {
                System.out.println("INSERT INTO EventAnalysis VALUES('"+dbLog.getId()+"', "+dbLog.getDuration()+" , "+dbLog.getType()+" , "+dbLog.getHost()+" , '"+dbLog.isAlert()+"')");
                statement.executeUpdate("INSERT INTO EventAnalysis VALUES('"+dbLog.getId()+"', "+dbLog.getDuration()+" , '"+dbLog.getType()+"' , '"+dbLog.getHost()+"' , '"+dbLog.isAlert()+"')");
            }
            LOGGER.info("insert data into TABLE:EventAnalysis count {}",dbLogList.size());
            conn.close();

        } catch (Exception e) {
            LOGGER.error("Error Inserting Data in table", e);
            e.printStackTrace();
        }
    }

    private void createEventAnalysisTable(Statement statement) throws SQLException {
        try {


            statement.executeUpdate("create table IF NOT EXISTS EventAnalysis(EVENT_ID VARCHAR(50)," +
                    "DURATION INTEGER," +
                    "TYPE VARCHAR(100)," +
                    "HOST VARCHAR(100)," +
                    "ALERT VARCHAR(10))");
            LOGGER.info("created TABLE EventAnalysis");


        } catch (Exception e) {
            LOGGER.error("Error creating Table EventAnalysis ", e);
            e.printStackTrace();
        }
    }

}
