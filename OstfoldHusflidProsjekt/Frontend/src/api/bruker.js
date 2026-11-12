// Gjør om brukeren fra backend (BrukerDTO) til feltene komponentene bruker
function tilFrontend(bruker) {
  return {
    id: bruker.id,
    navn: bruker.navn,
    epost: bruker.epost,
  };
}

export async function loggInn(epost, passord) {
  if (DEMO) {
    const bruker = DEMO_BRUKERE.find(
      (b) => b.epost === epost && b.passord === passord
    );
    if (!bruker) throw new Error("Feil e-post eller passord");

    sessionStorage.setItem("demoBruker", JSON.stringify(tilFrontend(bruker)));
    return tilFrontend(bruker);
  }

  const svar = await fetch("/api/logg-inn", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ epost, passord }),
  });

  if (svar.status === 401) throw new Error("Feil e-post eller passord");
  if (!svar.ok) throw new Error("Kunne ikke logge inn. Prøv igjen senere.");

  return tilFrontend(await svar.json());
}

export async function hentInnloggetBruker() {
  if (DEMO) {
    const lagret = sessionStorage.getItem("demoBruker");
    return lagret ? JSON.parse(lagret) : null;
  }

  const svar = await fetch("/api/meg");
  if (svar.status === 401) return null;
  if (!svar.ok) throw new Error("Kunne ikke hente bruker");
  return tilFrontend(await svar.json());
}


export async function loggUt() {
  if (DEMO) {
    sessionStorage.removeItem("demoBruker");
    return;
  }

  await fetch("/api/logg-ut", { method: "POST" });
}

export async function opprettBruker(navn, epost, passord) {
  const svar = await fetch("/api/brukere", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ navn, epost, passord }),
  });

  if (svar.status === 400) throw new Error(await svar.text());
  if (!svar.ok) throw new Error("Kunne ikke opprette bruker. Prøv igjen senere.");

  return tilFrontend(await svar.json());
}