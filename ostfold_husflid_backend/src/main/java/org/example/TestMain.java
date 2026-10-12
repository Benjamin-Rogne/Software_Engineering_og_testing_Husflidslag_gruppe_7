package org.example;
import io.javalin.Javalin;

public class TestMain {

    void main() {
        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
        }).start(7070);
    }
}
