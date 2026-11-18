package repositories;

import models.Nyhet;
import java.util.List;
import java.util.Optional;

public interface NyheterRepositoryInterface {
    List<Nyhet> hentAlleNyheter();
    Optional<Nyhet> hentNyhet(int nyhet_id);
    void leggTilNyhet(Nyhet nyhet);
    void slettNyhet(int nyhet_id);
}