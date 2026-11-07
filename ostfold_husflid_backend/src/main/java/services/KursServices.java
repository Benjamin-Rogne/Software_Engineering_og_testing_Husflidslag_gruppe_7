package services;
import DTOs.KursDto2;
import models.Kurs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Database.DummyDatabase;

public class KursServices {
    private final List<Kurs> kursListe = DummyDatabase.kursListe;

    //objekter for kursliste dummydata


    /*fungerer så lenge serveren eller koden er aktiv, vil bli tom ver gang man starter om server
     legger til kurs fra json
    201 betyr att en objekt har blitt created
    ctx betyr forspørsel og svar
    body as class = json fra frontend om til et java objekt*/
    public KursDto2 addKurs(Kurs nyttKurs) {
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

        for (Kurs kurs : kursListe) {

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

    public KursDto2 redigerKurs(int kursId, Kurs oppdatertKurs) {

        for (Kurs kurs : kursListe) {

            if (kurs.getKurs_id() == kursId) {

                kurs.setTittle(oppdatertKurs.getTittle());
                kurs.setStart_dato(oppdatertKurs.getStart_dato());
                kurs.setSlutt_dato(oppdatertKurs.getSlutt_dato());
                kurs.setPris(oppdatertKurs.getPris());
                kurs.setOmraade_id(oppdatertKurs.getOmraade_id());
                kurs.setKursholder_id(oppdatertKurs.getKursholder_id());
                kurs.setAdresse_id(oppdatertKurs.getAdresse_id());

                return new KursDto2(kurs);
            }
        }

        return null;
    }

}
