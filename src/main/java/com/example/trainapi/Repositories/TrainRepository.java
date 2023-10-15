package com.example.trainapi.Repositories;

import com.example.trainapi.Models.Train;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainRepository {
    private final JdbcTemplate jdbc;

    public TrainRepository(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
    }

    public Train findTrainById (int id) {
        String sql = "SELECT * FROM pociagi WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Train(rs.getInt("id"), rs.getString("destination"), rs.getInt("ticketPrice")));
    }

    public List<Train> fetchTrains() {
        String sql = "SELECT * FROM pociagi";
        return jdbc.query(sql, (rs, rowNum) -> new Train(rs.getInt("id"), rs.getString("destination"), rs.getInt("ticketPrice")));
    }
}
