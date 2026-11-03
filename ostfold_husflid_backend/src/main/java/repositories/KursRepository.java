package repositories;

import models.Kurs;

import java.util.ArrayList;
import java.util.List;

public class KursRepository {
    private List<Kurs> alleKurs = new ArrayList<>();

    // Konstruktør som fyller med litt testdata (valgfritt)
    public KursRepository() {
        // Legg til eksempel-kurs her hvis man ønsker det
    }

    // Hent alle kurs
    public List<Kurs> hentAlleKurs() {
        return alleKurs;
    }

    // Hent ett spesifikt kurs basert på ID
    
    public Kurs hentKurs(int kursId) {
        for (Kurs k : alleKurs) {
            if (k.getKurs_id() == kursId) {
                return k;
            }
        }
        return null;
    }

    // Legg til et nytt kurs
    public void leggTilKurs(Kurs nyttKurs) {
        alleKurs.add(nyttKurs);
    }
}

