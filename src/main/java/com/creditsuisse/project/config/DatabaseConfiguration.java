package com.creditsuisse.project.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.creditsuisse.project.common.constants.Constants.CREATE_TABLE;

@Configuration
@ComponentScan(basePackages = {"com.creditsuisse"})
@Slf4j
public class DatabaseConfiguration {

    private static final String USER = "user";
    private static final String PASSWORD = "";
    private static final String HSQL_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    private static final String STRING_CONNECTION = "jdbc:hsqldb:file:eventdb;ifexists=false";

    @Bean
    public ObjectMapper objectMapper() {
         return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Bean
    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(HSQL_DRIVER);
        Connection connection = DriverManager.getConnection(STRING_CONNECTION, USER, PASSWORD);
        connection.createStatement().execute(CREATE_TABLE);
        return connection;
    }
}
