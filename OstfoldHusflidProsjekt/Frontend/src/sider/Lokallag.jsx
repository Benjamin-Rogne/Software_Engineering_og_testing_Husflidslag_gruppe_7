import LokallagKort from '../komponenter/LokallagKort.jsx';
import { lokallagListe } from '../data/lokallag.js';

export default function Lokallag() {
    return (
        <main className='innhold'>
            <h1>Våre lokallag</h1>
            <section className='lokallag-liste' aria-label='Lokallag'>
                {lokallagListe.map((lag) => (
                    <LokallagKort key={lag.id} lag={lag} />
                ))}
            </section>
        </main>
    );
}