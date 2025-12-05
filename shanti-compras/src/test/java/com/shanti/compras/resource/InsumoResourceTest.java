package com.shanti.compras.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class InsumoResourceTest {

    @Test
    void testListarInsumosEndpoint() {
        given()
            .when().get("/api/insumos")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON);
    }

    @Test
    void testListarEstoqueBaixo() {
        given()
            .when().get("/api/insumos/estoque-baixo/10")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON);
    }

    @Test
    void testBuscarInsumoNaoEncontrado() {
        given()
            .when().get("/api/insumos/99999")
            .then()
            .statusCode(404);
    }
}