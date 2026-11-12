import { Routes, Route } from 'react-router';
import Toppfelt from './komponenter/Toppfelt.jsx';
import Sidefelt from './komponenter/Sidefelt.jsx';
import Bunntekst from './komponenter/Bunntekst.jsx';
import Forside from './sider/Forside.jsx';
import KursOversikt from './sider/KursOversikt.jsx';
import KursInfo from './sider/KursInfo.jsx'
import IkkeFunnet from './sider/IkkeFunnet.jsx';
import Kontakt from './sider/Kontakt.jsx';
import Aktuelt from "./sider/Aktuelt";
import LoggInn from "./sider/LoggInn.jsx";
import OpprettBruker from './sider/OpprettBruker.jsx';

export default function App() {
  return (
    <>
    <Toppfelt />
    <Sidefelt />
    <Routes>
      <Route path='/' element={<Forside />} />
      <Route path='/kurs' element={<KursOversikt />} />
      <Route path='/kontakt' element={<Kontakt />} />
      <Route path='/kurs/:id' element={<KursInfo />} />
      <Route path='/aktuelt' element={<Aktuelt />} />
      <Route path='/logg-inn' element={<LoggInn />} />
      <Route path='/opprett-bruker' element={<OpprettBruker/>} />
      <Route path='*' element={<IkkeFunnet />} />
    </Routes>
    <Bunntekst />
    </>
  );
}