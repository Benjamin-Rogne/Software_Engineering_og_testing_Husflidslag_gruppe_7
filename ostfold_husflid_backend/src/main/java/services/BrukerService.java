package services;

import DTOs.BrukerDTO;
import models.Bruker;
import repositories.BrukerRepository;

import java.util.List;
import java.util.Optional;

// behandler dataene og sender den videre til controller
public class BrukerService {

    private final BrukerRepository repository =
            new BrukerRepository();

    public List<BrukerDTO> hentAlleBrukere() {
        return repository.hentAlleBrukere()
                .stream()
                .map(this::tilDTO)
                .toList();
    }

    public Optional<BrukerDTO> hentBruker(int id) {
        return repository.hentBruker(id)
                .map(this::tilDTO);
    }

    private BrukerDTO tilDTO(Bruker bruker) {
        return new BrukerDTO(
                bruker.getBruker_id(),
                bruker.getNavn(),
                bruker.getEpost()
        );
    }
}
