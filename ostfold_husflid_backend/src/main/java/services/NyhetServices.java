package services;

import models.Nyhet;
import java.util.ArrayList;
import java.util.List;

public class NyhetServices {

    private final List<Nyhet> nyheter = new ArrayList<>();

    public List<Nyhet> getAllNyheter() {
        return nyheter;
    }

    public void addNyhet(Nyhet nyhet) {
        nyheter.add(nyhet);
    }

    public boolean redigerNyhet(int id, Nyhet nyNyhet) {
        for (int i = 0; i < nyheter.size(); i++) {
            if (nyheter.get(i).getNyhet_id() == id) {
                nyheter.set(i, nyNyhet);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNyhet(int id) {
        return nyheter.removeIf(
                nyhet -> nyhet.getNyhet_id() == id
        );
    }
}