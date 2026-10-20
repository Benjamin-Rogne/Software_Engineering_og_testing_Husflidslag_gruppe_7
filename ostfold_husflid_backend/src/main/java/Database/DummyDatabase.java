package Database;

import models.Bruker;
import models.Kursklasse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dummy database som inneholder bruker objecter "bruker table"
public class DummyDatabase {

    public static final List<Bruker> brukere =
            new ArrayList<>(List.of(
                    new Bruker("Ola Nordmann", "ola@epost.no", "io123fjk", "admin"),
                    new Bruker("Kari Hansen", "kari@epost.no","io456gjk", "bruker"),
                    new Bruker("Per Olsen", "per@epost.no","ioghj687jk", "bruker")
            ));

    public static final List<Kursklasse> kurs =
            new ArrayList<>(List.of(
            new Kurs(1, "Bunadsøm - Østfoldbunad", LocalDateTime.of(2026, 9, 1, 18, 0), LocalDateTime.of(2026, 11, 15, 21, 0), 2500.0f, 101, 1, 501, "Kirkegata 12, 1530 Moss"),
            new Kurs(2, "Treskjæring og trearbeid", LocalDateTime.of(2026, 9, 5, 17, 30), LocalDateTime.of(2026, 10, 24, 20, 30), 1800.0f, 102, 2, 502, "Storgata 45, 1607 Fredrikstad"),
            new Kurs(3, "Tradisjonell veving og tekstilhåndverk", LocalDateTime.of(2026, 9, 10, 18, 0), LocalDateTime.of(2026, 12, 3, 21, 0), 2200.0f, 103, 3, 503, "Olav Vs gate 6, 1707 Sarpsborg"),
            new Kurs(4, "Strikking og toving av ullplagg", LocalDateTime.of(2026, 9, 12, 17, 0), LocalDateTime.of(2026, 10, 17, 20, 0), 1200.0f, 104, 4, 504, "Torggata 3, 1767 Halden"),
            new Kurs(5, "Møbelsnekring og restaurering", LocalDateTime.of(2026, 9, 15, 18, 0), LocalDateTime.of(2026, 11, 24, 21, 0), 3000.0f, 105, 5, 505, "Askimsletta 8, 1850 Askim"),
            new Kurs(6, "Sy din egen bunadskjorte", LocalDateTime.of(2026, 10, 1, 18, 0), LocalDateTime.of(2026, 11, 5, 21, 0), 1500.0f, 101, 6, 506, "Dronningens gate 22, 1532 Moss"),
            new Kurs(7, "Skinnsaum og lærarbeid", LocalDateTime.of(2026, 10, 6, 17, 30), LocalDateTime.of(2026, 11, 17, 20, 30), 1900.0f, 106, 7, 507, "Mysenveien 14, 1870 Mysen"),
            new Kurs(8, "Grunnleggende treskjæring for nybegynnere", LocalDateTime.of(2026, 10, 8, 18, 0), LocalDateTime.of(2026, 11, 12, 21, 0), 1600.0f, 104, 8, 508, "Festningsgata 9, 1768 Halden"),
            new Kurs(9, "Metallsløyd og enklere smedarbeid", LocalDateTime.of(2026, 10, 15, 17, 0), LocalDateTime.of(2026, 12, 3, 20, 0), 2800.0f, 102, 9, 509, "Gamlebyen 2, 1632 Fredrikstad"),
            new Kurs(10, "Tekstilredning og ombruk av ull", LocalDateTime.of(2026, 10, 20, 18, 0), LocalDateTime.of(2026, 11, 24, 21, 0), 1400.0f, 103, 10, 510, "Tuneveien 11, 1710 Sarpsborg")
            ));
}