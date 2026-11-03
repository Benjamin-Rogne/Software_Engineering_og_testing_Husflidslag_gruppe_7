import { useEffect, useState } from "react";
import { useParams, Link } from "react-router";
import { Calendar, Clock, MapPin } from "lucide-react";
import { hentKurs } from "../api/kurs.js";
import { formaterDato, formaterKlokkeslett } from "../formatering/dato.js";

// Én side for alle kurs. Hvilket kurs som vises styres av id-en i adressen (/kurs/1).
export default function KursInfo() {
  const { id } = useParams();
  const [kurs, setKurs] = useState(null);
  const [laster, setLaster] = useState(true);

  // Henter kurset på nytt hvis id-en i adressen endres
  useEffect(() => {
    setLaster(true);
    hentKurs(id)
      .then(setKurs)
      .catch(() => setKurs(null))
      .finally(() => setLaster(false));
  }, [id]);

  if (laster) {
    return (
      <main className="ikke-funnet">
        <p>Henter kurs …</p>
      </main>
    );
  }

  if (!kurs) {
    return (
      <main className="ikke-funnet">
        <h1>Fant ikke kurset</h1>
        <p><Link to="/kurs">Tilbake til kursoversikten</Link></p>
      </main>
    );
  }

  const kartUrl =
    "https://www.google.com/maps?q=" + encodeURIComponent(kurs.adresse) + "&output=embed";

  return (
    <main className="arrangement">
      <article className="arrangement-innhold">

        {/* Tittel, dato, tid og sted */}
        <section className="kort">
          <h1>{kurs.tittel}</h1>
          <ul className="nokkelinfo">
            <li className="info-linje">
              <Calendar className="ikon" aria-hidden="true" />
              <time dateTime={kurs.start}>{formaterDato(kurs.start)}</time>
            </li>
            <li className="info-linje">
              <Clock className="ikon" aria-hidden="true" />
              <span>Kl. {formaterKlokkeslett(kurs.start, kurs.slutt)}</span>
            </li>
            <li className="info-linje">
              <MapPin className="ikon" aria-hidden="true" />
              <span>
                <span className="stor">{kurs.omrade}</span><br />
                {kurs.adresse}
              </span>
            </li>
          </ul>
        </section>

        {/* Om kurset */}
        <section className="kort">
          <h2>Om arrangementet</h2>
          <p><strong>Pris:</strong> {kurs.pris} kr</p>
          <p><strong>Område:</strong> {kurs.omrade}</p>
        </section>

        {/* Kart */}
        <section className="kort kart-kort">
          <iframe src={kartUrl} title={`Kart over ${kurs.adresse}`}></iframe>
          <p className="info-linje kart-adresse">
            <MapPin className="ikon" aria-hidden="true" />
            <span>{kurs.adresse}</span>
          </p>
        </section>
      </article>

      <aside className="arrangement-bilde">
        <img src={kurs.bilde} alt="" />
      </aside>
    </main>
  );
}