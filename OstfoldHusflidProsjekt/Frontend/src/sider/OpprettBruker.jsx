import { useState } from "react";
import { Link } from "react-router";
import { opprettBruker } from "../api/bruker.js";

// Registrere ny bruker.
// Skjema + bekreftelse når den er opprettet.
export default function OpprettBruker() {
  const [navn, setNavn] = useState("");
  const [epost, setEpost] = useState("");
  const [passord, setPassord] = useState("");
  const [gjentaPassord, setGjentaPassord] = useState("");
 
 // Feilmelding under skjeamet og om brukereren er opprettet
  const [feil, setFeil] = useState("");
  const [opprettet, setOpprettet] = useState(false);

  async function handleSubmit(e) {
    e.preventDefault(); // stoppe at siden lastes på nytt
    setFeil("");

    // Sjekker om passordene matcher
    if (passord !== gjentaPassord) {
      setFeil("Passordene er ikke like.");
      return;
    }

    // Sender bruker til backend, gir feilmelding dersom noe går galt/ epost eksisterer fra før
    try {
      await opprettBruker(navn, epost, passord);
      setOpprettet(true);
    } catch (e) {
      setFeil(e.message);
    }
  }

  // Bytter ut skjema med bekreftelse når brukeren er opprettet  
  if (opprettet) {
    return (
      <main className="logg-inn-side">
        <section className="logg-inn-kort" aria-labelledby="ferdig-tittel">
          <h1 id="ferdig-tittel">Bruker opprettet</h1>
          <p className="logg-inn-ingress">Velkommen, {navn}! Du kan nå logge inn.</p>
          <Link to="/logg-inn" className="knapp-fylt">Gå til innlogging</Link>
        </section>
      </main>
    );
  }

  return (
    <main className="logg-inn-side">
      <section className="logg-inn-kort" aria-labelledby="opprett-tittel">
        <h1 id="opprett-tittel">Opprett bruker</h1>
        <p className="logg-inn-ingress">
          Med egen bruker kan du melde deg på kurs og se dine påmeldinger.
        </p>
        {/* ?? */}
        <form className="skjema" onSubmit={handleSubmit}>
          <label>
            Navn
            <input
              type="text"
              autoComplete="name"
              required
              value={navn}
              onChange={(e) => setNavn(e.target.value)}
            />
          </label>

          <label>
            E-post
          {/* nettleser sjekker at e-posten er gyldig */}
            <input
              type="email"
              autoComplete="email"
              required
              value={epost}
              onChange={(e) => setEpost(e.target.value)}
            />
          </label>

          <label>
            Passord
            {/*  */}
            <input
              type="password"
              autoComplete="new-password"
              minLength={8}
              required
              value={passord}
              onChange={(e) => setPassord(e.target.value)}
            />
          </label>

          <label>
            Gjenta passord
            <input
              type="password"
              autoComplete="new-password"
              required
              value={gjentaPassord}
              onChange={(e) => setGjentaPassord(e.target.value)}
            />
          </label>

          {/* vises når det finnes en feil. role får skjermleser til å lese opp feilmeldingen */}
          {feil && <p className="skjema-feil" role="alert">{feil}</p>}

          <Link to="/logg-inn" className="knapp-omriss">Tilbake</Link>
          <button type="submit" className="knapp-fylt">Opprett bruker</button>
        </form>
      </section>
    </main>
  );
}