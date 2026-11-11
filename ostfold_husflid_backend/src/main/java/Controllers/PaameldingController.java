package controllers;

import DTOs.PaameldingDTO;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import repositories.PaameldingRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PaameldingController {
    private PaameldingRepository paameldingRepository;

    // Konstruktør for Dependency Injection
    public PaameldingController(PaameldingRepository paameldingRepository) {
        this.paameldingRepository = paameldingRepository;
    }

    public static void registerRoutes(JavalinConfig config) {
        // Merk: Vi bruker instansmetoder via en lambda/kontroller-instans i Application.java,
        // eller vi kan koble opp rutene slik Javalin forventer det.
    }

    //Hente alle påmeldinger
    public void hentAllePaameldinger(Context ctx) {
        List<PaameldingDTO> paameldinger = paameldingRepository.hentAllePaameldinger();
        ctx.json(paameldinger);
    }

    //Sjekke om en bruker er påmeldt et gitt kurs (eller hente påmelding for ID)
    public void erBrukerPaameldt(Context ctx) {
        try {
            int brukerId = Integer.parseInt(ctx.queryParam("brukerId"));
            int kursId = Integer.parseInt(ctx.queryParam("kursId"));

            boolean paameldt = paameldingRepository.erBrukerPaameldt(brukerId, kursId);
            ctx.json(paameldt);
        } catch (Exception e) {
            ctx.status(400).result("Ugyldige parametere for sjekk av påmelding");
        }
    }

    // Legge til ny påmelding
    public void leggTilPaamelding(Context ctx) {
        try {
            PaameldingDTO nyPaamelding = ctx.bodyAsClass(PaameldingDTO.class);

            boolean vellykket = paameldingRepository.leggTilPaamelding(
                    nyPaamelding.getBrukerId(),
                    nyPaamelding.getKursId(),
                    nyPaamelding.getAktivitetId()
            );

            if (vellykket) {
                ctx.status(201).result("Påmelding vellykket!");
            } else {
                ctx.status(400).result("Kunne ikke fullføre påmelding.");
            }
        } catch (Exception e) {
            ctx.status(400).result("Feil ved parsing av påmeldingsdata: " + e.getMessage());
        }
    }

    //Oppdatere påmelding
    public void oppdaterPaamelding(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PaameldingDTO dto = ctx.bodyAsClass(PaameldingDTO.class);

            boolean oppdatert = paameldingRepository.oppdaterPaamelding(
                    id,
                    dto.getBrukerId(),
                    dto.getKursId(),
                    dto.getDatoTid()
            );

            if (oppdatert) {
                ctx.status(200).result("Påmelding oppdatert");
            } else {
                ctx.status(404).result("Fant ikke påmeldingen");
            }
        } catch (Exception e) {
            ctx.status(400).result("Ugyldig forespørsel ved oppdatering");
        }
    }

    // Slette påmelding
    public void slettPaamelding(Context ctx) {
        try {
            int idBruker = Integer.parseInt(ctx.queryParam("brukerId"));
            int idKurs = Integer.parseInt(ctx.queryParam("kursId"));

            boolean slettet = paameldingRepository.slettPaamelding(idBruker, idKurs);

            if (slettet) {
                ctx.status(204); // Ingen innhold, vellykket sletting
            } else {
                ctx.status(404).result("Fant ikke påmeldingen som skulle slettes");
            }
        } catch (Exception e) {
            ctx.status(400).result("Ugyldige parametere for avmelding");
        }
    }
}