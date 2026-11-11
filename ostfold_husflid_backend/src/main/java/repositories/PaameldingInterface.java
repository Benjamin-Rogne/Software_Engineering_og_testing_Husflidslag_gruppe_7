package repositories;

import DTOs.PaameldingDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface PaameldingInterface {
    boolean leggTilPaamelding(int idbruker, int idkurs, int aktivitet_id);
    List<PaameldingDTO> hentAllePaameldinger();
    boolean erBrukerPaameldt(int idBruker, int idKurs);
    boolean slettPaamelding(int idbruker, int idkurs);
    boolean oppdaterpaamelding(int idPaamelding, int idbruker, int idkurs, LocalDateTime datoTid);
}