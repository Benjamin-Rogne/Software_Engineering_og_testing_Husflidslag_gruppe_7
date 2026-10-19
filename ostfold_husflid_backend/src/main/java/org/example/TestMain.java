package org.example;

import io.javalin.Javalin;
import Controllers.BrukerController;

public class TestMain {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.routes.get(
                    "/api/bruker",
                    BrukerController::hentBruker
            );
        });

        app.start(7000);
    }
}