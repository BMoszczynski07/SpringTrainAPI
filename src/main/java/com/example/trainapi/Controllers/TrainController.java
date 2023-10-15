package com.example.trainapi.Controllers;

import com.example.trainapi.Models.Train;
import com.example.trainapi.Repositories.TrainRepository;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/train")
public class TrainController {
    private final TrainRepository tr;

    public TrainController(TrainRepository trainRepository) {
        tr = trainRepository;
    }

    @GetMapping("/all-trains")
    public String getTrains(Model model) {
        List<Train> trains = tr.fetchTrains();
        model.addAttribute("trains", trains);

        return "index";
    }

    @GetMapping("/find-train/{trainId}")
    public Train findTrain(@PathVariable int trainId) {
        return tr.findTrainById(trainId);
    }
}
