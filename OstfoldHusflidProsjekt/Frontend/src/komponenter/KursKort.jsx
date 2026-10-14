import { Link } from 'react-router';
import { formaterDato } from '../data/kurs';

export default function KursKort({ kurs }) {
    return (
        <article className='kurs-kort'>
            <img src={kurs.bilde} alt='' />
            <h3>{kurs.tittel}</h3>
            <p>{kurs.beskrivelse}</p>
            <p>Pris: {kurs.pris} kr</p>
            <p>Dato: <time dateTime={kurs.dato}>{formaterDato(kurs.dato)}</time></p>
            <p>Område: {kurs.omrade}</p>
            <p>Adresse: {kurs.adresse}</p>
            <Link to={`/kurs/${kurs.id}`}>Les mer</Link>
        </article>
    );
}