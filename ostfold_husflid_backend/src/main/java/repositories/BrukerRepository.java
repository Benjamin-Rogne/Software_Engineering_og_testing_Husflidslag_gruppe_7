package repositories;

import Database.DummyDatabase;
import models.Bruker;
import java.util.List;
import java.util.Optional;

// henter data fra databasen og sender den videre til service og deretter controller til slutt react
public class BrukerRepository {

    public List<Bruker> hentAlleBrukere() {
        return List.copyOf(DummyDatabase.brukere);
    }

    public Optional<Bruker> hentBruker(int id) {
        return DummyDatabase.brukere.stream()
                .filter(bruker -> bruker.getBruker_id() == id)
                .findFirst();
    }
}
