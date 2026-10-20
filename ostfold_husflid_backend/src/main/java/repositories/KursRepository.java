package repositories;

import Database.DummyDatabase;
import models.Kursklasse;
import java.util.List;
import java.util.Optional;

public class KursRepository {
    public List<Kursklasse> hentAlleKurs() {

        return List.copyOf(DummyDatabase.kurs);
    }

    public Optional<Kursklasse> hentKurs(int id) {
        return DummyDatabase.kurs.stream()
                .filter(Kursklasse -> Kursklasse.getkurs_id() == id)
                .findFirst();
    }
}

