// henter kurs fra backend og endrer format til frontend

//alle områder i filteret
export const OMRADER = [
  "Fredrikstad", "Sarpsborg", "Moss", "Halden",
  "Råde", "Hobøl", "Rygge", "Indre Østfold",
];

// endrer fra id tall til nummer
const OMRADE_NAVN = {
  1: "Halden",
  2: "Fredrikstad",
  3: "Sarpsborg",
  4: "Moss",
};

// finner områdenavnet, prøver omraade_id, for så om adressen inneholder stedsnavn
// bruker ?? til å søke etter neste vist den ikke får treff
function finnOmrade(kurs) {
  return (
    OMRADE_NAVN[kurs.omraade_id] ??
    OMRADER.find((omrade) => kurs.adresse?.includes(omrade)) ??
    ""
  );
}

// bytter mellomrom med T så JS forstår datoen
function tilDatoTid(tekst) {
  return tekst ? tekst.replace(" ", "T") : "";
}

// endrer feltnavnene brukt i backend til de som brukes i frontend
function tilFrontend(kurs) {
  return {
    id: kurs.kurs_id,
    tittel: kurs.tittle,
    pris: kurs.pris,
    adresse: kurs.adresse,
    start: tilDatoTid(kurs.start_dato),
    slutt: tilDatoTid(kurs.slutt_dato),
    omrade: finnOmrade(kurs),
    bilde: "/bilder/kurs.jpg", // samme bilde for alle til det ligger bilder i backend
  };
}

// henter kursene fra backend, viser feilmelding hvis backend ikke svarer
export async function hentAlleKurs() {
  const svar = await fetch("/api/kurs");

  if (!svar.ok) {
    throw new Error("Kunne ikke hente kurs");
  }

  const kursFraBackend = await svar.json();
  return kursFraBackend.map(tilFrontend);
}


// henter foreløpig ett kurs ved å lete gjennom alle
export async function hentKurs(id) {
  const alleKurs = await hentAlleKurs();
  return alleKurs.find((kurs) => kurs.id === Number(id)) ?? null;
}