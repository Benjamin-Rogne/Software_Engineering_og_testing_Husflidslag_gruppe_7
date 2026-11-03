package repositories;
import models.Nyhet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NyheterRepository implements NyheterRepositoryInterface {
        private List<Nyhet> alleNyheter = new ArrayList<>();

        public NyheterRepository() {
            // Hardkodede nyheter
            alleNyheter.add(new Nyhet(1, "Nye kurs lanseres i dag!", "Vi er glade for å lansere nye spennende kurs innen treverk og trikking.", LocalDateTime.now()));
            alleNyheter.add(new Nyhet(2, "Oppdatering på nettsiden", "Nå kan du scrolle gjennom alle nyheter på en egen side.", LocalDateTime.now().minusDays(2)));
        }

        @Override
        public List<Nyhet> hentAlleNyheter() {
            return List.copyOf(alleNyheter);
        }

        @Override
        public Optional<Nyhet> hentNyhet(int nyhet_id) {
            return alleNyheter.stream().filter(n -> n.getNyhet_id() == nyhet_id).findFirst();
        }

        @Override
        public void leggTilNyhet(Nyhet nyhet) {
            alleNyheter.add(nyhet);
        }

        @Override
        public void slettNyhet(int nyhet_id) {
            alleNyheter.removeIf(n -> n.getNyhet_id() == nyhet_id);
        }
    }
