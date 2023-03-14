package ru.orekhov;

import ru.orekhov.jsonObject.Ticket;
import ru.orekhov.jsonParsing.TicketParsing;
import ru.orekhov.methods.AVGTimeOfFlight;
import ru.orekhov.methods.PercentileTimeOfFlight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // парсер JSON
        List<Ticket> tickets = new ArrayList<>(TicketParsing.getTicketsJson("tickets.json"));

        // Расчет Среднего времени полета
        long averagTimeFlight = AVGTimeOfFlight.averageTimeOfFlight(tickets);
        System.out.println("Среднее время полета: " + averagTimeFlight / 60 / 60 + " часов " + (averagTimeFlight / 60) % 60 + " мин.");

        // Расчет процентиля
        long percentile = PercentileTimeOfFlight.percentileTimeOfFlight(tickets, 0.90);
        System.out.println( "90-й процентиль времени полета между городами  Владивосток и Тель-Авив = "
                + percentile / 60 / 60 + " часов " + (percentile / 60) % 60 + " мин.");

    }
}
