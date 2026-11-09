package DTOs;

public class PaameldingDTO {
    private int brukerId;
    private int kursId;

    public PaameldingDTO(int brukerId, int kursId) {
        this.brukerId = brukerId;
        this.kursId = kursId;
    }

    public PaameldingDTO() {
    }

    public int getBrukerId() { return brukerId; }
    public int getKursId() { return kursId; }
}