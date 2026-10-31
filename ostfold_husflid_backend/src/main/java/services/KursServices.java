package services;
import DTOs.KursDto2;
import io.javalin.http.Context;
import models.Kursklasse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class KursServices {
    private ArrayList<Kursklasse> kursListe = new ArrayList<>();

    //objekter for kursliste dummydata
    public KursServices() {

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
    public KursDto2 addKurs(Kursklasse nyttKurs) {
        kursListe.add(nyttKurs);
        return new KursDto2(nyttKurs);
    }


    // henter alle kurs og koverterer til json
    /*public void getAllKurs (Context ctx){
        System.out.println("getAllKurs blir kjørt!");
        System.out.println("Antall kurs: " + kursListe.size());

        ctx.json(kursListe);
    }*/
    //ai får å finne test feil
    public List<KursDto2> getAllKurs() {
        return kursListe.stream()
                .map(KursDto2::new)
                .toList();
    }
    public boolean slettKurs(int kursId) {
        return kursListe.removeIf(
                kurs -> kurs.getKurs_id() == kursId
        );
    }
    //kursfiltrering med dato og område
    public List<KursDto2> filtrerKurs(String omraade_id, String dato) {

        ArrayList<KursDto2> resultat = new ArrayList<>();

        for (Kursklasse kurs : kursListe) {

            boolean rOmraade = omraade_id == null ||
                    kurs.getOmraade_id() == Integer.parseInt(omraade_id);

            boolean rDato = dato == null ||
                    kurs.getStart_dato().toLocalDate()
                            .equals(LocalDate.parse(dato));

            if (rDato && rOmraade) {
                resultat.add(new KursDto2(kurs));
            }

        }

        return resultat;
    }

    public KursDto2 redigerKurs(int kursId, Kursklasse oppdatertKurs) {

        for (Kursklasse kurs : kursListe) {

            if (kurs.getKurs_id() == kursId) {

                kurs.setTittle(oppdatertKurs.getTittle());
                kurs.setStart_dato(oppdatertKurs.getStart_dato());
                kurs.setSlutt_dato(oppdatertKurs.getSlutt_dato());
                kurs.setPris(oppdatertKurs.getPris());
                kurs.setOmraade_id(oppdatertKurs.getOmraade_id());
                kurs.setKursholder_id(oppdatertKurs.getKursholder_id());
                kurs.setAdresse(oppdatertKurs.getAdresse());

                return new KursDto2(kurs);
            }
        }

        return null;
    }

}
