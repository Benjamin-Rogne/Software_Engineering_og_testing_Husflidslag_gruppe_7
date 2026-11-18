package Services;
import services.NyhetService;
import DTOs.NyhetDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NyhetServiceTest {

    NyhetService service = new NyhetService();
    // delvis integrasjion tester om den kan oppdatere nyhet men den er koblet til repository men ikke database
    @Test
    void testOppdaterNyhet() {

        int nyhet_id = 1;

        NyhetDTO dto = new NyhetDTO();

        dto.setTittle("oppdatert nyhet");
        dto.setTekst("dette er en oppdatert tekst");

        boolean resultat = service.oppdaterNyhet(nyhet_id, dto);
        assertTrue(resultat);

        System.out.println("nyheten ble oppdatert: " + resultat);
    }

    //ikke tilknyttet til database derfor oppdaterer den ikke i databasen men den oppdaterer bare når man kjører
    //kan endre på databasen om den er tilkoblet
    //delvis integrasjion
    @Test
    void testOppdaterOgHentNyhet() {
        int nyhet_id = 1;
        NyhetDTO original = service.hentNyhet(nyhet_id);
        assertNotNull(original);

        System.out.println("før nyhet oppdatering:");
        System.out.println("Tittel: " + original.getTittle());
        System.out.println("Tekst: " + original.getTekst());

        NyhetDTO dto = new NyhetDTO();
        dto.setTittle("Oppdatert nyhet");
        dto.setTekst("Dette er en oppdatert tekst");
        boolean resultat = service.oppdaterNyhet(nyhet_id, dto);
        assertTrue(resultat);

        NyhetDTO oppdatert = service.hentNyhet(nyhet_id);

        assertNotNull(oppdatert);

        System.out.println("etter oppdatering:");
        System.out.println("Tittel: " + oppdatert.getTittle());
        System.out.println("Tekst: " + oppdatert.getTekst());

        assertEquals("Oppdatert nyhet", oppdatert.getTittle());
        assertEquals("Dette er en oppdatert tekst", oppdatert.getTekst());
    }


}