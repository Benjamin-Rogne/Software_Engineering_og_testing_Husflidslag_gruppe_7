import { Link } from "react-router";
import { formaterDato, formaterKlokkeslett } from "../formatering/dato.js";

// ett kort i kursoversikt, kurs-objekt fra kursoverikst
export default function KursKort({ kurs }) {
  return (
    // article siden hvert kort er en egen del
    <article className="kurs-kort">

      {/* ikke fylt ut alt pga tittel er tilknyttet */}
      <img src={kurs.bilde} alt="" />
      <h3>{kurs.tittel}</h3>

      {/* ikke bytt rekkefølge på p tags, css'en bruker rekkefølgen den står i her */}
      <p>Kl. {formaterKlokkeslett(kurs.start, kurs.slutt)}</p>
      <p>Pris: {kurs.pris} kr</p>
      {/* datetime slik at en maskin kan lese datoen riktig */}
      <p>Dato: <time dateTime={kurs.start}>{formaterDato(kurs.start)}</time></p>
      <p>Område: {kurs.omrade}</p>
      <p>Adresse: {kurs.adresse}</p>
      <Link to={`/kurs/${kurs.id}`}>Les mer</Link>
    </article>
  );
}