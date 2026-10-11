import { useParams, Link } from "react-router";
import { kursListe, formaterDato } from "../data/kurs.js";
import { Calendar, MapPin, Info } from "lucide-react";

export default function KursInfo() {
    const { id } = useParams();
    const kurs = kursListe.find((k) => k.id === Number(id));

    if (!kurs) {
        return (
            <main className="innhold">
                <h1>Fant ikke kurset</h1>
                <p><Link to='/kurs'>Tilbake til kursoversikten</Link></p>
            </main>
        );
    }

    const kartUrl =
        "https://www.google.com/maps?q=" + encodeURIComponent(kurs.adresse) + "&output=embed";

    return (
        <main className="arrangement">
            <article className="arrangement-innhold">
                
                {/*tittel, dato og sted */}
                <section className="kort">
                    <h1>{kurs.tittel}</h1>
                    <ul className="nokkelinfo">
                        <li className="info-linje">
                            <Calendar className="ikon" aria-hidden="true"/>
                            <time dateTime={kurs.dato}>{formaterDato(kurs.dato)}</time>
                        </li>
                        <li className="info-linje">
                            <MapPin className="ikon" aria-hidden="true"/>
                            <span>
                                <span className="stor">{kurs.arrangor}</span><br />
                                {kurs.adresse}
                            </span>
                        </li>
                    </ul>
                    {!kurs.pameldingApen && (
                        <p className="melding">
                        <Info className="ikon" aria-hidden="true" />    
                         Påmeldingen er lukket.
                         </p>
                    )}
                </section>

                {/* Om kurset */}
                <section className="kort">
                    <h2>Om arrangementet</h2>
                    <p className="liten">Arrangør: {kurs.arrangor}</p>
                    <p>{kurs.beskrivelse}</p>
                    <p><strong>Pris:</strong> kr {kurs.pris}</p>
                </section>

                {/* kart */}
                <section className="kort kart-kort">
                    <iframe src={kartUrl} title={`Kart over ${kurs.adresse}`}></iframe>
                    <p className="info-linje kart-adresse">
                        <span className="ikon" aria-hidden="true"></span>
                        <span>
                            <span className="stor">{kurs.arrangor}</span><br />
                            {kurs.adresse}
                        </span>
                    </p>
                </section>
            </article>

            <aside className="arrangement-bilde">
                <img src={kurs.bilde} alt="" />
            </aside>
        </main>
    );
}