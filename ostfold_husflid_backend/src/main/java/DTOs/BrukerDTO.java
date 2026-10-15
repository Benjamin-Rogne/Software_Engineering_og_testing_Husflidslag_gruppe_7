package DTOs;

public class BrukerDTO {
    private int id;
    private String navn;
    private String epost;

    public BrukerDTO(int id, String navn, String epost) {
        this.id = id;
        this.navn = navn;
        this.epost = epost;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getEpost() {
        return epost;
    }
}
