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

export default function Kontakt() {
    return (
        <main className="kontakt">
            <h1>Kontakt oss</h1>

            <p className="kontakt-boks">
                Mona Andersen<br />
                Emil Mørchs vei 25, 2. etg. rom 1<br />
                1653 SELLEBAKK<br />
                <a href="tel:91777582">91777582</a><br />
                <a href="mailto:ostfoldhusflid@gmail.com">ostfoldhusflid@gmail.com</a>
            </p>

            <ul className="styret">
                {styret.map((person) => (
                    <li key={person.rolle + person.navn}>
                        
                        <p>
                            <small>{person.rolle}</small><br />
                            <strong>{person.navn}</strong><br />
                            <a href={"mailto:" + person.epost}>{person.epost}</a><br />
                            <a href={"tel:" + person.telefon}>{person.telefon}</a>
                        </p>
                        <img src={person.bilde} alt="" />
                    </li>
                ))}
            </ul>
        </main>
    );
}