// lokallagkort
export default function LokallagKort({ lag }) {
    return (
        <article className='kurs-kort'>
            <h3>{lag.navn}</h3>
            <p>Adresse: {lag.adresse}</p>
        </article>
    );
}