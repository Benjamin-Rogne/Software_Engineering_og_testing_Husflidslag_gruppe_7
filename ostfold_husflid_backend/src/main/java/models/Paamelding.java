package models;

import java.time.LocalDateTime;

public class Paamelding {
    int idPaamelding;
    int idbruker;
    int idkurs;
    LocalDateTime datoTid;
    int aktivitet_id;


    public Paamelding(int aktivitet_id, LocalDateTime datoTid, int idkurs, int idbruker, int idPaamelding) {
        this.aktivitet_id = aktivitet_id;
        this.datoTid = datoTid;
        this.idkurs = idkurs;
        this.idbruker = idbruker;
        this.idPaamelding = idPaamelding;
    }


    public int getIdPaamelding() {
        return idPaamelding;
    }

    public void setIdPaamelding(int idPaamelding) {
        this.idPaamelding = idPaamelding;
    }

    public int getIdbruker() {
        return idbruker;
    }

    public void setIdbruker(int idbruker) {
        this.idbruker = idbruker;
    }

    public int getIdkurs() {
        return idkurs;
    }

    public void setIdkurs(int idkurs) {
        this.idkurs = idkurs;
    }

    public LocalDateTime getDatoTid() {
        return datoTid;
    }

    public void setDatoTid(LocalDateTime datoTid) {
        this.datoTid = datoTid;
    }

    public int getAktivitet_id() {
        return aktivitet_id;
    }

    public void setAktivitet_id(int aktivitet_id) {
        this.aktivitet_id = aktivitet_id;
    }


    @Override
    public String toString() {
        return "paamelding{" +
                "idPaamelding=" + idPaamelding +
                ", idbruker=" + idbruker +
                ", idkurs=" + idkurs +
                ", datoTid=" + datoTid +
                ", aktivitet_id=" + aktivitet_id +
                '}';
    }
}
