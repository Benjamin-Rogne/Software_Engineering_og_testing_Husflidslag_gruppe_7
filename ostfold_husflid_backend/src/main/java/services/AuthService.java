package services;

import DTOs.BrukerDTO;
import models.Bruker;
import repositories.BrukerRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class AuthService {

    private final BrukerRepository repository = new BrukerRepository();

    public Optional<BrukerDTO> hentBruker(int id) {
        Optional<Bruker> bruker = repository.hentBruker(id);

        if (bruker.isPresent()) {
            return Optional.of(new BrukerDTO(
                    bruker.get().getBruker_id(),
                    bruker.get().getNavn(),
                    bruker.get().getEpost()
            ));
        }

        return Optional.empty();
    }
    public Optional<Bruker> loggInn(String epost, String passord) {
        Optional<Bruker> bruker = repository.hentBrukerMedEpost(epost);

        if (bruker.isPresent()
                && bruker.get().getPassord() != null
                && bruker.get().getPassord().startsWith("$2")
                && BCrypt.checkpw(passord, bruker.get().getPassord())) {
            return bruker;
        }

        return Optional.empty();
    }
}


