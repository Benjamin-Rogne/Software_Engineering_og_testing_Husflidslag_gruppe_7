
package Controllers;

import DTOs.KursDto2;
import io.javalin.http.Context;
import models.Kurs;
import services.KursServices;

import java.util.List;

public class KursController {

    // Kobling mellom KursController og KursServices
    private final KursServices kursServices;

    // Mottar KursServices fra APITestMain
    public KursController(KursServices kursServices) {
        this.kursServices = kursServices;
    }

    /*
      Henter alle kurs fra KursServices.
      ctx betyr forespørsel og svar.
      ctx.json konverterer resultatet til JSON
      som sendes videre til frontend.
     */
    public void getAllKurs(Context ctx) {

        List<KursDto2> kursListe =
                kursServices.getAllKurs();

        ctx.json(kursListe);
    }

    /*
      Legger til et nytt kurs fra JSON.
      bodyAsClass konverterer JSON fra frontend
      til et Java-objekt av typen Kurs.
      Sender objektet videre til KursServices,
      som legger det til i kurslisten.
      201 betyr at et nytt objekt har blitt opprettet.
     */
    public void addKurs(Context ctx) {

        Kurs nyttKurs = ctx.bodyAsClass(Kurs.class);

        KursDto2 resultat =
                kursServices.addKurs(nyttKurs);

        ctx.status(201);
        ctx.json(resultat);
    }

    /*
      Kursfiltrering med dato og område.
      Henter verdiene fra URL-en med queryParam.
      Hvis område eller dato ikke er oppgitt,
      filtrerer vi ikke på den verdien.
      Sender verdiene videre til KursServices.
     */
    public void filtrerKurs(Context ctx) {

        String omraade_id = ctx.queryParam("område");
        String dato = ctx.queryParam("dato");

        try {

            List<KursDto2> resultat =
                    kursServices.filtrerKurs(omraade_id, dato);

            ctx.json(resultat);

        } catch (IllegalArgumentException e) {

            // 400 betyr ugyldig forespørsel
            ctx.status(400);
            ctx.result("Ugyldig område eller dato");
        }
    }

    /*
      Sletter et kurs basert på kurs-ID.
      pathParam henter ID fra URL-en.
      Sender ID videre til KursServices,
      som finner og sletter kurset.
      204 betyr at kurset ble slettet.
      404 betyr at kurset ikke finnes.
      400 betyr at kurs-ID er ugyldig.
     */
    public void slettKurs(Context ctx) {

        try {

            int kursId = Integer.parseInt(
                    ctx.pathParam("id"));

            boolean slettet =
                    kursServices.slettKurs(kursId);

            if (slettet) {

                ctx.status(204);

            } else {

                ctx.status(404);
                ctx.result("Fant ikke kurset");
            }

        } catch (NumberFormatException e) {

            ctx.status(400);
            ctx.result("Ugyldig kurs-ID");
        }
    }

    /* Redigerer et eksisterende kurs.
      Henter kurs-ID fra URL-en.
      bodyAsClass konverterer JSON fra frontend
      til et Java-objekt av typen Kurs.
      Sender kurs-ID og det oppdaterte objektet
      videre til KursServices.
      Returnerer oppdatert kurs som JSON.
      404 betyr at kurset ikke finnes.
      400 betyr at kurs-ID er ugyldig.
     */
    public void redigerKurs(Context ctx) {

        try {

            int kursId = Integer.parseInt(
                    ctx.pathParam("id"));

            Kurs oppdatertKurs =
                    ctx.bodyAsClass(Kurs.class);

            KursDto2 resultat =
                    kursServices.redigerKurs(
                            kursId, oppdatertKurs);

            if (resultat != null) {

                ctx.json(resultat);

            } else {

                ctx.status(404);
                ctx.result("Fant ikke kurset");
            }

        } catch (NumberFormatException e) {

            ctx.status(400);
            ctx.result("Ugyldig kurs-ID");
        }
    }
}


