import { Mail, Phone, MapPin } from "lucide-react";

const adresse = "Emil Mørchs vei 25, 1653 Sellebakk";

export default function Kontakt() {
    const kartUrl =
        "https://www.google.com/maps?q=" + encodeURIComponent(adresse) + "&output=embed";

    return (
        <main className="arrangement">
            <article className="arrangement-innhold">

              
                <section className="kort">
                    <h1>Kontakt oss</h1>
                    <ul className="nokkelinfo">
                        <li className="info-linje">
                            <MapPin className="ikon" aria-hidden="true" />
                            <span>
                                <span className="stor">Østfold Husflidslag</span><br />
                                {adresse}
                            </span>
                        </li>
                        <li className="info-linje">
                            <Mail className="ikon" aria-hidden="true" />
                            <a href="mailto:ostfoldhusflid@gmail.com">ostfoldhusflid@gmail.com</a>
                        </li>
                        <li className="info-linje">
                            <Phone className="ikon" aria-hidden="true" />
                            <a href="tel:+4791777582">+47 917 77 582</a>
                        </li>
                    </ul>
                </section>

                
                <section className="kort">
                    <h2>Send oss en melding</h2>
                    <form className="kontaktskjema" onSubmit={(e) => e.preventDefault()}>
                        <label htmlFor="navn">Navn</label>
                        <input id="navn" name="navn" type="text" required />

                        <label htmlFor="epost">E-post</label>
                        <input id="epost" name="epost" type="email" required />

                        <label htmlFor="melding">Melding</label>
                        <textarea id="melding" name="melding" rows="6" required></textarea>

                        <button type="submit">Send</button>
                    </form>
                </section>

                
                <section className="kort kart-kort">
                    <iframe src={kartUrl} title={`Kart over ${adresse}`}></iframe>
                </section>
            </article>

            <aside className="arrangement-bilde">
                <img src="/bilder/hovedbilde.jpg" alt="" />
            </aside>
        </main>
    );
}