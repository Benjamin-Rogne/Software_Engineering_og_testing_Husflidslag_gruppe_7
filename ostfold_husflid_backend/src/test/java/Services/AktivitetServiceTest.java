package Services;
import org.junit.jupiter.api.Test;
import services.AktivitetService;
import static org.junit.jupiter.api.Assertions.*;
public class AktivitetServiceTest {

    AktivitetService service = new AktivitetService();
    @Test
    void testHentAktivitetFinnesIkke() {

        int id = -1;

        assertNull(service.hentAktivitet(id));

        System.out.println("Test bestått: Aktiviteten finnes ikke");
    }

    @Test
    void testSlettAktivitetFinnesIkke() {

        int id = -1;

        boolean resultat = service.slettAktivitet(id);

        assertFalse(resultat);

        System.out.println("Test bestått: Aktiviteten kunne ikke slettes");
    }
}