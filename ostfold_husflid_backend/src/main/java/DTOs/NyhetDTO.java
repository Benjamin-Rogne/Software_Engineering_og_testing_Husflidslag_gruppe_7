package DTOs;

import java.time.LocalDate;

public class NyhetDTO {

    private int Nyhet_id;
    private String tittle;
    private String tekst;
    private String bilde;
    private LocalDate date;
    private int omraade_id;
    private int brukere_id;

    public NyhetDTO(int nyhet_id, String tittle, String tekst, String bilde, LocalDate date, int omraade_id, int brukere_id) {
        Nyhet_id = nyhet_id;
        this.tittle = tittle;
        this.tekst = tekst;
        this.bilde = bilde;
        this.date = date;
        this.omraade_id = omraade_id;
        this.brukere_id = brukere_id;
    }


    public NyhetDTO() {
    }

    public int getNyhet_id() {
        return Nyhet_id;
    }

    public void setNyhet_id(int nyhet_id) {
        Nyhet_id = nyhet_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getBilde() {
        return bilde;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOmraade_id() {
        return omraade_id;
    }

    public void setOmraade_id(int omraade_id) {
        this.omraade_id = omraade_id;
    }

    public int getBrukere_id() {
        return brukere_id;
    }

    public void setBrukere_id(int brukere_id) {
        this.brukere_id = brukere_id;
    }


    @Override
    public String toString() {
        return "NyhetDTO{" +
                "Nyhet_id=" + Nyhet_id +
                ", tittle='" + tittle + '\'' +
                ", tekst='" + tekst + '\'' +
                ", bilde='" + bilde + '\'' +
                ", date=" + date +
                ", omraade_id=" + omraade_id +
                ", brukere_id=" + brukere_id +
                '}';
    }
}
