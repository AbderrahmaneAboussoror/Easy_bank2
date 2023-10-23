package com.AboussororAbderrahmane.app.model.simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Simulation {
    protected String _number;
    protected LocalDate _date;
    protected demandStatus _status;
    protected double _price;
    protected int _duration;
}
