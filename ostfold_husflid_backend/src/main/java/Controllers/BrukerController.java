/*package controllers;

import io.javalin.config.JavalinConfig;

public class BrukerController {

    public static void registerRoutes(JavalinConfig config) {

        config.routes.get("/api/brukere", ctx -> {
            ctx.result("Her skal brukerne hentes!");
        });

    }
}



import DTOs.BrukerDTO;
import io.javalin.http.Context;
import io.javalin.config.JavalinConfig;

public class BrukerController {

    public static void registerRoutes(JavalinConfig config) {
        config.routes.get("/api/bruker", BrukerController::hentBruker);
    }

    public static void hentBruker(Context ctx) {
        BrukerDTO bruker = new BrukerDTO(
                1,
                "Ola Nordmann",
                "ola@epost.no"
        );

        ctx.json(bruker);
    }
}
*/

package Controllers;

import DTOs.BrukerDTO;
import DTOs.OpprettBrukerDTO;
import services.BrukerService;
import DTOs.OppdaterBrukerDTO;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;

import java.util.Optional;

// definerer path til Bruker data og sender ut dataen
public class BrukerController {

    private static final BrukerService service =
            new BrukerService();

    public static void registerRoutes(JavalinConfig config) {

        config.routes.get(
                "/api/brukere",
                BrukerController::hentAlleBrukere
        );

        config.routes.get(
                "/api/brukere/{id}",
                BrukerController::hentBruker
        );
        config.routes.post(
                "/api/brukere",
                BrukerController::opprettBruker
        );
        config.routes.put(
                "/api/brukere/{id}",
                BrukerController::oppdaterBruker
        );

        config.routes.delete(
                "/api/brukere/{id}",
                BrukerController::slettBruker
        );
    }

    public static void hentAlleBrukere(Context ctx) {
        ctx.json(service.hentAlleBrukere());
    }

    public static void hentBruker(Context ctx) {

        int id;

        try {
            id = Integer.parseInt(ctx.pathParam("id"));
        } catch (NumberFormatException e) {
            ctx.status(400).result("Ugyldig bruker-ID");
            return;
        }

        Optional<BrukerDTO> bruker =
                service.hentBruker(id);

        if (bruker.isPresent()) {
            ctx.json(bruker.get());
        } else {
            ctx.status(404).result("Bruker finnes ikke");
        }

    }
    public static void opprettBruker(Context ctx) {

        try {
            OpprettBrukerDTO dto =
                    ctx.bodyAsClass(OpprettBrukerDTO.class);

            BrukerDTO opprettet =
                    service.opprettBruker(dto);

            ctx.status(201).json(opprettet);

        } catch (IllegalArgumentException e) {
            ctx.status(400).result(e.getMessage());
        }
    }
    public static void oppdaterBruker(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        OppdaterBrukerDTO dto =
                ctx.bodyAsClass(OppdaterBrukerDTO.class);

        service.oppdaterBruker(id, dto)
                .ifPresentOrElse(
                        bruker -> ctx.json(bruker),
                        () -> ctx.status(404)
                );
    }

    public static void slettBruker(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if (service.slettBruker(id)) {
            ctx.status(204);
        } else {
            ctx.status(404);
        }
    }
}