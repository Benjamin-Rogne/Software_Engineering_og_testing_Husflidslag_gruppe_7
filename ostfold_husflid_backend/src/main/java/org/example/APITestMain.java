package org.example;

import io.javalin.Javalin;
import Controllers.BrukerController;

// test for om bruker kan laste info fra dummy DB til javalin interface med DTOs
public class APITestMain {

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            BrukerController.registerRoutes(config);
        });

        app.start(7000);
    }
}
