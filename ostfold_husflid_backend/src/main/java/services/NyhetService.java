
package services;

import DTOs.NyhetDTO;
import models.Nyhet;
import repositories.NyheterRepository;

import java.util.List;

public class NyhetService {

    private final NyheterRepository repository = new NyheterRepository();

    public List<Nyhet> getAllNyheter() {
        return repository.hentAlleNyheter();
    }

    public Nyhet hentNyhet(int id) {
        return repository.hentNyhet(id).orElse(null);
    }

    public void addNyhet(Nyhet nyhet) {
        repository.leggTilNyhet(nyhet);
    }

    public boolean oppdaterNyhet(int id, Nyhet nyhet) {
        if (repository.hentNyhet(id).isEmpty()) {
            return false;
        }

        repository.oppdaterNyhet(id, nyhet);
        return true;
    }

    public boolean slettNyhet(int id) {
        if (repository.hentNyhet(id).isEmpty()) {
            return false;
        }

        repository.slettNyhet(id);
        return true;
    }
}
