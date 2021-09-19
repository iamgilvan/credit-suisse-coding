package com.creditsuisse.project.common.constants;

public class Constants {
    private Constants() { }


    // SQL statement
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS event (id VARCHAR(20)," +
            " duration INTEGER, type VARCHAR(50), host VARCHAR(50), alert BOOLEAN)";

    //Messages
    public static final String EVENT_CONVERSION = "There was  error mapping the event log line from the file: {}";
    public static final String FILE_NOT_FOUND = "File not found";
    public static final String EVENT_NOT_SAVED = "Unable to save data";
    public static final String INVALID_PARAMS = "Pls provide the log file Path";
}
