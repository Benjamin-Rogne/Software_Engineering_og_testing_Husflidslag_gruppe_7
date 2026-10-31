package Controllers;
import java.util.Map;

import DTOs.KursDto2;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import models.Kursklasse;
import services.KursServices;
public class KursController {
    private final KursServices kursServices;

    public KursController(KursServices kursServices) {
        this.kursServices = kursServices;
    }

    public void getAllKurs(Context ctx) {
        ctx.json(kursServices.getAllKurs());
    }

    public void addKurs(Context ctx) {
        Kursklasse nyttKurs = ctx.bodyAsClass(Kursklasse.class);

        ctx.status(201);
        ctx.json(kursServices.addKurs(nyttKurs));
    }

    public void filtrerKurs(Context ctx) {

        String omraade = ctx.queryParam("område");
        String dato = ctx.queryParam("dato");

        try {
            ctx.json(kursServices.filtrerKurs(omraade, dato));
        } catch (IllegalArgumentException e) {
            ctx.status(400).result("Ugyldig område eller dato");
        }
    }
    public void slettKurs(Context ctx) {

        int kursId = Integer.parseInt(ctx.pathParam("id"));

        boolean slettet = kursServices.slettKurs(kursId);

        if (slettet) {
            ctx.status(204);
        } else {
            ctx.status(404);
            ctx.result("Kurset existerer ikke");
        }
    }

    public void redigerKurs(Context ctx) {

        int kursId = Integer.parseInt(ctx.pathParam("id"));

        Kursklasse oppdatertKurs =
                ctx.bodyAsClass(Kursklasse.class);

        KursDto2 resultat =
                kursServices.redigerKurs(kursId, oppdatertKurs);

        if (resultat != null) {
            ctx.status(200);
            ctx.json(resultat);
        } else {
            ctx.status(404);
            ctx.result("Kurset existerer ikke");
        }
    }


}

