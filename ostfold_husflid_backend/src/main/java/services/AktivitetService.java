
package services;

import DTOs.AktivitetDTO;
import models.Aktiviteter;
import repositories.AktiviteterRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AktivitetService {

    private final AktiviteterRepository repository =
            new AktiviteterRepository();

    // Henter alle aktiviteter som DTO
    public List<AktivitetDTO> getAllAktiviteter() {

        List<AktivitetDTO> aktivitetDTOListe = new ArrayList<>();

        for (Aktiviteter aktivitet : repository.hentAlleAktiviteter()) {

            AktivitetDTO dto = new AktivitetDTO(
                    aktivitet.getAktivitet_id(),
                    aktivitet.getTittel(),
                    aktivitet.getBilde(),
                    aktivitet.getBeskrivelse(),
                    aktivitet.getDato() != null
                            ? aktivitet.getDato().toString() : null,
                    aktivitet.getOmraade_id()
            );

            aktivitetDTOListe.add(dto);
        }

        return aktivitetDTOListe;
    }

    // Henter en aktivitet som DTO
    public AktivitetDTO hentAktivitet(int id) {

        Aktiviteter aktivitet = repository.hentAktivitet(id).orElse(null);

        if (aktivitet == null) {
            return null;
        }

        return new AktivitetDTO(
                aktivitet.getAktivitet_id(),
                aktivitet.getTittel(),
                aktivitet.getBilde(),
                aktivitet.getBeskrivelse(),
                aktivitet.getDato() != null
                        ? aktivitet.getDato().toString() : null,
                aktivitet.getOmraade_id()
        );
    }

    // Legger til aktivitet
    public void addAktivitet(AktivitetDTO dto) {

        Aktiviteter aktivitet = new Aktiviteter(
                dto.getAktivitet_id(),
                dto.getTittle(),
                dto.getBilde(),
                dto.getBeskrivelse(),
                dto.getDato() != null
                        ? LocalDate.parse(dto.getDato()) : null,
                dto.getOmraade_id()
        );

        repository.leggTilAktivitet(aktivitet);
    }

    // Oppdaterer aktivitet
    public boolean oppdaterAktivitet(int id, AktivitetDTO dto) {

        Aktiviteter aktivitet = repository.hentAktivitet(id).orElse(null);

        if (aktivitet == null) {
            return false;
        }

        if (dto.getTittle() != null) {
            aktivitet.setTittel(dto.getTittle());
        }

        if (dto.getBilde() != null) {
            aktivitet.setBilde(dto.getBilde());
        }

        if (dto.getBeskrivelse() != null) {
            aktivitet.setBeskrivelse(dto.getBeskrivelse());
        }

        if (dto.getDato() != null) {
            aktivitet.setDato(LocalDate.parse(dto.getDato()));
        }

        if (dto.getOmraade_id() != 0) {
            aktivitet.setOmraade_id(dto.getOmraade_id());
        }

        repository.oppdaterAktivitet(id, aktivitet);

        return true;
    }

    // Sletter aktivitet
    public boolean slettAktivitet(int id) {

        if (repository.hentAktivitet(id).isEmpty()) {
            return false;
        }

        repository.slettAktivitet(id);
        return true;
    }
}
