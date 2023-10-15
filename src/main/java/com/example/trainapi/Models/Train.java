package com.example.trainapi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Train {
    public int id;

    public String destination;

    public int ticketPrice;
}
