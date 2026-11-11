
const alleSporsmal = [
  {
    sporsmal: "Hvordan melder jeg meg på et kurs?",
    svar: "Gå til Kurs og aktiviteter, velg et kurs og trykk på Meld deg på.",
  },
  {
    sporsmal: "Må jeg være medlem for å delta på kurs?",
    svar: "Nei, kursene er åpne for alle. Medlemmer får rabatt på kursavgiften.",
  },
  {
    sporsmal: "Hvordan blir jeg medlem?",
    svar: "Nei kursene er åpne for alle. Medlemmer får rabatt på kursavgiften",
  },
  {
    sporsmal: "Hvordan finner jeg lokallaget mitt?",
    svar: "Gå til Våre lokallag for å se alle lokallagene i Østfold.",
  },
  {
    sporsmal: "Hvordan kontakter jeg dere?",
    svar: "Send en e-post til ostfoldhusflid@gmail.com eller ring +47 917 77 582.",
  },
];

export default function Faq() {
  return (
    <main className="arrangement">
      <article className="arrangement-innhold">
        <h1>Ofte stilte spørsmål</h1>

        {alleSporsmal.map((s) => (
          <section className="kort" key={s.sporsmal}>
            <details>
              <summary>{s.sporsmal}</summary>
              <p>{s.svar}</p>
            </details>
          </section>
        ))}
      </article>
    </main>
  );
}