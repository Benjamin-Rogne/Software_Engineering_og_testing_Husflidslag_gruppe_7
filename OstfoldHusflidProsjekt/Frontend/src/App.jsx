import { useEffect, useState } from "react";
import { Routes, Route } from "react-router";
import { hentInnloggetBruker } from "./api/bruker.js";
import Toppfelt from "./komponenter/Toppfelt.jsx";
import Sidefelt from "./komponenter/Sidefelt.jsx";
import Bunntekst from "./komponenter/Bunntekst.jsx";
import Forside from "./sider/Forside.jsx";
import KursOversikt from "./sider/KursOversikt.jsx";
import KursInfo from "./sider/KursInfo.jsx";
import Kontakt from "./sider/Kontakt.jsx";
import Aktuelt from "./sider/Aktuelt.jsx";
import LoggInn from "./sider/LoggInn.jsx";
import OpprettBruker from "./sider/OpprettBruker.jsx";
import IkkeFunnet from "./sider/IkkeFunnet.jsx";


//ramme rundt alle sider: toppfelt, meny, innhold og bunntekst
export default function App() {
  // hvem som er innlogger, null betyr at ingen har logget inn
  const [bruker, setBruker] = useState(null);


  //Sjekker med backend om noen allerede er innlogget, så man ikke logges ut ved f5
  useEffect(() => {
    hentInnloggetBruker()
      .then(setBruker)
      .catch(() => setBruker(null));
  }, []);

  return (
    <>
    {/* toppfelt og meny vises på alle sider */}
      <Toppfelt bruker={bruker} setBruker={setBruker} />
      <Sidefelt />

      {/* kun en av sidene vises om gangen, avhenging av adressen */}
      <Routes>
        <Route path="/" element={<Forside />} />
        <Route path="/kurs" element={<KursOversikt />} />
        {/* :id er en variabel, eks /kurs/3 */}
        <Route path="/kurs/:id" element={<KursInfo />} />
        <Route path="/aktuelt" element={<Aktuelt />} />
        <Route path="/kontakt" element={<Kontakt />} />
        {/* Logginn får setbruker så toppfeltet oppdateres etter innlogging */}
        <Route path="/logg-inn" element={<LoggInn setBruker={setBruker} />} />
        <Route path="/opprett-bruker" element={<OpprettBruker />} />
        {/* *= alle adresser som ikke finnes */}
        <Route path="*" element={<IkkeFunnet />} />
      </Routes>
      <Bunntekst />
    </>
  );
}