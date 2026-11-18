import { useState } from "react";
import { Link, useNavigate } from "react-router";
import { loggInn } from "../api/bruker.js";


export default function LoggInn({ setBruker }) {
  const [epost, setEpost] = useState("");
  const [passord, setPassord] = useState("");
  //feilmelding
  const [melding, setMelding] = useState("");
  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault(); // stopper siden fra å laste på nytt
    setMelding("");

    try {
      const bruker = await loggInn(epost, passord);
      // navn på innlogget bruker vises på toppen
      setBruker(bruker); 
      // sender brukeren til kurs
      navigate("/kurs");   
    } catch (feil) {
      // sender feilmelding med feil epost eller passord
      setMelding(feil.message);
    }
  }

  return (
    <main className="logg-inn-side">
      <section className="logg-inn-kort" aria-labelledby="logg-inn-tittel">
        <h1 id="logg-inn-tittel">Logg inn</h1>
        <p className="logg-inn-ingress">
          Logg inn for å melde deg på kurs og se dine påmeldinger.
        </p>

        <form className="skjema" onSubmit={handleSubmit}>
          <label>
            E-post
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
            <input
              type="password"
              autoComplete="current-password"
              required
              value={passord}
              onChange={(e) => setPassord(e.target.value)}
            />
          </label>

          <Link to="/opprett-bruker" className="knapp-omriss">Opprett bruker</Link>
          <button type="submit" className="knapp-fylt">Logg inn</button>
          {/* vises hvis det går feil ved innlogging */}
          {melding && <p className="skjema-feil" role="alert">{melding}</p>}
        </form>
      </section>
    </main>
  );
}