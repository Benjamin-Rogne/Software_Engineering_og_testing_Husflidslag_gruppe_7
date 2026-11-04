// Henter kurs fra backend og gjør dataene klar for komponentene

// Områdene som vises i filteret på kurssiden
export const OMRADER = [
  "Fredrikstad", "Sarpsborg", "Moss", "Halden",
  "Råde", "Hobøl", "Rygge", "Indre Østfold",
];

// Kobler omraade_id fra backend til navn
const OMRADE_NAVN = {
  1: "Halden",
  2: "Fredrikstad",
  3: "Sarpsborg",
  4: "Moss",
};

// Finner områdenavnet. Er id-en ukjent, letes det etter byen i adressen.
function finnOmrade(kurs) {
  return (
    OMRADE_NAVN[kurs.omraade_id] ??
    OMRADER.find((omrade) => kurs.adresse?.includes(omrade)) ??
    ""
  );
}

// Backend sender "2026-11-20 10:00", men JavaScript trenger "2026-11-20T10:00"
function tilDatoTid(tekst) {
  return tekst ? tekst.replace(" ", "T") : "";
}

// Gjør om ett kurs fra backend til feltene komponentene bruker
function tilFrontend(kurs) {
  return {
    id: kurs.kurs_id,
    tittel: kurs.tittle,
    pris: kurs.pris,
    adresse: kurs.adresse,
    start: tilDatoTid(kurs.start_dato),
    slutt: tilDatoTid(kurs.slutt_dato),
    omrade: finnOmrade(kurs),
    bilde: "/bilder/kurs.jpg", // backend har ikke bilder ennå
  };
}

// Henter alle kurs
export async function hentAlleKurs() {
  const svar = await fetch("/api/kurs");

  if (!svar.ok) {
    throw new Error("Kunne ikke hente kurs");
  }

  const kursFraBackend = await svar.json();
  return kursFraBackend.map(tilFrontend);
}

export async function hentKurs(id) {
  const alleKurs = await hentAlleKurs();
  return alleKurs.find((kurs) => kurs.id === Number(id)) ?? null;
}