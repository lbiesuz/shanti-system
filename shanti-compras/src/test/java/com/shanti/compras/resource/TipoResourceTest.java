package com.shanti.compras.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
class TipoResourceTest {

    @Test
    void testListarTiposEndpoint() {
        given()
            .when().get("/api/tipos")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON);
    }

    @Test
    void testCriarTipo() {
        String novoTipo = """
            {
                "descricao": "Tipo Teste"
            }
            """;

        given()
            .contentType(ContentType.JSON)
            .body(novoTipo)
            .when().post("/api/tipos")
            .then()
            .statusCode(201)
            .body("descricao", equalTo("Tipo Teste"));
    }

    @Test
    void testBuscarTipoNaoEncontrado() {
        given()
            .when().get("/api/tipos/99999")
            .then()
            .statusCode(404);
    }
}