package org.example;
import Controllers.KursController;
import io.javalin.Javalin;
import Controllers.BrukerController;

// test for om bruker kan laste info fra dummy DB til javalin interface med DTOs
public class APITestMain {

    public static void main(String[] args) {
        System.out.println("test test");

        KursController kursController = new KursController();
        Javalin app = Javalin.create(config -> {
            BrukerController.registerRoutes(config);
            config.routes.get(
                    "/api/kurs",
                    kursController::getAllKurs
            );
            config.routes.get(
                    "/api/test",ctx -> {System.out.println("test fungerer");
                        ctx.result("hei server");
                    }
            );

        });


        app.start(7000);
        System.out.println("server has started");
    }
}
