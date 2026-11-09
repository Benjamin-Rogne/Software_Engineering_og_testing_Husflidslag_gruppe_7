
package Controllers;

import io.javalin.http.Context;
import models.Aktiviteter;
import services.AktivitetService;

public class AktivitetController {

    private static final AktivitetService aktivitetService = new AktivitetService();

    public static void getAllAktiviteter(Context ctx) {
        ctx.json(aktivitetService.getAllAktiviteter());
    }

    public static void hentAktivitet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Aktiviteter aktivitet = aktivitetService.hentAktivitet(id);

        if (aktivitet != null) {
            ctx.json(aktivitet);
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }

    public static void addAktivitet(Context ctx) {
        Aktiviteter aktivitet = ctx.bodyAsClass(Aktiviteter.class);
        aktivitetService.addAktivitet(aktivitet);
        ctx.status(201).json(aktivitet);
    }

    public static void oppdaterAktivitet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Aktiviteter aktivitet = ctx.bodyAsClass(Aktiviteter.class);

        if (aktivitetService.oppdaterAktivitet(id, aktivitet)) {
            ctx.status(200).json(aktivitet);
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }

    public static void slettAktivitet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if (aktivitetService.slettAktivitet(id)) {
            ctx.status(200).result("Aktivitet slettet");
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }
}
