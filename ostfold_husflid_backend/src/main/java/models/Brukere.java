package models;

public class Brukere {
    private int Brukere_id;
    private String Navn;
    private String Epost;
    private String Passord;
    private String Rolle;

    public int getBrukere_id() {
        return Brukere_id;
    }

    public void setBrukere_id(int brukere_id) {
        Brukere_id = brukere_id;
    }

    public String getNavn() {
        return Navn;
    }

    public void setNavn(String navn) {
        Navn = navn;
    }

    public String getEpost() {
        return Epost;
    }

    public void setEpost(String epost) {
        Epost = epost;
    }

    public String getPassord() {
        return Passord;
    }

    public void setPassord(String passord) {
        Passord = passord;
    }

    public String getRolle() {
        return Rolle;
    }

    public void setRolle(String rolle) {
        Rolle = rolle;
    }

    public Brukere(int brukere_id, String navn, String epost, String passord, String rolle) {
        Brukere_id = brukere_id;
        Navn = navn;
        Epost = epost;
        Passord = passord;
        Rolle = rolle;
    }

    // constuctor uten
    public Brukere(String navn, String epost, String passord, String rolle) {
        Navn = navn;
        Epost = epost;
        Passord = passord;
        Rolle = rolle;
    }

    @Override
    public String toString() {
        return "Navn: " + Navn +
                ", Epost: " + Epost +
                ", Rolle: " + Rolle;
    }
}
