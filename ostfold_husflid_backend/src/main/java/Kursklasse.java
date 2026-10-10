import java.time.LocalDateTime;

public class Kursklasse {
    int kurs_id;
    String tittle;
    LocalDateTime start_dato;
    LocalDateTime slutt_dato;
    float pris;
    int omraade_id;
    int kursholder_id;
    int paamelding_id;
    String adresse;

    public Kursklasse(int kurs_id, String tittle, LocalDateTime start_dato, LocalDateTime slutt_dato, float pris, int omraade_id, int kursholder_id, int paamelding_paamelding_id, String adresse) {
        this.kurs_id = kurs_id;
        this.tittle = tittle;
        this.start_dato = start_dato;
        this.slutt_dato = slutt_dato;
        this.pris = pris;
        this.omraade_id = omraade_id;
        this.kursholder_id = kursholder_id;
        this.paamelding_id = paamelding_paamelding_id;
        this.adresse = adresse;
    }


    public int getKurs_id() {
        return kurs_id;
    }

    public void setKurs_id(int kurs_id) {
        this.kurs_id = kurs_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public LocalDateTime getStart_dato() {
        return start_dato;
    }

    public void setStart_dato(LocalDateTime start_dato) {
        this.start_dato = start_dato;
    }

    public LocalDateTime getSlutt_dato() {
        return slutt_dato;
    }

    public void setSlutt_dato(LocalDateTime slutt_dato) {
        this.slutt_dato = slutt_dato;
    }

    public float getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }

    public int getOmraade_id() {
        return omraade_id;
    }

    public void setOmraade_id(int omraade_id) {
        this.omraade_id = omraade_id;
    }

    public int getKursholder_id() {
        return kursholder_id;
    }

    public void setKursholder_id(int kursholder_id) {
        this.kursholder_id = kursholder_id;
    }

    public int getPaamelding_id() {
        return paamelding_id;
    }

    public void setPaamelding_id(int paamelding_id) {
        this.paamelding_id = paamelding_id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}



