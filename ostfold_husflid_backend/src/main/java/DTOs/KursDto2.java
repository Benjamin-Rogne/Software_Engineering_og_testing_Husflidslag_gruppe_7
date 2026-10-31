package DTOs;
import java.time.format.DateTimeFormatter;
import models.Kursklasse;

public class KursDto2 {

        private int kurs_id;
        private String tittle;
        private String start_dato;
        private String slutt_dato;
        private float pris;
        private int omraade_id;
        private int kursholder_id;
        private int paamelding_id;
        private String adresse;

        public KursDto2(Kursklasse kurs) {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            this.kurs_id = kurs.getKurs_id();
            this.tittle = kurs.getTittle();
            this.start_dato = kurs.getStart_dato() != null
                    ? kurs.getStart_dato().format(formatter) : null;
            this.slutt_dato = kurs.getSlutt_dato() != null
                    ? kurs.getSlutt_dato().format(formatter) : null;
            this.pris = kurs.getPris();
            this.omraade_id = kurs.getOmraade_id();
            this.kursholder_id = kurs.getKursholder_id();
            this.paamelding_id = kurs.getPaamelding_id();
            this.adresse = kurs.getAdresse();
        }

        public int getKurs_id() {
            return kurs_id;
        }

        public String getTittle() {
            return tittle;
        }

        public String getStart_dato() {
            return start_dato;
        }

        public String getSlutt_dato() {
            return slutt_dato;
        }

        public float getPris() {
            return pris;
        }

        public int getOmraade_id() {
            return omraade_id;
        }

        public int getKursholder_id() {
            return kursholder_id;
        }

        public int getPaamelding_id() {
            return paamelding_id;
        }

        public String getAdresse() {
            return adresse;
        }
}
