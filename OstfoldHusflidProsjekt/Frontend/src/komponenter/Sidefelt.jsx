import { Link, NavLink } from 'react-router';

export default function Sidefelt() {
    return (
        <header className='sidefelt'>
            <Link to='/' className='logo'>
                <img src='/bilder/logo.png' alt='Østfold Husflidslag - til forsiden' />
            </Link>

            <nav className='meny' aria-label='Hovedmeny'>
                <ul>
                    <li><NavLink to="/aktuelt">Aktuelt</NavLink></li>
                    <li><NavLink to="/lokallag">Våre lokallag</NavLink></li>
                    <li><NavLink to="/kurs">Kurs og aktiviteter</NavLink></li>
                    <li><NavLink to="/kontakt">Kontakt oss</NavLink></li>
                    <li><NavLink to="/faq">Ofte stilte spørsmål</NavLink></li>
                </ul>
            </nav>
        </header>
    );
}