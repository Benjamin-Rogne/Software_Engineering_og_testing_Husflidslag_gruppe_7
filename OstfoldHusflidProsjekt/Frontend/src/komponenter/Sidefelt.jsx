import { Link, NavLink } from 'react-router';


// meny til venstre + logo og lenker
export default function Sidefelt() {
    return (
        <header className='sidefelt'>

            {/* skille hovedmeny fra andre nav'er */}
            <nav className='meny' aria-label='Hovedmeny'>'
            {/* logoen funker som lenke til forside, alt definerer både sti og bildet */}
            <Link to='/' className='logo'>
                <img src='/bilder/logo.png' alt='Østfold Husflidslag - til forsiden' />
            </Link>


                {/* Navlink istedenfor link for å koble css slik at det viser hvilken side man er på */}
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