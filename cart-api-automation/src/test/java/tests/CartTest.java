package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;

public class CartTest {

    @DataProvider(name = "productIds")
public Object[][] productIds() {
    return new Object[][]{
            {1},
            {5},
            {10}
    };
}



    @Test
    public void getAllCarts() {
        RestAssured.baseURI = "https://fakestoreapi.com";

        given()
        .when()
            .get("/carts")
        .then()
            .statusCode(200);
    }
@Test
public void getCartById() {
    RestAssured.baseURI = "https://fakestoreapi.com";

    given()
            .when()
            .get("/carts/1")
            .then()
            .statusCode(200)
            .log().all();
}
@Test
public void invalidCartId() {
    given()
            .when()
            .get("/carts/99999")
            .then()
            .log().all();
}
@Test
public void createCart() {
    RestAssured.baseURI = "https://fakestoreapi.com";

    String payload = "{ \"userId\": 5, \"date\": \"2020-02-03\", \"products\": [{\"productId\": 5, \"quantity\": 1}] }";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
    .when()
            .post("/carts")
    .then()
            .statusCode(201)    
            .log().all();
}

@Test
public void createCartWithInvalidPayload() {

    String payload = "{}";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
    .when()
            .post("/carts")
    .then()
            .log().all();
}
@Test
public void updateCart() {
    RestAssured.baseURI = "https://fakestoreapi.com";

    String payload = "{\n" +
            "\"userId\": 1,\n" +
            "\"date\": \"2025-06-30\",\n" +
            "\"products\": [\n" +
            "{\"productId\": 2, \"quantity\": 5}\n" +
            "]\n" +
            "}";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .put("/carts/7")
            .then()
            .statusCode(200)
            .log().all();
}
@Test
public void deleteCart() {
    RestAssured.baseURI = "https://fakestoreapi.com";

    given()
            .when()
            .delete("/carts/6")
            .then()
            .statusCode(200)
            .log().all();
}
@Test
public void loginTest() {

    RestAssured.baseURI = "https://fakestoreapi.com";

    String payload = "{ \"username\": \"mor_2314\", \"password\": \"83r5^_\" }";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
    .when()
            .post("/auth/login")
    .then()
    
            .log().all();
}

@Test
public void invalidLoginTest() {

      RestAssured.baseURI = "https://fakestoreapi.com";

    String payload = "{ \"username\": \"wrong\", \"password\": \"wrong\" }";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
    .when()
            .post("/auth/login")
    .then()
            .log().all();
}

@Test
public void validateCartSchema() {

    RestAssured.baseURI = "https://fakestoreapi.com";

    given()
    .when()
            .get("/carts/1")
    .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("cart-schema.json"));
}
@Test(dataProvider = "productIds")
public void createCartWithDifferentProducts(int productId) {

    RestAssured.baseURI = "https://fakestoreapi.com";

    String payload = "{ \"userId\": 5, \"date\": \"2020-02-03\", " +
            "\"products\": [{\"productId\": " + productId + ", \"quantity\": 1}] }";

    given()
            .header("Content-Type", "application/json")
            .body(payload)
    .when()
            .post("/carts")
    .then()
            .statusCode(201)
            .log().all();
}
}
    

