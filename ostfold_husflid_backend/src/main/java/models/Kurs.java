package models;

import java.time.LocalDateTime;

public class Kurs {
    int kurs_id;
    String tittle;
    LocalDateTime start_dato;
    LocalDateTime slutt_dato;
    float pris;
    int omraade_id;
    int kursholder_id;
    int paamelding_id;
    int adresse_id;
    private String bilde;

    public Kurs(int kurs_id, String tittle, LocalDateTime start_dato, LocalDateTime slutt_dato, float pris, int omraade_id, int kursholder_id, int paamelding_paamelding_id, int adresse_id) {
        this.kurs_id = kurs_id;
        this.tittle = tittle;
        this.start_dato = start_dato;
        this.slutt_dato = slutt_dato;
        this.pris = pris;
        this.omraade_id = omraade_id;
        this.kursholder_id = kursholder_id;
        this.paamelding_id = paamelding_paamelding_id;
        this.adresse_id = adresse_id;
    }

    // med Bilde
    public Kurs(String bilde, int kurs_id, String tittle, LocalDateTime start_dato, LocalDateTime slutt_dato, float pris, int omraade_id, int kursholder_id, int paamelding_id, int adresse_id) {
        this.bilde = bilde;
        this.kurs_id = kurs_id;
        this.tittle = tittle;
        this.start_dato = start_dato;
        this.slutt_dato = slutt_dato;
        this.pris = pris;
        this.omraade_id = omraade_id;
        this.kursholder_id = kursholder_id;
        this.paamelding_id = paamelding_id;
        this.adresse_id = adresse_id;
    }

    public String getBilde() {
        return bilde;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public Kurs() {
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

    public int getAdresse_id() {
        return adresse_id;
    }

    public void setAdresse_id(int adresse_id) {
        this.adresse_id = adresse_id;
    }
}



