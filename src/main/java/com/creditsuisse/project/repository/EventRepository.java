package com.creditsuisse.project.repository;

import com.creditsuisse.project.common.dto.EventLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

@Repository
@Slf4j
@Transactional
public class EventRepository implements AutoCloseable{

    private final static String sql = "INSERT INTO event (id, duration, type, host, alert)  VALUES (?, ?, ?, ?, ?)";
    private final Connection conn;
    private PreparedStatement statement;

    public EventRepository(final Connection conn) {
        this.conn = conn;
    }

    public Boolean saveEvent(EventLog eventLog) {
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, eventLog.getEndEvent().getId());
            statement.setLong(2, eventLog.getDuration());
            statement.setString(3, Objects.nonNull(eventLog.getEndEvent().getType()) ?
                    eventLog.getStartEvent().getType().getEventType(): null);
            statement.setString(4, eventLog.getEndEvent().getHost());
            statement.setBoolean(5, eventLog.isLongRunningEvent());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            log.error("Failure saving event, skipping",  e);
            return false;
        }
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            log.error("Failure closing database connection",  e);
        }
    }

}
