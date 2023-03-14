package ru.orekhov.methods;

import ru.orekhov.jsonObject.Ticket;

import java.util.ArrayList;
import java.util.List;

import static ru.orekhov.methods.TimeOfFlight.getTimeOfFlight;

public class PercentileTimeOfFlight {
    /**
     * Расчет процентиля времени полета
     * @param tickets
     * @param k
     * @return
     */
    public static long percentileTimeOfFlight(List<Ticket> tickets, double k) {
        List<Long> times = new ArrayList<>();
        for (Ticket ticket : tickets) {
            times.add(getTimeOfFlight(ticket));
        }
        times.sort(Long::compareTo);
        int countTimes = 0;
        for (long tm : times) {
            double percentile = 1.0 * (++countTimes) / times.size();
            if (k <= percentile) {
                return tm;
            }
        }
        return 0;
    }
}
