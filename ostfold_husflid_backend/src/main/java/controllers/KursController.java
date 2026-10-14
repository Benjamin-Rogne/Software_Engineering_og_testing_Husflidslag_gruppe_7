package controllers;
import io.javalin.http.Context;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Kursklasse;

public class KursController {
    private ArrayList<Kursklasse> kursListe = new ArrayList<>();

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
}
