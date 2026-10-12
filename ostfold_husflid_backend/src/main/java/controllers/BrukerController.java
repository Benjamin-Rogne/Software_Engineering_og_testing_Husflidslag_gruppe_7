package controllers;

import io.javalin.config.JavalinConfig;

public class BrukerController {

    public static void registerRoutes(JavalinConfig config) {

        config.routes.get("/api/brukere", ctx -> {
            ctx.result("Her skal brukerne hentes!");
        });

    }
}
