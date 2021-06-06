package com.cs.assessment;

import com.cs.assessment.dao.LogAnalyzerDao;
import com.cs.assessment.model.DBLog;
import com.cs.assessment.services.LogAnalyzerService;

import java.util.List;
import java.util.Scanner;

public class LogEventAnalyzer {

    public static void main(String args[]) {

        LogAnalyzerService logAnalyzerService = new LogAnalyzerService();
        LogAnalyzerDao logAnalyzerDao = new LogAnalyzerDao("src/main/resources/DB/EventDB");

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the complete log file path or Q/q to quit");
            String s = sc.next();
            if (s.equalsIgnoreCase("Q")) {
                logAnalyzerDao.closeConnection();
                System.exit(0);
            } else {
                List<DBLog> dbLogs = logAnalyzerService.analyzeLogs(s);
                logAnalyzerDao.writeLogAnalysisToDB(dbLogs);
                System.out.println("Log Events saved to DB");
            }

        }
    }
}
