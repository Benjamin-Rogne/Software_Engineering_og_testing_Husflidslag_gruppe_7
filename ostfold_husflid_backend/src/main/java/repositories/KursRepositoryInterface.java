package repositories;
import models.Kurs;
import java.util.List;
import java.util.Optional;



public interface KursRepositoryInterface {
    List<Kurs> hentAlleKurs();
    Optional<Kurs> hentKurs(int kurs_id);
    List<Kurs> hentKursEtterOmraade(int omraade_id);
    void leggTilKurs(Kurs nyttKurs);
    void oppdaterKurs(int kurs_id, Kurs oppdatertKurs);
    void slettKurs(int kurs_id);
}


