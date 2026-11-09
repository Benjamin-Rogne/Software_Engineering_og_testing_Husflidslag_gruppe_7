
package Controllers;

import io.javalin.http.Context;
import models.Nyhet;
import services.NyhetService;

public class NyhetController {

    private static final NyhetService nyhetServices = new NyhetService();

    public static void getAllNyheter(Context ctx) {
        ctx.json(nyhetServices.getAllNyheter());
    }

    public static void hentNyhet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Nyhet nyhet = nyhetServices.hentNyhet(id);

        if (nyhet != null) {
            ctx.json(nyhet);
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }

    public static void addNyhet(Context ctx) {
        Nyhet nyhet = ctx.bodyAsClass(Nyhet.class);
        nyhetServices.addNyhet(nyhet);
        ctx.status(201).json(nyhet);
    }

    public static void oppdaterNyhet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Nyhet nyhet = ctx.bodyAsClass(Nyhet.class);

        if (nyhetServices.oppdaterNyhet(id, nyhet)) {
            ctx.status(200).json(nyhet);
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }

    public static void slettNyhet(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        if (nyhetServices.slettNyhet(id)) {
            ctx.status(200).result("Nyhet slettet");
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }
}
