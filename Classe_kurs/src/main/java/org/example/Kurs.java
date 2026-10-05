package org.example;
import java.time.LocalDate;
public class Kurs{

    //kurs klasse
    private int kurs;
    private String tittel;
    private String beskrivelse;
    private LocalDate startDato;
    private LocalDate sluttDato;
    private String sted;
    private double pris;
    private int omradeId;
    private int kursholder;

    public Kurs(int kurs, String tittel, String beskrivelse,
                LocalDate startDato, LocalDate sluttDato,
                String sted, double pris, int omradeId,
                int kursholder) {

        this.kurs = kurs;
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.startDato = startDato;
        this.sluttDato = sluttDato;
        this.sted = sted;
        this.pris = pris;
        this.omradeId = omradeId;
        this.kursholder = kursholder;
    }

    public int getKursId() {
        return kurs;
    }

    public String getTittel() {
        return tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSluttDato() {
        return sluttDato;
    }

    public String getSted() {
        return sted;
    }

    public double getPris() {
        return pris;
    }

    public int getOmradeId() {
        return omradeId;
    }

    public int getKursholderId() {
        return kursholder;
    }
}