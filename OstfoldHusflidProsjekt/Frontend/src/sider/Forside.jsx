import { Link } from 'react-router';
import { ArrowRight } from 'lucide-react';

export default function Forside() {
    return (
        <main className='innhold'>
            <h1>Velkommen til husflid i Østfold</h1>
            <img className='tittel-stjerne' src='/bilder/stjerne.png' alt='' />

            <section className='intro' aria-label='Om Østfold Husflidslag'>
                <p> Tekstlig innhold om Østfold husflid.</p>
                <p>Videre avsnitt om Østfold husflid.</p>
            </section>

            <figure className='hovedbilde'>
                <img src='/bilder/hovedbilde.jpg' alt='Bunad som håndverk' />
            </figure>

            <section className='lokallag' aria-labelledby='lokallag-tittel'>
                <h2 id='lokallag-tittel'>Her finner du oss:</h2>
                <ul className='stedliste'>
                    <li>Fredrikstad</li>
                    <li>Halden</li>
                    <li>Hobøl</li>
                    <li>Indre Østfold</li>
                    <li>Moss</li>
                    <li>Rygge</li>
                    <li>Råde</li>
                    <li>Sarpsborg</li>
                </ul>
                <p>
                    Her arrangeres kurs og aktiviteter i et bredt spekter av
                    håndverksteknikker, for ulike nivåer og aldersgrupper.
                </p>
            </section>
            {}
            <aside className='kurs-kort'>
                <Link to='/kurs'>
                <img src='/bilder/kurs.jpg' alt='' />
                <span className='kort-tekst'>
                    Kurs og aktiviteter
                    <ArrowRight className='pil' aria-hidden='true' />
                </span>
                </Link>
            </aside>
        </main>
    );
}