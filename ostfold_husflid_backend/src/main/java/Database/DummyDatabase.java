package Database;

import models.Bruker;
import java.util.ArrayList;
import java.util.List;

// dummy database som inneholder bruker objecter "bruker table"
public class DummyDatabase {

    public static final List<Bruker> brukere =
            new ArrayList<>(List.of(
                    new Bruker("Ola Nordmann", "ola@epost.no", "io123fjk", "admin"),
                    new Bruker("Kari Hansen", "kari@epost.no","io456gjk", "bruker"),
                    new Bruker("Per Olsen", "per@epost.no","ioghj687jk", "bruker")
            ));
}