package com.deltaecholabs.api.system;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class SystemResourceTest {

    @Test
    public void getAll() {
        given()
                .when()
                .get("/api/v1/systems")
                .then()
                .statusCode(200);
    }

    @Test
    public void getById() {
        System system = createSystem();
        System saved = given()
                .contentType(ContentType.JSON)
                .body(system)
                .post("/api/v1/systems")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .extract().as(System.class);
        System got = given()
                .when()
                .get("/api/v1/systems/{systemId}", saved.systemId())
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .extract().as(System.class);
        assertThat(saved).isEqualTo(got);
    }

    @Test
    public void getByIdNotFound() {
        given()
                .when()
                .get("/api/v1/systems/{systemId}", 987654321)
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    public void post() {
        System system = createSystem();
        System saved = given()
                .contentType(ContentType.JSON)
                .body(system)
                .post("/api/v1/systems")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .extract().as(System.class);
        assertThat(saved.systemId()).isNotNull();
    }

    @Test
    public void postFailNoName() {
        System system = new System(null, null);
        given()
                .contentType(ContentType.JSON)
                .body(system)
                .post("/api/v1/systems")
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    public void put() {
        System system = createSystem();
        System saved = given()
                .contentType(ContentType.JSON)
                .body(system)
                .post("/api/v1/systems")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .extract().as(System.class);
        System updated = new System(saved.systemId(), saved.name());
        given()
                .contentType(ContentType.JSON)
                .body(updated)
                .put("/api/v1/systems/{systemId}", updated.systemId())
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void putFailNoName() {
        System system = createSystem();
        System saved = given()
                .contentType(ContentType.JSON)
                .body(system)
                .post("/api/v1/systems")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .extract().as(System.class);
        System updated = new System(saved.systemId(), null);
        given()
                .contentType(ContentType.JSON)
                .body(updated)
                .put("/api/v1/systems/{systemId}", updated.systemId())
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    private System createSystem() {
        return new System(null, RandomStringUtils.randomAlphabetic(10));
    }

}