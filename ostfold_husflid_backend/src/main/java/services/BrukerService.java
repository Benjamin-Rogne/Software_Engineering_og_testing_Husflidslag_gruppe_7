package services;

import DTOs.BrukerDTO;
import DTOs.OpprettBrukerDTO;
import models.Bruker;
import repositories.BrukerRepository;
import org.mindrot.jbcrypt.BCrypt;
import DTOs.OppdaterBrukerDTO;

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
    public BrukerDTO opprettBruker(OpprettBrukerDTO dto) {

        // Valider navn
        if (dto.getNavn() == null ||
                dto.getNavn().isBlank()) {
            throw new IllegalArgumentException(
                    "Navn kan ikke være tomt"
            );
        }

        // Valider e-post
        if (dto.getEpost() == null ||
                !dto.getEpost().matches(
                        "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"
                )) {
            throw new IllegalArgumentException(
                    "Ugyldig e-postadresse"
            );
        }

        // Valider passord
        if (dto.getPassord() == null ||
                dto.getPassord().length() < 12) {
            throw new IllegalArgumentException(
                    "Passord må ha minst 12 tegn"
            );
        }

        // Hash passordet
        String passordHash = BCrypt.hashpw(
                dto.getPassord(),
                BCrypt.gensalt(12)
        );

        // Standardrolle
        String rolle = "bruker";

        // Opprett brukerobjekt
        Bruker bruker = new Bruker(
                dto.getNavn().trim(),
                dto.getEpost().trim(),
                passordHash,
                rolle
        );

        // Lagre i MySQL
        Bruker opprettet =
                repository.opprettBruker(bruker);

        // Returner uten passord
        return tilDTO(opprettet);
    }
    public Optional<BrukerDTO> oppdaterBruker(
            int id, OppdaterBrukerDTO dto) {

        boolean oppdatert = repository.oppdaterBruker(
                id,
                dto.getNavn(),
                dto.getEpost()
        );

        if (!oppdatert) {
            return Optional.empty();
        }

        return hentBruker(id);
    }

    public boolean slettBruker(int id) {
        return repository.slettBruker(id);
    }
}
