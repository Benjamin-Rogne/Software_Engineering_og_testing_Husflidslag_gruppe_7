package org.example;

import io.javalin.Javalin;
import Controllers.*;

public class TestMain {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.routes.get(
                    "/api/bruker",
                    BrukerController::hentBruker
            );
                    KursController kursController = new KursController();

            config.routes.get(
                    "/api/kurs",
                    kursController::getAllKurs
            );


        });

        app.start(7000);
    }
}