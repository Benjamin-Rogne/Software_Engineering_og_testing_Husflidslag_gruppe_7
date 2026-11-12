// Styret i Østfold Husflidslag
const styret = [
    { rolle: "Styreleder", navn: "Mona Andersen", epost: "mona@sjokkpris.no", telefon: "91777582", bilde: "/bilder/styret/mona.jpg" },
    { rolle: "Nestleder", navn: "Aud Kari Holme", epost: "Audkari.holme@gmail.com", telefon: "95879367", bilde: "/bilder/styret/aud-kari.jpg" },
    { rolle: "Sekretær", navn: "Heidi Børstad", epost: "heidi.borstad@gmail.com", telefon: "95222155", bilde: "/bilder/styret/heidi.jpg" },
    { rolle: "Nettansvarlig", navn: "Silja Devine Holhjem", epost: "siljadevine@gmail.com", telefon: "41664904", bilde: "/bilder/styret/silja.jpg" },
    { rolle: "Styremedlem", navn: "Linda P. Vallner", epost: "lindap.vallner@gmail.com", telefon: "97638424", bilde: "/bilder/styret/linda.jpg" },
    { rolle: "Styremedlem", navn: "Thore Grøtvedt", epost: "thoregro@gmail.com", telefon: "90135455", bilde: "/bilder/styret/thore.jpg" },
    { rolle: "Ung Husflidskontakt", navn: "Linda P. Vallner", epost: "lindap.vallner@gmail.com", telefon: "97638424", bilde: "/bilder/styret/linda.jpg" },
    { rolle: "Varamedlem", navn: "Julie Mari Brevik", epost: "bunad.julie@gmail.com", telefon: "99313244", bilde: "/bilder/styret/julie.jpg" },
];

// "91777582" → "917 77 582"
function formaterTelefon(nummer) {
    return nummer.replace(/(\d{3})(\d{2})(\d{3})/, "$1 $2 $3");
}

export default function Kontakt() {
    return (
        <main className="kontakt">
            <h1>Kontakt oss</h1>

            {/* Hovedkontakt */}
            <address className="kontakt-boks">
                Mona Andersen<br />
                Emil Mørchs vei 25, 2. etg. rom 1<br />
                1653 Sellebakk<br />
                <a href="tel:+4791777582">917 77 582</a><br />
                <a href="mailto:ostfoldhusflid@gmail.com">ostfoldhusflid@gmail.com</a>
            </address>

            {/* Styret: informasjon til venstre, bilde til høyre */}
            <section aria-labelledby="styret-tittel">
                <h2 id="styret-tittel" className="skjult-tittel">Styret</h2>
                <ul className="styret">
                    {styret.map((person) => (
                        <li key={person.rolle + person.navn}>
                            <div className="styret-info">
                                <p className="styret-rolle">{person.rolle}</p>
                                <p className="styret-navn">{person.navn}</p>
                                <address>
                                    <a href={"mailto:" + person.epost}>{person.epost}</a><br />
                                    <a href={"tel:+47" + person.telefon}>{formaterTelefon(person.telefon)}</a>
                                </address>
                            </div>
                            <img src={person.bilde} alt="" />
                        </li>
                    ))}
                </ul>
            </section>
        </main>
    );
}