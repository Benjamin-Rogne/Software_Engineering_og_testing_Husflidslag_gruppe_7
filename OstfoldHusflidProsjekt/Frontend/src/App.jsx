import { Routes, Route } from 'react-router';
import Sidefelt from './komponenter/Sidefelt.jsx';
import Bunntekst from './komponenter/Bunntekst.jsx';
import Forside from './sider/Forside.jsx';
import KursOversikt from './sider/KursOversikt.jsx';
import KursInfo from './sider/KursInfo.jsx'
import IkkeFunnet from './sider/IkkeFunnet.jsx';
import Lokallag from './sider/Lokallag.jsx';


export default function App() {
  return (
    <>
    <Sidefelt />
    <Routes>
      <Route path='/' element={<Forside />} />
      <Route path='/kurs' element={<KursOversikt />} />
      <Route path='/kurs/:id' element={<KursInfo />} />
      <Route path='/lokallag' element={<Lokallag />} />
      <Route path='*' element={<IkkeFunnet />} />
    </Routes>
    <Bunntekst />
    </>
  );
}