package repositories;

import models.Kurs;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KursDummyRepository implements KursRepositoryInterface {

    private List<Kurs> alleKurs = new ArrayList<>();

    public KursDummyRepository() {
        // Legger til 10 dummikurs med norske temaer, trikking og treverk
        alleKurs.add(new Kurs(1, "Grunnkurs i Bunadsøm", LocalDateTime.of(2026, 6, 1, 10, 0), LocalDateTime.of(2026, 6, 5, 15, 0), 2500.0f, 1, 101, 1, "Husfliden, Oslo"));
        alleKurs.add(new Kurs(2, "Treskjæring for nybegynnere", LocalDateTime.of(2026, 6, 10, 18, 0), LocalDateTime.of(2026, 6, 12, 21, 0), 1200.0f, 2, 102, 2, "Kulturhuset, Lillehammer"));
        alleKurs.add(new Kurs(3, "Sparkling og Trikking på Sparkesykkel", LocalDateTime.of(2026, 6, 15, 12, 0), LocalDateTime.of(2026, 6, 15, 16, 0), 400.0f, 3, 103, 3, "Skatehallen, Bergen")); // (Eller bare standard Kurs-objekt)
        alleKurs.add(new Kurs(3, "Sparkling og Trikking på Sparkesykkel", LocalDateTime.of(2026, 6, 15, 12, 0), LocalDateTime.of(2026, 6, 15, 16, 0), 400.0f, 3, 103, 3, "Skatehallen, Bergen"));
        alleKurs.add(new Kurs(4, "Tradisjonell Lafting og Trearbeid", LocalDateTime.of(2026, 7, 1, 09, 0), LocalDateTime.of(2026, 7, 7, 16, 0), 4500.0f, 4, 104, 4, "Maihaugen, Lillehammer"));
        alleKurs.add(new Kurs(5, "Spelemannskurs i Hardingfele", LocalDateTime.of(2026, 7, 10, 10, 0), LocalDateTime.of(2026, 7, 14, 14, 0), 1800.0f, 5, 105, 5, "Folkehøgskolen, Telemark"));
        alleKurs.add(new Kurs(6, "Strikking av Tradisjonell Setesdal-genser", LocalDateTime.of(2026, 8, 2, 17, 0), LocalDateTime.of(2026, 8, 20, 20, 0), 950.0f, 1, 106, 6, "Huset, Kristiansand"));
        alleKurs.add(new Kurs(7, "Avansert Trikking på Snowboard", LocalDateTime.of(2026, 11, 10, 10, 0), LocalDateTime.of(2026, 11, 12, 15, 0), 2200.0f, 6, 107, 7, "Trysil Vinterpark"));
        alleKurs.add(new Kurs(8, "Smiing og Smedkunst i Jern", LocalDateTime.of(2026, 8, 15, 09, 0), LocalDateTime.of(2026, 8, 17, 15, 0), 3000.0f, 2, 108, 8, "Gamlebyen, Fredrikstad"));
        alleKurs.add(new Kurs(9, "Kajakkpadling og elvetrikk", LocalDateTime.of(2026, 6, 25, 14, 0), LocalDateTime.of(2026, 6, 26, 18, 0), 1500.0f, 3, 109, 9, "Sjoa, Otta"));
        alleKurs.add(new Kurs(10, "Baking av Tradisjonelt Krotekake", LocalDateTime.of(2026, 9, 5, 11, 0), LocalDateTime.of(2026, 9, 5, 16, 0), 800.0f, 1, 110, 10, "Bygdetunet, Valdres"));
    }

    @Override
    public List<Kurs> hentAlleKurs() {
        return List.copyOf(alleKurs);
    }

    @Override
    public Optional<Kurs> hentKurs(int kurs_id) {
        return alleKurs.stream()
                .filter(kurs -> kurs.getKurs_id() == kurs_id)
                .findFirst();
    }

    @Override
    public List<Kurs> hentKursEtterOmraade(int omraade_id) {
        List<Kurs> resultat = new ArrayList<>();
        for (Kurs kurs : alleKurs) {
            if (kurs.getOmraade_id() == omraade_id) {
                resultat.add(kurs);
            }
        }
        return resultat;
    }

    @Override
    public void leggTilKurs(Kurs nyttKurs) {
        alleKurs.add(nyttKurs);
    }

    @Override
    public void oppdaterKurs(int kurs_id, Kurs oppdatertKurs) {
        for (int i = 0; i < alleKurs.size(); i++) {
            if (alleKurs.get(i).getKurs_id() == kurs_id) {
                alleKurs.set(i, oppdatertKurs);
                return;
            }
        }
    }

    @Override
    public void slettKurs(int kurs_id) {
        alleKurs.removeIf(kurs -> kurs.getKurs_id() == kurs_id);
    }
}