import { Link } from "react-router";
import { formaterDato, formaterKlokkeslett } from "../formatering/dato.js";

export default function KursKort({ kurs }) {
  return (
    <article className="kurs-kort">
      <img src={kurs.bilde} alt="" />
      <h3>{kurs.tittel}</h3>
      <p>Kl. {formaterKlokkeslett(kurs.start, kurs.slutt)}</p>
      <p>Pris: {kurs.pris} kr</p>
      <p>Dato: <time dateTime={kurs.start}>{formaterDato(kurs.start)}</time></p>
      <p>Område: {kurs.omrade}</p>
      <p>Adresse: {kurs.adresse}</p>
      <Link to={`/kurs/${kurs.id}`}>Les mer</Link>
    </article>
  );
}