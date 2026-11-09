
package Controllers;

import DTOs.NyhetDTO;
import io.javalin.http.Context;
import services.NyhetService;

public class NyhetController {

    private static final NyhetService nyhetService =
            new NyhetService();

    // Henter alle nyheter
    public static void getAllNyheter(Context ctx) {
        ctx.json(nyhetService.getAllNyheter());
    }

    // Henter en nyhet
    public static void hentNyhet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));

        NyhetDTO nyhet = nyhetService.hentNyhet(id);

        if (nyhet != null) {
            ctx.json(nyhet);
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }

    // Legger til nyhet
    public static void addNyhet(Context ctx) {

        NyhetDTO dto = ctx.bodyAsClass(NyhetDTO.class);

        nyhetService.addNyhet(dto);

        ctx.status(201).result("Nyhet lagt til");
    }

    // Oppdaterer nyhet
    public static void oppdaterNyhet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));
        NyhetDTO dto = ctx.bodyAsClass(NyhetDTO.class);

        if (nyhetService.oppdaterNyhet(id, dto)) {
            ctx.status(200).result("Nyhet oppdatert");
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }

    // Sletter nyhet
    public static void slettNyhet(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));

        if (nyhetService.slettNyhet(id)) {
            ctx.status(200).result("Nyhet slettet");
        } else {
            ctx.status(404).result("Nyhet finnes ikke");
        }
    }
}
