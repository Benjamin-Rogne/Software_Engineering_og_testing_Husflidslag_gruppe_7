package models;

public class Bruker {
    private int Bruker_id;
    private String Navn;
    private String Epost;
    private String Passord;
    private String Rolle;

    public int getBruker_id() {
        return Bruker_id;
    }

    public void setBruker_id(int bruker_id) {
        Bruker_id = bruker_id;
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

    //med bruker id
    public Bruker(int bruker_id, String navn, String epost, String passord, String rolle) {
        Bruker_id = bruker_id;
        Navn = navn;
        Epost = epost;
        Passord = passord;
        Rolle = rolle;
    }

    //uten bruker id
    public Bruker(String navn, String epost, String passord, String rolle) {
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
