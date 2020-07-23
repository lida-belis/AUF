package org.techmeskills.aqa5.auf.apiTest;

import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.techmeskills.aqa5.auf.baseEntity.BaseApiTest;
import org.techmeskills.aqa5.auf.models.Project;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class apiTest extends BaseApiTest {

    @Test
    public void listUsers() {
        String endpoint = "/api/users?page=2";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("page", is(2))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void singleUser() {
        String endpoint = "/api/users/2";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("data.id", is(2))
//                .body("id", is(2))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void singleUserNotFound() {
        String endpoint = "/api/users/23";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void listResource() {
        String endpoint = "/api/unknown";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("page", is(1))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void singleResource() {
        String endpoint = "/api/unknown/2";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("data.id", is(2))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void singleResourceNotFound() {
        String endpoint = "/api/unknown/23";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void create() {
        String endpoint = "/api/users";

        Project project = new Project.Builder()
                .withName("morpheus")
                .withJob("leader")
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

        Project project = new Project.Builder()
                .withName("morpheus")
                .withJob("zion resident")
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

        Project project = new Project.Builder()
                .withName("morpheus")
                .withJob("zion resident")
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
    public void delete() {
        String endpoint = "/api/users/2";

        given()
        .when()
                .delete(endpoint)
        .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void registerSuccessful() {
        String endpoint = "/api/register";

        Project project = new Project.Builder()
                .withEmail("eve.holt@reqres.in")
                .withPassword("pistol")
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

        Project project = new Project.Builder()
                .withEmail("sydney@fife")
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

        Project project = new Project.Builder()
                .withEmail("eve.holt@reqres.in")
                .withPassword("cityslicka")
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

        Project project = new Project.Builder()
                .withEmail("peter@klaven")
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
    public void delayedResponse() {
        String endpoint = "/api/users?delay=3";

        given()
        .when()
                .get(endpoint)
        .then()
                .log().body()
                .body("page", is(1))
                .statusCode(HttpStatus.SC_OK);
    }
}
