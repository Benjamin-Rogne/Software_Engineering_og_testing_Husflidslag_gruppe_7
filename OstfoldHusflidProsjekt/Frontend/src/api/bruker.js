// kobler til backend for login, loggge ut og reg av bruker

// endrer bruker fra backend til felter som brukes
function tilFrontend(bruker) {
  return {
    id: bruker.id,
    navn: bruker.navn,
    epost: bruker.epost,
  };
}

// sender epost + passord, brukeren huskes for økten
export async function loggInn(epost, passord) {
  const svar = await fetch("/api/logg-inn", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ epost, passord }),
  });

  if (svar.status === 401) throw new Error("Feil e-post eller passord");
  if (!svar.ok) throw new Error("Kunne ikke logge inn. Prøv igjen senere.");

  return tilFrontend(await svar.JSON());
  
}


// spør backend hvem som er innlogget. Forblir innlogget når side lastet
export async function hentInnloggetBruker() {
  const svar = await fetch("/api/meg");

  if (svar.status === 401) return null;
  if (!svar.ok) throw new Error("Kunne ikke hente bruker");

  return tilFrontend(await svar.JSON());
}

//backend sletter økten
export async function loggUt() {
  await fetch("/api/logg-ut", { method: "POST"});
}


// oppretter ny bruker. Ved 400 vises feilmelding fra backend (eks. eposten er i bruk)
export async function opprettBruker(navn, epost, passord) {
  const svar = await fetch("/api/brukere", {
    method:"POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ navn, epost, passord }),
  });

  if (svar.status === 400) throw new Error(await svar.text());
  if (!svar.ok) throw new Error("Kunne ikke opprette bruker. Prøv igjen senere.");
}