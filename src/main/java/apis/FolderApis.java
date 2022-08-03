package apis;

import io.restassured.http.Header;

import static helpers.Config.URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class FolderApis {

    public void createFolder(String token, String path) {
        given()
                .queryParam("path", path)
                .header(new Header("Authorization", token))
                .contentType("application/j1son")
                .accept("application/json")
                .when()
                .put(URL + "/resources")
                .then()
                .assertThat().statusCode(201)
                .body(equalTo("{\"href\":\"https://cloud-api.yandex.net/v1/disk/resources?path=disk%3A%2FTestFolder%2F\",\"method\":\"GET\",\"templated\":false}"));
    }

    public void deleteFolder(String token, String path) {
        given()
                .queryParam("path", path)
                .header(new Header("Authorization", token))
                .contentType("application/j1son")
                .accept("application/json")
                .when()
                .delete(URL + "/resources")
                .then()
                .assertThat().statusCode(204);
    }

}
