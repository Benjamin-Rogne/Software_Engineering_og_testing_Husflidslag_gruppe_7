package Services;
import org.junit.jupiter.api.Test;
import DTOs.KursDto2;
import static org.junit.jupiter.api.Assertions.*;
import services.KursServices;
import models.Kurs;

public class KursServiceTest {

    KursServices service = new KursServices();
    //integrasjion test med database tester om den kan printe ut alle kurs
    @Test
    void testGetAllKurs() {

        var kursListe = service.getAllKurs();

        assertNotNull(kursListe);

        //printer ikke nødvendige verdier men rare verdier
        /*for (KursDto2 kurs : kursListe) {System.out.println(kurs);*/

        for (KursDto2 kurs : kursListe) {
            System.out.println("Tittel: " + kurs.getTittle());
            System.out.println("Pris: " + kurs.getPris());
            System.out.println("Område: " + kurs.getOmraade_id());
            System.out.println("----------------------");
        }
    }
    //integrasjion test med database tester filtrering av kurs område
    @Test
    void testFiltrerKursEtterOmraade() {

        String omraade_id = "2";

        var kursListe = service.filtrerKurs(omraade_id, null);

        assertNotNull(kursListe);
        assertFalse(kursListe.isEmpty());

        for (KursDto2 kurs : kursListe) {

            assertEquals(2, kurs.getOmraade_id());

            System.out.println("Tittel: " + kurs.getTittle());
            System.out.println("Pris: " + kurs.getPris());
            System.out.println("Område: " + kurs.getOmraade_id());
            System.out.println("----------------------");
        }
    }
}