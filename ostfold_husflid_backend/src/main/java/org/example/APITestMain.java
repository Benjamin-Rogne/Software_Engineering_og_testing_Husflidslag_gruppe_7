
package org.example;

import Controllers.KursController;
import Controllers.BrukerController;
import Controllers.NyhetController;
import Controllers.AktivitetController;

import io.javalin.Javalin;
import services.KursServices;
import DTOs.*;
import models.*;

// test for om bruker kan laste info fra dummy DB til javalin interface med DTOs
public class APITestMain {

    public static void main(String[] args) {
        System.out.println("test test");

        // Oppretter Service med dummydata
        KursServices kursServices = new KursServices();

        // Sender Service til Controller
        KursController kursController =
                new KursController(kursServices);

        Javalin app = Javalin.create(config -> {

            // Bruker API
            BrukerController.registerRoutes(config);

            // Henter alle kurs
            config.routes.get(
                    "/api/kurs",
                    kursController::getAllKurs
            );

            // Legger til nytt kurs
            config.routes.post(
                    "/api/kurs",
                    kursController::addKurs
            );

            // Filtrerer kurs etter område og dato
            config.routes.get(
                    "/api/kurs/filter",
                    kursController::filtrerKurs
            );

            // Test av server
            config.routes.get(
                    "/api/test",
                    ctx -> {
                        System.out.println("test fungerer");
                        ctx.result("hei server");
                    }
            );

            config.routes.delete(
                    "/api/kurs/{id}",
                    kursController::slettKurs
            );

            config.routes.put(
                    "/api/kurs/{id}",
                    kursController::redigerKurs
            );


            // NYHETER API

            // Henter alle nyheter
            config.routes.get(
                    "/api/nyheter",
                    NyhetController::getAllNyheter
            );

            // Henter en nyhet
            config.routes.get(
                    "/api/nyheter/{id}",
                    NyhetController::hentNyhet
            );

            // Legger til ny nyhet
            config.routes.post(
                    "/api/nyheter",
                    NyhetController::addNyhet
            );

            // Redigerer nyhet
            config.routes.patch(
                    "/api/nyheter/{id}",
                    NyhetController::oppdaterNyhet
            );

            // Sletter nyhet
            config.routes.delete(
                    "/api/nyheter/{id}",
                    NyhetController::slettNyhet
            );


            // AKTIVITETER API

            // Henter alle aktiviteter
            config.routes.get(
                    "/api/aktiviteter",
                    AktivitetController::getAllAktiviteter
            );

            // Henter en aktivitet
            config.routes.get(
                    "/api/aktiviteter/{id}",
                    AktivitetController::hentAktivitet
            );

            // Legger til ny aktivitet
            config.routes.post(
                    "/api/aktiviteter",
                    AktivitetController::addAktivitet
            );

            // Redigerer aktivitet
            config.routes.patch(
                    "/api/aktiviteter/{id}",
                    AktivitetController::oppdaterAktivitet
            );

            // Sletter aktivitet
            config.routes.delete(
                    "/api/aktiviteter/{id}",
                    AktivitetController::slettAktivitet
            );

        });

        app.start(7000);
        System.out.println("server has started");
    }
}
