package repositories;

import DTOs.PaameldingDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaameldingDummyRepository extends PaameldingRepository {
    private List<PaameldingDTO> paameldinger = new ArrayList<>();

    public PaameldingDummyRepository() {
        // Legg til noen start-påmeldinger for testing
        paameldinger.add(new PaameldingDTO(1, 1, 10, LocalDateTime.now(), 501));
        paameldinger.add(new PaameldingDTO(2, 2, 12, LocalDateTime.now(), 502));
    }

    @Override
    public boolean leggTilPaamelding(int idbruker, int idkurs, int aktivitet_id) {
        // Sjekk om brukeren alt er påmeldt i dummy-listen
        if (erBrukerPaameldt(idbruker, idkurs)) {
            return false;
        }
        PaameldingDTO ny = new PaameldingDTO(paameldinger.size() + 1, idbruker, idkurs, LocalDateTime.now(), aktivitet_id);
        paameldinger.add(ny);
        return true;
    }

    @Override
    public List<PaameldingDTO> hentAllePaameldinger() {
        return new ArrayList<>(paameldinger);
    }

    @Override
    public boolean erBrukerPaameldt(int idBruker, int idKurs) {
        return paameldinger.stream()
                .anyMatch(p -> p.getBrukerId() == idBruker && p.getKursId() == idKurs);
    }

    @Override
    public boolean slettPaamelding(int idbruker, int idkurs) {
        return paameldinger.removeIf(p -> p.getBrukerId() == idbruker && p.getKursId() == idkurs);
    }

    @Override
    public boolean oppdaterpaamelding(int idPaamelding, int idbruker, int idkurs, LocalDateTime datoTid) {
        for (PaameldingDTO p : paameldinger) {
            if (p.getPaameldingId() == idPaamelding) {
                // Oppdater feltene (avhengig av hvordan DTO-en din ser ut)
                return true;
            }
        }
        return false;
    }
}