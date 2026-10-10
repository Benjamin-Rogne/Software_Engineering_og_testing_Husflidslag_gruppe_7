package org.example;
import java.time.LocalDate;

public class Nyhet {
    int Nyhet_id;
    String tittle;
    String tekst;
    String bilde;
    LocalDate date;
    int omrade_id;
    int brukere_id;

    public Nyhet(int nyhet_id, String tittle, String tekst, String bilde,
                 LocalDate date, int omrade_omrade_id, int brukere_brukere_id) {

        this.Nyhet_id = nyhet_id;
        this.tittle = tittle;
        this.tekst = tekst;
        this.bilde = bilde;
        this.date = date;
        this.omrade_id = omrade_omrade_id;
        this.brukere_id = brukere_brukere_id;

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
        return omrade_id;
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

    public void setOmrade_id(int omrade_id) {
        this.omrade_id = omrade_id;
    }

    public void setBrukere_id(int brukere_id) {
        this.brukere_id = brukere_id;
    }


}