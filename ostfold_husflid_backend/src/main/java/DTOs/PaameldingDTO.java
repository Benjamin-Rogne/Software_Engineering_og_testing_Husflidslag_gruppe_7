package DTOs;


import java.time.LocalDateTime;

public class PaameldingDTO {
    private int brukerId;
    private int kursId;
    private int PaameldingId;
    private LocalDateTime datoTid;
    private int aktivitetId;


    public PaameldingDTO(int brukerId, int kursId, int paameldingId, LocalDateTime datoTid, int aktivitetId) {
        this.brukerId = brukerId;
        this.kursId = kursId;
        PaameldingId = paameldingId;
        this.datoTid = datoTid;
        this.aktivitetId = aktivitetId;
    }

    public PaameldingDTO(int brukerId, int kursId) {
        this.brukerId = brukerId;
        this.kursId = kursId;
    }


    public PaameldingDTO() {
    }

    public PaameldingDTO(int brukerId, int kursId, int paameldingId, LocalDateTime datoTid) {
        this.brukerId = brukerId;
        this.kursId = kursId;
        PaameldingId = paameldingId;
        this.datoTid = datoTid;
    }

    public int getBrukerId() {
        return brukerId;
    }

    public void setBrukerId(int brukerId) {
        this.brukerId = brukerId;
    }

    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    public int getPaameldingId() {
        return PaameldingId;
    }

    public void setPaameldingId(int paameldingId) {
        PaameldingId = paameldingId;
    }

    public LocalDateTime getDatoTid() {
        return datoTid;
    }

    public void setDatoTid(LocalDateTime datoTid) {
        this.datoTid = datoTid;
    }

    public int getAktivitetId() {
        return aktivitetId;
    }

    public void setAktivitetId(int aktivitetId) {
        this.aktivitetId = aktivitetId;
    }
}