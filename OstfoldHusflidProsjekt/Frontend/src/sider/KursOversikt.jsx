import KursKort from '../komponenter/KursKort.jsx';
import { kursListe } from '../data/kurs.js';

const omrader = [
    "Fredrikstad", "Sarpsborg", "Moss", "Halden",
    "Råde", "Hobøl", "Rygge", "Indre Østfold",
];

export default function KursOversikt() {
    return (
        <main className='innhold kursside'>
            <h1>Kurs og aktiviteter</h1>

            {}
            <section className='kurs-filtrering' aria-label='Filtrer kurs'>
                <form onSubmit={(e) => e.preventDefault()}>
                    <label htmlFor='sortering'>Sorter etter:</label>
                    <select id='sortering' name='sortering'>
                        <option value='dato'>Dato</option>
                        <option value='pris'>Pris</option>
                        <option value='type'>Type kurs</option>
                    </select>

                    <select id='omraade' name='omraade' aria-label='Område'>
                        <option value=''>Hele Østfold</option>
                        {omrader.map((omrade) => (
                            <option key={omrade} value={omrade}>{omrade}</option>
                        ))}
                    </select>

                    <button type='submit'>Sorter</button>
                </form>
            </section>

            <section className='kurs-container' aria-label='kurs'>
                {kursListe.map((kurs) => (
                    <KursKort key={kurs.id} kurs={kurs} />
                ))}
            </section>
        </main>
    );
}