// backend sender dato og klokkeslett samlet
// 2026-11-20T10:00 til 20.11.2026
export function formaterDato(datoTid) {
  return new Date(datoTid).toLocaleDateString("nb-NO");
}
 
// 2026-11-20T10:00 + 2026-11-20T14:00 til 10:00–14:00
export function formaterKlokkeslett(start, slutt) {
  const klokke = { hour: "2-digit", minute: "2-digit" };
  const fra = new Date(start).toLocaleTimeString("nb-NO", klokke);
  const til = new Date(slutt).toLocaleTimeString("nb-NO", klokke);
  return `${fra}–${til}`;
}
 