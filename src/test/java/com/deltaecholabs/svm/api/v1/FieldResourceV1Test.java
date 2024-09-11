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
public class FieldResourceV1Test {

    @Test
    @TestSecurity(user = TestData.USER_TEST, roles = Role.SVM_FIELD_READ)
    public void getAll() {
        FieldV1[] fields = given()
                .when()
                .get("/api/v1/fields")
                .then()
                .statusCode(200)
                .extract().as(FieldV1[].class);
        assertNotNull(fields);
        assertTrue(List.of(fields).contains(TestData.FIELD_ONE));
    }

}
