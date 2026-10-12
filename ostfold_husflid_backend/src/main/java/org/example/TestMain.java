/*package org.example;
import io.javalin.Javalin;

public class TestMain {

    void main() {
        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
        }).start(7070);
    }
}
*/

// starter opp javalin og finner frem BrukerController på url: http://localhost:7000/api/brukere
package org.example;

import io.javalin.Javalin;
import controllers.BrukerController;

public class TestMain {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            BrukerController.registerRoutes(config);
        }).start(7000);

    }
}