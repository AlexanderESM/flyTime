package ru.orekhov.methods;

import ru.orekhov.jsonObject.Ticket;

import java.util.List;

public class AVGTimeOfFlight {
    /**
     * Расчет среднего значения времени в пути
     * @param tickets
     * @return
     */
    public static long averageTimeOfFlight(List<Ticket> tickets) {
        long average = 0;
        for (Ticket ticket : tickets) {
            average += TimeOfFlight.getTimeOfFlight(ticket) / tickets.size();
        }
        return average;
    }
}
