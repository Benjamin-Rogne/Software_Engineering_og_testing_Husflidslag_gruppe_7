package services;

import DTOs.PaameldingDTO;
import repositories.PaameldingRepository;

import java.time.LocalDateTime;
import java.util.List;

public class PaameldingService {
    private final PaameldingRepository repository = new PaameldingRepository();

    //Hente alle påmeldinger
    public List<PaameldingDTO> hentAllePaameldinger() {
        return repository.hentAllePaameldinger();
    }

    //Sjekke om brukeren er påmeldt fra før
    public boolean erBrukerPaameldt(int idbruker, int idkurs) {
        return repository.erBrukerPaameldt(idbruker, idkurs);
    }

    //Legge til påmelding med forretningslogikk (sjekker duplikater først)
    public String leggTilPaamelding(int idbruker, int idkurs, int aktivitet_id) {
        // Validering: Sjekk om brukeren allerede er påmeldt
        if (repository.erBrukerPaameldt(idbruker, idkurs)) {
            return "Brukeren er allerede påmeldt dette kurset.";
        }

        boolean vellykket = repository.leggTilPaamelding(idbruker, idkurs, aktivitet_id);

        if (vellykket) {
            return "Påmelding vellykket!";
        } else {
            return "Det oppstod en feil under påmeldingen.";
        }
    }

    //Oppdatere påmelding
    public boolean oppdaterPaamelding(int paameldingsId, int brukerId, int kursId, LocalDateTime datoTid) {
        return repository.oppdaterpaamelding(paameldingsId, brukerId, kursId, datoTid);
    }

    //Melde av / slette påmelding
    public boolean slettPaamelding(int idbruker, int idkurs) {
        return repository.slettPaamelding(idbruker, idkurs);
    }
}