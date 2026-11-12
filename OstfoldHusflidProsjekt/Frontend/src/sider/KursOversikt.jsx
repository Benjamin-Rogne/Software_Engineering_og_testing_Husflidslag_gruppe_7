import { useEffect, useState } from "react";
import KursKort from "../komponenter/KursKort.jsx";
import { hentAlleKurs, OMRADER } from "../api/kurs.js";

 // Henter kursene fra backend når siden åpnes, kan filtreres på område og sorteres
export default function KursOversikt() {
  const [kursListe, setKursListe] = useState([]);
  const [laster, setLaster] = useState(true);
  const [feil, setFeil] = useState(null);
  const [sortering, setSortering] = useState("dato");
  const [omrade, setOmrade] = useState("");

 // henter kursene fra backend
  useEffect(() => {
    hentAlleKurs()
      .then(setKursListe)
      .catch((e) => setFeil(e.message))
      .finally(() => setLaster(false));
  }, []);

  // Filtrer på område, deretter sorter. Gjøres i frontend inntil filtrerKurs i backend er klar.
  const visteKurs = kursListe
    .filter((kurs) => omrade === "" || kurs.omrade === omrade)
    .toSorted((a, b) =>
      sortering === "pris" ? a.pris - b.pris : a.start.localeCompare(b.start)
    );

  return (
    <main className="innhold kursside">
      <h1>Kurs og aktiviteter</h1>

      {/* oppdateres med en gang brukeren endrer et valg */}
      <section className="kurs-filtrering" aria-label="Filtrer kurs">
        <form onSubmit={(e) => e.preventDefault()}>
          <label htmlFor="sortering">Sorter etter:</label>
          <select
            id="sortering"
            value={sortering}
            onChange={(e) => setSortering(e.target.value)}
          >
            <option value="dato">Dato</option>
            <option value="pris">Pris</option>
          </select>
          {/* har ikke en synlig label, aria-label sier til skjermleser hva det er */}
          <select
            id="omraade"
            aria-label="Område"
            value={omrade}
            onChange={(e) => setOmrade(e.target.value)}
          >
            <option value="">Hele Østfold</option>
            {/* ett valg for hver område */}
            {OMRADER.map((o) => (
              <option key={o} value={o}>{o}</option>
            ))}
          </select>
        </form>
      </section>
      

      {/* kun en av meldingene vises om gangen */}
      {laster && <p>Henter kurs …</p>}
      {feil && <p role="alert">{feil}. Prøv igjen senere.</p>}
      {!laster && !feil && visteKurs.length === 0 && (
        <p>Ingen kurs i dette området ennå.</p>
      )}


      {/* ett kurskort per kurs, key for at react skal ha kontroll på de */}
      <section className="kurs-container" aria-label="Kurs">
        {visteKurs.map((kurs) => (
          <KursKort key={kurs.id} kurs={kurs} />
        ))}
      </section>
    </main>
  );
}