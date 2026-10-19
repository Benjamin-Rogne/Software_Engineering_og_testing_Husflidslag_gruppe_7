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
import services.BrukerService;

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
}