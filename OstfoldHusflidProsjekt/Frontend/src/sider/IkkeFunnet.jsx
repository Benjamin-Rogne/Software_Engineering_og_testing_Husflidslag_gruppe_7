import { Link } from "react-router";

export default function IkkeFunnet() {
    return (
        <main className="ikke-funnet">
            <h1>Siden er ikke laget ennå</h1>
            <p><Link to="/">Tilbake til forsiden</Link></p>
        </main>
    );
}