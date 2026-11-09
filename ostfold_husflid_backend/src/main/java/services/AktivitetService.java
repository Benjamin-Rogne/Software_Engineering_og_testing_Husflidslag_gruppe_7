
package services;

import models.Aktiviteter;
import repositories.AktiviteterRepository;

import java.util.List;

public class AktivitetService {

    private final AktiviteterRepository repository = new AktiviteterRepository();

    public List<Aktiviteter> getAllAktiviteter() {
        return repository.hentAlleAktiviteter();
    }

    public Aktiviteter hentAktivitet(int id) {
        return repository.hentAktivitet(id).orElse(null);
    }

    public void addAktivitet(Aktiviteter aktivitet) {
        repository.leggTilAktivitet(aktivitet);
    }

    public boolean oppdaterAktivitet(int id, Aktiviteter aktivitet) {
        if (repository.hentAktivitet(id).isEmpty()) {
            return false;
        }

        repository.oppdaterAktivitet(id, aktivitet);
        return true;
    }

    public boolean slettAktivitet(int id) {
        if (repository.hentAktivitet(id).isEmpty()) {
            return false;
        }

        repository.slettAktivitet(id);
        return true;
    }
}
