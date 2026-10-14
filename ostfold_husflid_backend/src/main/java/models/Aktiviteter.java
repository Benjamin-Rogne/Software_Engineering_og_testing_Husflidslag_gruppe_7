package models;
import java.time.LocalDate;

public class Aktiviteter {
    int aktivitet_id;
    String tittle;
    String bilde;
    String beskrivelse;
    LocalDate dato;
    int omraade_id;


    public Aktiviteter(int aktivitet_id, String tittle, String beskrivelse,String bilde, LocalDate dato, int omraade_id) {
        this.aktivitet_id = aktivitet_id;
        this.tittle = tittle;
        this.beskrivelse = beskrivelse;
        this.bilde = bilde;
        this.dato = dato;
        this.omraade_id = omraade_id;

    }

    public int getAktivitet_id() {
        return aktivitet_id;
    }

    public String getTittel() {
        return tittle;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getBilde() {
        return bilde;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getOmraade_id() {
        return omraade_id;
    }

    public void setAktivitet_id(int aktivitet_id) {
        this.aktivitet_id = aktivitet_id;
    }

    public void setTittel(String tittle) {
        this.tittle = tittle;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setOmraade_id(int omraade_id){
        this.omraade_id = omraade_id;
    }


}

