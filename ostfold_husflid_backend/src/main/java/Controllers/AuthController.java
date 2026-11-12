
package Controllers;

import DTOs.BrukerDTO;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.AuthService;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import services.AuthService;
import models.Bruker;
import DTOs.BrukerDTO;
import java.util.Optional;

public class AuthController {

    public static void registerRoutes(JavalinConfig config) {
        config.routes.post("/api/logg-inn", AuthController::loggInn);
        config.routes.get("/api/meg", AuthController::hentMeg);
        config.routes.post("/api/logg-ut", AuthController::loggUt);
    }

    private static final AuthService service = new AuthService();

    public static void hentMeg(Context ctx) {
        Integer brukerId = ctx.sessionAttribute("brukerId");

        if (brukerId == null) {
            ctx.status(401).result("Ikke logget inn");
            return;
        }

        service.hentBruker(brukerId)
                .ifPresentOrElse(
                        bruker -> ctx.json(bruker),
                        () -> ctx.status(404).result("Bruker finnes ikke")
                );
    }

    public static void loggInn(Context ctx) {
        LoginDTO login = ctx.bodyAsClass(LoginDTO.class);

        Optional<Bruker> bruker = service.loggInn(
                login.epost(), login.passord()
        );

        if (bruker.isEmpty()) {
            ctx.status(401).result("Feil e-post eller passord");
            return;
        }

        Bruker b = bruker.get();
        ctx.sessionAttribute("brukerId", b.getBruker_id());

        ctx.json(new BrukerDTO(
                b.getBruker_id(), b.getNavn(), b.getEpost()
        ));
    }

    public static void loggUt(Context ctx) {
        ctx.req().getSession().invalidate();
        ctx.status(204);
    }

    public record LoginDTO(String epost, String passord) {}
}

