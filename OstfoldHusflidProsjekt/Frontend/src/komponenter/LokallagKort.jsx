// lokallagkort
export default function LokallagKort({ lag }) {
    return (
        <article className='lokallag-kort'>
            <h2>{lag.navn}</h2>
            <p>Adresse: {lag.adresse}</p>
        </article>
    );
}