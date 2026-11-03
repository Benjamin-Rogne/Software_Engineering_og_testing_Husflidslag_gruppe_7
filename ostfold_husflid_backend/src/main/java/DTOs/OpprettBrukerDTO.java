package DTOs;

public class OpprettBrukerDTO {
        private String navn;
        private String epost;
        private String passord;

    public String getNavn() {
        return navn;
    }

    public String getEpost() {
        return epost;
    }

    public String getPassord() {
        return passord;
    }

    public OpprettBrukerDTO(String navn, String epost, String passord) {
        this.navn = navn;
        this.epost = epost;
        this.passord = passord;
    }

    public OpprettBrukerDTO() {
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}