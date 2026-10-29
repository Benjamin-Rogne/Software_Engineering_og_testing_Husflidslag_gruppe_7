import { Routes, Route } from 'react-router';
import Sidefelt from './komponenter/Sidefelt.jsx';
import Bunntekst from './komponenter/Bunntekst.jsx';
import Forside from './sider/Forside.jsx';
import KursOversikt from './sider/KursOversikt.jsx';
import KursInfo from './sider/KursInfo.jsx'
import IkkeFunnet from './sider/IkkeFunnet.jsx';
import Kontakt from './sider/Kontakt.jsx';


export default function App() {
  return (
    <>
    <Sidefelt />
    <Routes>
      <Route path='/' element={<Forside />} />
      <Route path='/kurs' element={<KursOversikt />} />
      <Route path='/kontakt' element={<Kontakt />} />
      <Route path='/kurs/:id' element={<KursInfo />} />
      <Route path='*' element={<IkkeFunnet />} />
    </Routes>
    <Bunntekst />
    </>
  );
}