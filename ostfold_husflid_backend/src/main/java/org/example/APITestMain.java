package org.example;
import Controllers.KursController;
import io.javalin.Javalin;
import Controllers.BrukerController;
import services.KursServices;

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

        });

        app.start(7000);
        System.out.println("server has started");
    }
}
