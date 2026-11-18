const nyheter = [
    { dato: "01.06.2026", tittel: "Høstens kurskatalog 2026", lenke: "https://husflid.no/lokallag-nyhet/hostens-kurskatalog-2026/" },
    { dato: "04.12.2025", tittel: "Sy lomme/sjal/løsermer til Herregårdsbunaden din", lenke: "https://husflid.no/lokallag-nyhet/sy-lomme-sjal-losermer-til-herregardsbunaden-din/" },
    { dato: "16.07.2025", tittel: "Kurs: Sy 1700-talls lue til bunaden", lenke: "https://husflid.no/lokallag-nyhet/kurs-sy-1700-talls-lue-til-bunaden/" },
    { dato: "16.07.2025", tittel: "Kurskatalogen høst 2025", lenke: "https://husflid.no/lokallag-nyhet/kurskatalogen-host-2025/" },
    { dato: "27.01.2025", tittel: "Østfold Husflidslag inviterer på tur til FÅRfesten i Kil 2025 lørdag 1.03.25", lenke: "https://husflid.no/lokallag-nyhet/ostfold-husflidslag-inviterer-pa-tur-til-farfesten-i-kil-2025-lordag-1-03-25/" },
    { dato: "06.06.2024", tittel: "Sarpsborg Husflidslag inviterer til Jubileumsutstilling 1974 – 2024 9.06.–22.09.2024", lenke: "https://husflid.no/lokallag-nyhet/sarpsborg-husflidslag-inviterer-til-jubileumsutstilling-1974-2024-9-06-22-09-2024/" },
    { dato: "22.06.2022", tittel: "VEV inspirasjon i Dreil kunstskatter fra Østfold", lenke: "https://husflid.no/lokallag-nyhet/vev-inspirasjon-i-dreil-kunstskatter-fra-ostfold/" },
    { dato: "08.06.2022", tittel: "Bli med til VEVMESSEN I HALMSTAD – påmelding!", lenke: "https://husflid.no/lokallag-nyhet/bli-med-til-vevmessen-i-halmstad-pamelding/" },
];

export default function Aktuelt() {
    return (
        <main className="aktuelt">
            <h1>Aktuelt</h1>

            <ul className="nyheter">
                {nyheter.map((nyhet) => (
                    <li key={nyhet.lenke}>
                        <small>{nyhet.dato}</small><br />
                        <a href={nyhet.lenke}>{nyhet.tittel}</a><br />
                        <small>Østfold Husflidslag</small>
                    </li>
                ))}
            </ul>

            <p className="bli-medlem">
                <strong>Bli medlem i Norges Husflidslag!</strong><br />
                Medlemskapet gir kunnskap og inspirasjon og du får utviklet din skaperevne
                i et kreativt og hyggelig miljø.<br />
                <a href="https://husflid.no/om-norges-husflidslag/blimedlem/">Bli medlem</a>
            </p>
        </main>
    );
}