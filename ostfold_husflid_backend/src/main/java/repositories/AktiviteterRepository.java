package repositories;

import models.Aktiviteter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AktiviteterRepository implements AktiviteterRepositoryInterface {
    private List<Aktiviteter> alleAktiviteter = new ArrayList<>();

    public void AktiviteterRepository() {
        // Legger til noen dummiklasser/-aktiviteter for testing
        alleAktiviteter.add(new Aktiviteter(1, "Kveldskurs i treskjæring", "trearbeid.jpg", "Lær grunnleggende teknikker i trearbeid.", LocalDate.of(2026, 6, 10), 101));
        alleAktiviteter.add(new Aktiviteter(2, "Felles sy-kveld", "sykveld.jpg", "Vi møtes for å sy og reparere klær.", LocalDate.of(2026, 6, 12), 102));
    }

    @Override
    public List<Aktiviteter> hentAlleAktiviteter() {
        return List.copyOf(alleAktiviteter);
    }

    @Override
    public Optional<Aktiviteter> hentAktivitet(int aktivitet_id) {
        return alleAktiviteter.stream()
                .filter(a -> a.getAktivitet_id() == aktivitet_id)
                .findFirst();
    }

    @Override
    public List<Aktiviteter> hentAktiviteterEtterOmraade(int omraade_id) {
        List<Aktiviteter> resultat = new ArrayList<>();
        for (Aktiviteter a : alleAktiviteter) {
            if (a.getOmraade_id() == omraade_id) {
                resultat.add(a);
            }
        }
        return resultat;
    }

    @Override
    public void leggTilAktivitet(Aktiviteter aktiviteter) {
        alleAktiviteter.add(aktiviteter);
    }

    @Override
    public void slettAktivitet(int aktivitet_id) {
        alleAktiviteter.removeIf(a -> a.getAktivitet_id() == aktivitet_id);
    }


    public void oppdaterAktivitet(int aktivitet_id, Aktiviteter aktivitet) {
        for (int i = 0; i < alleAktiviteter.size(); i++) {
            if (alleAktiviteter.get(i).getAktivitet_id() == aktivitet_id) {
                aktivitet.setAktivitet_id(aktivitet_id);
                alleAktiviteter.set(i, aktivitet);
                return;
            }
        }
    }

}