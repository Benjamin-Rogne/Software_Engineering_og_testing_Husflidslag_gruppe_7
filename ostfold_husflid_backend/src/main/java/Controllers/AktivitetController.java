
package Controllers;

import DTOs.AktivitetDTO;
import io.javalin.http.Context;
import services.AktivitetService;

public class AktivitetController {

    private static final AktivitetService aktivitetService =
            new AktivitetService();

    // Henter alle aktiviteter
    public static void getAllAktiviteter(Context ctx) {
        ctx.json(aktivitetService.getAllAktiviteter());
    }

    // Henter en aktivitet
    public static void hentAktivitet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));

        AktivitetDTO aktivitet = aktivitetService.hentAktivitet(id);

        if (aktivitet != null) {
            ctx.json(aktivitet);
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }

    // Legger til aktivitet
    public static void addAktivitet(Context ctx) {

        AktivitetDTO dto = ctx.bodyAsClass(AktivitetDTO.class);

        aktivitetService.addAktivitet(dto);

        ctx.status(201).result("Aktivitet lagt til");
    }

    // Oppdaterer aktivitet
    public static void oppdaterAktivitet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));
        AktivitetDTO dto = ctx.bodyAsClass(AktivitetDTO.class);

        if (aktivitetService.oppdaterAktivitet(id, dto)) {
            ctx.status(200).result("Aktivitet oppdatert");
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }

    // Sletter aktivitet
    public static void slettAktivitet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));

        if (aktivitetService.slettAktivitet(id)) {
            ctx.status(200).result("Aktivitet slettet");
        } else {
            ctx.status(404).result("Aktivitet finnes ikke");
        }
    }
}
