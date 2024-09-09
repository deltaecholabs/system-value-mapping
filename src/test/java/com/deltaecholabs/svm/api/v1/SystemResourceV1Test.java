package com.deltaecholabs.svm.api.v1;

import com.deltaecholabs.svm.api.Role;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class SystemResourceV1Test {

    @Test
    @TestSecurity(user = "test", roles = Role.SVM_SYSTEM_READ)
    public void getAll() {
        SystemV1[] systems = given()
                .when()
                .get("/api/v1/systems")
                .then()
                .statusCode(200)
                .extract().as(SystemV1[].class);
        assertNotNull(systems);
        assertTrue(List.of(systems).contains(new SystemV1("system1", "System One")));
    }

}
