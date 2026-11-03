package DTOs;

import java.time.LocalDate;

public class AktivitetDTO {

    private int aktivitet_id;
    private String tittle;
    private String bilde;
    private String beskrivelse;
    private LocalDate dato;
    private int omraade_id;


    public AktivitetDTO(int aktivitet_id, String tittle, String bilde, String beskrivelse, LocalDate dato, int omraade_id) {
        this.aktivitet_id = aktivitet_id;
        this.tittle = tittle;
        this.bilde = bilde;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.omraade_id = omraade_id;
    }

    public AktivitetDTO() {
    }


    public int getAktivitet_id() {
        return aktivitet_id;
    }

    public void setAktivitet_id(int aktivitet_id) {
        this.aktivitet_id = aktivitet_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBilde() {
        return bilde;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getOmraade_id() {
        return omraade_id;
    }

    public void setOmraade_id(int omraade_id) {
        this.omraade_id = omraade_id;
    }

    @Override
    public String toString() {
        return "AktivitetDTO{" +
                "aktivitet_id=" + aktivitet_id +
                ", tittle='" + tittle + '\'' +
                ", bilde='" + bilde + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", dato=" + dato +
                ", omraade_id=" + omraade_id +
                '}';
    }
}
