package Services;
import DTOs.OpprettBrukerDTO;
import org.junit.jupiter.api.Test;
import services.BrukerService;
import static org.junit.jupiter.api.Assertions.*;

public class BrukerServiceTest {

    BrukerService service = new BrukerService();
    //tester ugyldig epost
    //enhettest
    @Test
    void testUgyldigEpost() {
        OpprettBrukerDTO dto = new OpprettBrukerDTO();

        dto.setNavn("Ola Nordmann");
        dto.setEpost("olaepost.no");
        dto.setPassord("123456789012");

        try {
            service.opprettBruker(dto);

            System.out.println("Test feilet: Ugyldig e-post ble godkjent");
            fail("Ugyldig e-post skulle blitt avvist");

        } catch (IllegalArgumentException e) {

            if (e.getMessage().equals("Ugyldig e-postadresse")) {
                System.out.println("Test bestått: Ugyldig e-post ble avvist");
            } else {
                System.out.println("Test feilet: Feil valideringsregel");
                fail("Feil feilmelding: " + e.getMessage());
            }
        }
    }
    //tester ugyldig lengde av passord
    //enhettest
    @Test
    void testForKortPassord() {

        OpprettBrukerDTO dto = new OpprettBrukerDTO();

        dto.setNavn("Ola Nordmann");
        dto.setEpost("ola@epost.no");
        dto.setPassord("12345");

        assertThrows(IllegalArgumentException.class, () -> {
            service.opprettBruker(dto);
        });
        System.out.println("Test bestått: For kort passord ble avvist");
    }
}