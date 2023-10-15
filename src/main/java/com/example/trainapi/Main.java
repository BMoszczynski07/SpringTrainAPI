package com.example.trainapi;

import com.example.trainapi.Models.Train;
import com.example.trainapi.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ComponentScan
public class Main {
    @Autowired
    private TrainRepository tr;

    @RequestMapping("/")
    public String handleWelcome(Model model) {
        List<Train> trains = tr.fetchTrains();
        model.addAttribute("trains", trains);

        return "index";
    }
}
