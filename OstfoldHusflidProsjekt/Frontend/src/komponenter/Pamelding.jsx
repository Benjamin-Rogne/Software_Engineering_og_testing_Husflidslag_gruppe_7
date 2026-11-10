import { useState } from 'react';

export default function Pamelding({ kursNavn, startAntall = 0 }) {
  const [visSkjema, setVisSkjema] = useState(false);
  const [navn, setNavn] = useState('');
  const [epost, setEpost] = useState('');
  const [pameldt, setPameldt] = useState(false);
  const [antall, setAntall] = useState(startAntall);

  function sendInn() {
    if (!navn || !epost) {
      alert('Fyll inn navn og e-post');
      return;
    }
    setAntall(antall + 1);
    setPameldt(true);
  }

  const antallTekst = <p><strong>Påmeldte:</strong> {antall}</p>;

  if (pameldt) {
    return (
      <>
        {antallTekst}
        <p>Takk, {navn}! Du er påmeldt {kursNavn}.</p>
      </>
    );
  }

  if (!visSkjema) {
    return (
      <>
        {antallTekst}
        <button onClick={() => setVisSkjema(true)}>Meld deg på</button>
      </>
    );
  }

  return (
    <>
      {antallTekst}
      <input placeholder='Navn' value={navn} onChange={(e) => setNavn(e.target.value)} />
      <input placeholder='E-post' value={epost} onChange={(e) => setEpost(e.target.value)} />
      <button onClick={sendInn}>Send påmelding</button>
    </>
  );
}