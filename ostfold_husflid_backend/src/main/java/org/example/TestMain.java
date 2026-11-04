package org.example;

import Database.DatabaseConnection;
import io.javalin.Javalin;
import Controllers.*;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMain {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Tilkobling vellykket!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Javalin app = Javalin.create(config -> {
            config.routes.get(
                    "/api/bruker",
                    BrukerController::hentBruker
            );
                    /*KursController kursController = new KursController();

            config.routes.get(
                    "/api/kurs",
                    kursController::getAllKurs
            );*/


        });

        app.start(7000);
    }
}