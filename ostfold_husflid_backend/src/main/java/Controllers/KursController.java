package Controllers;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import models.Kursklasse;
public class KursController {
    private ArrayList<Kursklasse> kursListe = new ArrayList<>();

    //objekter for kursliste dummydata
    public KursController() {

        // Kurs 1 - Halden
        kursListe.add(new Kursklasse(
                1,
                "Strikkekurs",
                LocalDateTime.of(2026, 11, 20, 10, 0),
                LocalDateTime.of(2026, 11, 20, 14, 0),
                250.0f,
                1,
                1,
                0,
                "Storgata 10, Halden"
        ));

        // Kurs 2 - Fredrikstad
        kursListe.add(new Kursklasse(
                2,
                "Malekurs",
                LocalDateTime.of(2026, 12, 5, 12, 0),
                LocalDateTime.of(2026, 12, 5, 16, 0),
                300.0f,
                2,
                1,
                0,
                "Sentrum, Fredrikstad"
        ));

        // Kurs 3 - Sarpsborg
        kursListe.add(new Kursklasse(
                3,
                "Sykurs",
                LocalDateTime.of(2026, 12, 10, 9, 0),
                LocalDateTime.of(2026, 12, 10, 13, 0),
                200.0f,
                3,
                2,
                0,
                "Sentrum, Sarpsborg"));
                kursListe.add(new Kursklasse(
                        4,
                        "Treskjæringskurs",
                        LocalDateTime.of(2026, 12, 15, 10, 0),
                        LocalDateTime.of(2026, 12, 15, 15, 0),
                        350.0f,
                        4,
                        2,
                        0,
                        "Moss sentrum"
                ));

// Kurs 5 - Fredrikstad
        kursListe.add(new Kursklasse(
                5,
                "Keramikkurs",
                LocalDateTime.of(2026, 12, 18, 11, 0),
                LocalDateTime.of(2026, 12, 18, 16, 0),
                450.0f,
                2,
                1,
                0,
                "Fredrikstad sentrum"
        ));
    }
    /*fungerer så lenge serveren eller koden er aktiv, vil bli tom ver gang man starter om server
     legger til kurs fra json
    201 betyr att en objekt har blitt created
    ctx betyr forspørsel og svar
    body as class = json fra frontend om til et java objekt*/
    public void addKurs(Context ctx){
        Kursklasse nyttKurs = ctx.bodyAsClass(Kursklasse.class);
        kursListe.add(nyttKurs);

        ctx.status(201);
        ctx.json(nyttKurs);
    }
    // henter alle kurs og koverterer til json
    public void getAllKurs (Context ctx){

        ctx.json(kursListe);
    }
    //kursfiltrering med dato og område
    public void filtrerKurs(Context ctx){
        String omraade_id = ctx.queryParam("område");
        String dato = ctx.queryParam("dato");
        ArrayList<Kursklasse> resultat = new ArrayList<>();
        for (Kursklasse K : kursListe){
            boolean rOmraade = omraade_id == null || K.getOmraade_id() == Integer.parseInt(omraade_id);
            boolean rDato = dato == null || K.getStart_dato().equals(LocalDate.parse(dato));
            if (rDato && rOmraade) {

                resultat.add(K);
            }
        }
    }

}

