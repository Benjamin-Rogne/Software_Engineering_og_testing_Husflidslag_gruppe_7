import { useState } from 'react';

export default function Pamelding({ kursNavn }) {
  const [visSkjema, setVisSkjema] = useState(false);
  const [navn, setNavn] = useState('');
  const [epost, setEpost] = useState('');
  const [pameldt, setPameldt] = useState(false);

  function sendInn() {
    if (!navn || !epost) {
      alert('Fyll inn navn og e-post');
      return;
    }
    setPameldt(true);
  }

  if (pameldt) {
    return <p>Takk, {navn}! Du er påmeldt {kursNavn}.</p>;
  }

  if (!visSkjema) {
    return <button onClick={() => setVisSkjema(true)}>Meld deg på</button>;
  }

  return (
    <>
      <input placeholder='Navn' value={navn} onChange={(e) => setNavn(e.target.value)} />
      <input placeholder='E-post' value={epost} onChange={(e) => setEpost(e.target.value)} />
      <button onClick={sendInn}>Send påmelding</button>
    </>
  );
}