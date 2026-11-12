import { Link } from "react-router";

// Forsiden med velkomsttekst, bilde, lokallag, snarvei til kurs og knapp for å bli medlem
export default function Forside() {
  return (
    <main className="innhold">
      <h1>Velkommen til husflid i Østfold</h1>
      {/* ingen innhold i alt grunnet ren pynt */}
      <img className="tittel-stjerne" src="/bilder/stjerne.png" alt="" />

      <section className="intro" aria-label="Om Østfold Husflidslag">
        <p>
          Østfold Husflidslag tar vare på og utvikler husflid og tradisjonelt
          håndverk i hele fylket. Gjennom lokallagene våre arrangerer vi kurs,
          verksteder og treff for alle som vil lære noe nytt med hendene.
        </p>
      </section>

      <figure className="hovedbilde">
        <img src="/bilder/hovedbilde.jpg" alt="Tre personer i Østfoldbunad" />
      </figure>

      {/* lokallagene til venstre og kurs knappen til høyre */}
      <section className="lokallag" aria-labelledby="lokallag-tittel">
        <h2 id="lokallag-tittel">Her finner du oss:</h2>
        <ul className="stedliste">
          <li>Fredrikstad</li>
          <li>Halden</li>
          <li>Hobøl</li>
          <li>Indre Østfold</li>
          <li>Moss</li>
          <li>Rygge</li>
          <li>Råde</li>
          <li>Sarpsborg</li>
        </ul>
        <p>
          Her arrangeres kurs og aktiviteter i et bredt spekter av
          håndverksteknikker, for ulike nivåer og aldersgrupper.
        </p>
      </section>

      <aside className="kurs-kort">
        <Link to="/kurs">
          <img src="/bilder/kurs.jpg" alt="" />
          <span className="kort-tekst">
            Kurs og aktiviteter
            {/* aria satt til hidden så skjermleser ikke leser opp pil */}
            <span className="pil" aria-hidden="true">→</span>
          </span>
        </Link>
      </aside>

      {/* boks for å melde seg inn, gjenbruker .bli-medlem fra Aktuelt. */}
      <section className="bli-medlem" aria-labelledby="medlem-tittel">
        <h2 id="medlem-tittel">Bli medlem i Østfold Husflidslag</h2>
        <p>Få rabatt på kurs og bli med i et lokallag nær deg.</p>
        <Link to="/aktuelt">Les mer</Link>
      </section>
    </main>
  );
}