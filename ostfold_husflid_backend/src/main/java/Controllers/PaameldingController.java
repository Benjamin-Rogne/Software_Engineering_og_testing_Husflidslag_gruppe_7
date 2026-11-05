package controllers;

import repositories.PaameldingRepository;

import javax.naming.Context;

public class PaameldingController {
    private PaameldingRepository paameldingRepository;

    public PaameldingController(PaameldingRepository paameldingRepository) {
        this.paameldingRepository = paameldingRepository;
    }

    public void leggTilPaamelding(Context ctx) {
        // Her putter du koden som var i lambda-uttrykket:
        int idbruker = Integer.parseInt(ctx.formParam("idbruker"));
        int idkurs = Integer.parseInt(ctx.formParam("idkurs"));
        int aktivitet_id = Integer.parseInt(ctx.formParam("aktivitet_id"));

        boolean vellykket = paameldingRepository.leggTilPaamelding(idbruker, idkurs, aktivitet_id);

        if (vellykket) {
            ctx.status(201).result("Du er nå påmeldt!");
        } else {
            ctx.status(400).result("Kunne ikke melde på.");
        }
    }
}