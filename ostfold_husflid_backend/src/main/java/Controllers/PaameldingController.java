package controllers;

import DTOs.PaameldingDTO;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import repositories.PaameldingRepository;

import java.sql.*;
import java.util.List;

public class PaameldingController {
    private static PaameldingRepository paameldingRepository;

    // Konstruktør for Dependency Injection
    public PaameldingController(PaameldingRepository paameldingRepository) {
        this.paameldingRepository = paameldingRepository;
    }

    public static void registerRoutes(JavalinConfig config) {
        config.routes.get(
                "/api/påmelding",
                PaameldingController::hentAllePaameldinger
        );

        config.routes.get(
                "/api/påmelding/sjekk",
                PaameldingController::erBrukerPaameldt
        );

        config.routes.post(
                "/api/påmelding",
                PaameldingController::leggTilPaamelding
        );

        config.routes.put(
                "/api/påmelding/{id}",
                PaameldingController::oppdaterPaamelding
        );

        config.routes.delete(
                "/api/påmelding",
                PaameldingController::slettPaamelding
        );
    }


    //Hente alle påmeldinger
    public static void hentAllePaameldinger(Context ctx) {
        try {
            List<PaameldingDTO> paameldinger = paameldingRepository.hentAllePaameldinger();
            ctx.json(paameldinger);
        } catch (Exception e) {
            ctx.status(500).result("Kunne ikke hente påmeldinger: " + e.getMessage());
        }
    }

    public static void erBrukerPaameldt(Context ctx) {
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
    public static void leggTilPaamelding(Context ctx) {
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
    public static void oppdaterPaamelding(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            PaameldingDTO dto = ctx.bodyAsClass(PaameldingDTO.class);

            boolean oppdatert = paameldingRepository.oppdaterpaamelding(
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
    public static void slettPaamelding(Context ctx) {
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
