package com.cs.assessment.main;

import com.cs.assessment.main.dao.LogAnalyzerDao;
import com.cs.assessment.model.DBLog;

import java.util.List;
import java.util.Scanner;

public class LogEventAnalyzer {

    public static void main(String args[]) {


        LogAnalyzer logAnalyzer = new LogAnalyzer();
        LogAnalyzerDao logAnalyzerDao = new LogAnalyzerDao("src/main/resources/DB/EventDB");

        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter the complete log file path or Q/q to quit");
            String s = sc.next();
            if (s.equalsIgnoreCase("Q")) {
                System.exit(0);
            } else {
                List<DBLog> dbLogs = logAnalyzer.analyzeLogs(s);
                logAnalyzerDao.writeLogAnalysisToDB(dbLogs);
                System.out.println("Log Events saved to DB");
            }

        }
    }
}
