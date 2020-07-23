package org.techmeskills.aqa5.auf.apiTest;

import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.techmeskills.aqa5.auf.models.ProjectLombok;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class apiTestLombok extends BaseApiTest {

    @Test
    public void create() {
        String endpoint = "/api/users";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("leader")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
        .when()
                .post(endpoint)
        .then()
                .log().body()
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void updatePut() {
        String endpoint = "/api/users/2";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
        .when()
                .put(endpoint)
        .then()
                .log().body()
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void updatePatch() {
        String endpoint = "/api/users/2";

        ProjectLombok project = ProjectLombok.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("job", project.getJob());

        given()
                .body(jsonAsMap)
        .when()
                .patch(endpoint)
        .then()
                .log().body()
                .body("name", is("morpheus"))
                .body("job", is("zion resident"))
                .statusCode(HttpStatus.SC_OK);
    }

     @Test
    public void registerSuccessful() {
        String endpoint = "/api/register";

         ProjectLombok project = ProjectLombok.builder()
                 .email("eve.holt@reqres.in")
                 .password("pistol")
                 .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
        .when()
                .post(endpoint)
        .then()
                .log().body()
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void registerUnsuccessful() {
        String endpoint = "/api/register";

        ProjectLombok project = ProjectLombok.builder()
                .email("sydney@fife")
                .build();

        given()
                .body(project, ObjectMapperType.GSON)
        .when()
                .post(endpoint)
        .then()
                .log().body()
                .body("error", is("Missing password"))
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void loginSuccessful() {
        String endpoint = "/api/login";

        ProjectLombok project = ProjectLombok.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", project.getEmail());
        jsonAsMap.put("password", project.getPassword());

        given()
                .body(jsonAsMap)
        .when()
                .post(endpoint)
        .then()
                .log().body()
                .body("token", is("QpwL5tke4Pnpja7X4"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void loginUnsuccessful() {
        String endpoint = "/api/login";

        ProjectLombok project = ProjectLombok.builder()
                .email("peter@klaven")
                .build();

        given()
                .body(project, ObjectMapperType.GSON)
        .when()
                .post(endpoint)
        .then()
                .log().body()
                .body("error", is("Missing password"))
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
