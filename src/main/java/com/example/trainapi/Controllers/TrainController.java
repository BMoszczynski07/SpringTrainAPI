package com.example.trainapi.Controllers;

import com.example.trainapi.Models.Train;
import com.example.trainapi.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainController {
    @Autowired
    private TrainRepository tr;

    @GetMapping("/find-train/{trainId}")
    public Train findTrain(@PathVariable int trainId) {
        return tr.findTrainById(trainId);
    }

    @PostMapping("/add-train")
    public ResponseEntity<Boolean> saveTrain(@RequestBody Train train
    ) {
        try {
            String destination = train.destination;
            int ticketPrice = train.ticketPrice;

            tr.save(destination, ticketPrice);

            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
}
