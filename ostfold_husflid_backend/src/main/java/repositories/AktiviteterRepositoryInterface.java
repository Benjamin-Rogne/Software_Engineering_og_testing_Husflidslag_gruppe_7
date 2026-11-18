package repositories;

import models.Aktiviteter;
import java.util.List;
import java.util.Optional;

public interface AktiviteterRepositoryInterface {
    List<Aktiviteter> hentAlleAktiviteter();
    Optional<Aktiviteter> hentAktivitet(int aktivitet_id);
    List<Aktiviteter> hentAktiviteterEtterOmraade(int omraade_id);
    void leggTilAktivitet(Aktiviteter aktiviteter);
    void slettAktivitet(int aktivitet_id);
}