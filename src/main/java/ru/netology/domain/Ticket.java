package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Ticket implements Comparable<Ticket> {
    private int id;
    private double price;
    private String airportFrom;
    private String airportTo;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        return (int) (price - o.price);
    }
}