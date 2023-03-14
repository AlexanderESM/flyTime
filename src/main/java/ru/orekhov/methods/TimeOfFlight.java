package ru.orekhov.methods;

import ru.orekhov.jsonObject.Ticket;

import java.time.ZoneOffset;

public class TimeOfFlight {
    /**
     * Расчет времени в пути
     * @param ticket
     * @return
     */
    public static long getTimeOfFlight(Ticket ticket) {

        long time;
        time = ticket.getArrivalDateTime().toEpochSecond(ZoneOffset.of(ticket.getDestination().getTimezone())) -
                ticket.getDepartureDateTime().toEpochSecond(ZoneOffset.of(ticket.getOrigin().getTimezone()));
        if (time < 0)
            throw new RuntimeException("Время полета не может быть отрицательным");
        return time;
    }
}
