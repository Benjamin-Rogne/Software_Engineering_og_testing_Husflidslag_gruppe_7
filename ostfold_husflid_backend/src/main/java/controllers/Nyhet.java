import java.time.LocalDate;

public class Nyhet {
    int Nyhet_id;
    String tittle;
    String tekst;
    String bilde;
    LocalDate date;
    int omraade_id;
    int brukere_id;

    public Nyhet(int nyhet_id, String tittle, String tekst, String bilde,
                 LocalDate date, int omraade_id, int brukere_id) {

        this.Nyhet_id = nyhet_id;
        this.tittle = tittle;
        this.tekst = tekst;
        this.bilde = bilde;
        this.date = date;
        this.omraade_id = omraade_id;
        this.brukere_id = brukere_id;

    }

    public int getNyhet_id() {
        return Nyhet_id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getTekst() {
        return tekst;
    }

    public String getBilde() {
        return bilde;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getOmrade_id() {
        return omraade_id;
    }

    public int getBrukere_id() {
        return brukere_id;
    }

    public void setNyhet_id(int nyhet_id) {
        this.Nyhet_id = nyhet_id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOmraade_id(int omraade_id) {
        this.omraade_id = omraade_id;
    }

    public void setBrukere_id(int brukere_id) {
        this.brukere_id = brukere_id;
    }


}