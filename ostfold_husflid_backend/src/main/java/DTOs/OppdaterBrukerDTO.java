package DTOs;

public class OppdaterBrukerDTO {
    private String navn;
    private String epost;

    public OppdaterBrukerDTO() {}

    public String getNavn() { return navn; }
    public String getEpost() { return epost; }

    public void setNavn(String navn) { this.navn = navn; }
    public void setEpost(String epost) { this.epost = epost; }
}
