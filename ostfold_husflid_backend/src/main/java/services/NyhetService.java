
package services;

import DTOs.NyhetDTO;
import models.Nyhet;
import repositories.NyheterRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NyhetService {

    private final NyheterRepository repository =
            new NyheterRepository();

    // Henter alle nyheter som DTO
    public List<NyhetDTO> getAllNyheter() {

        List<NyhetDTO> nyhetDTOListe = new ArrayList<>();

        for (Nyhet nyhet : repository.hentAlleNyheter()) {

            NyhetDTO dto = new NyhetDTO(
                    nyhet.getNyhet_id(),
                    nyhet.getTittle(),
                    nyhet.getTekst(),
                    nyhet.getBilde(),
                    nyhet.getDate() != null
                            ? nyhet.getDate().toString() : null,
                    nyhet.getOmrade_id(),
                    nyhet.getBrukere_id()
            );

            nyhetDTOListe.add(dto);
        }

        return nyhetDTOListe;
    }

    // Henter en nyhet som DTO
    public NyhetDTO hentNyhet(int id) {

        Nyhet nyhet = repository.hentNyhet(id).orElse(null);

        if (nyhet == null) {
            return null;
        }

        return new NyhetDTO(
                nyhet.getNyhet_id(),
                nyhet.getTittle(),
                nyhet.getTekst(),
                nyhet.getBilde(),
                nyhet.getDate() != null
                        ? nyhet.getDate().toString() : null,
                nyhet.getOmrade_id(),
                nyhet.getBrukere_id()
        );
    }

    // Legger til nyhet
    public void addNyhet(NyhetDTO dto) {

        Nyhet nyhet = new Nyhet(
                dto.getNyhet_id(),
                dto.getTittle(),
                dto.getTekst(),
                dto.getBilde(),
                dto.getDate() != null
                        ? LocalDate.parse(dto.getDate()) : null,
                dto.getOmraade_id(),
                dto.getBrukere_id()
        );

        repository.leggTilNyhet(nyhet);
    }

    // Oppdaterer nyhet
    public boolean oppdaterNyhet(int id, NyhetDTO dto) {

        Nyhet nyhet = repository.hentNyhet(id).orElse(null);

        if (nyhet == null) {
            return false;
        }

        if (dto.getTittle() != null) {
            nyhet.setTittle(dto.getTittle());
        }

        if (dto.getTekst() != null) {
            nyhet.setTekst(dto.getTekst());
        }

        if (dto.getBilde() != null) {
            nyhet.setBilde(dto.getBilde());
        }

        if (dto.getDate() != null) {
            nyhet.setDate(LocalDate.parse(dto.getDate()));
        }

        if (dto.getOmraade_id() != 0) {
            nyhet.setOmraade_id(dto.getOmraade_id());
        }

        if (dto.getBrukere_id() != 0) {
            nyhet.setBrukere_id(dto.getBrukere_id());
        }

        repository.oppdaterNyhet(id, nyhet);

        return true;
    }

    // Sletter nyhet
    public boolean slettNyhet(int id) {

        if (repository.hentNyhet(id).isEmpty()) {
            return false;
        }

        repository.slettNyhet(id);
        return true;
    }
}
