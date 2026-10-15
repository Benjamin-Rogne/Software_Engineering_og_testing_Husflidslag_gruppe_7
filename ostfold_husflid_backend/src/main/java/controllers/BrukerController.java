package controllers;

/*import io.javalin.config.JavalinConfig;

public class BrukerController {

    public static void registerRoutes(JavalinConfig config) {

        config.routes.get("/api/brukere", ctx -> {
            ctx.result("Her skal brukerne hentes!");
        });

    }
}
 */


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