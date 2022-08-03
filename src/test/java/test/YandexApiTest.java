package test;

import apis.FolderApis;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.POAuth;
import pages.PoligonPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class YandexApiTest {

    private String token;

    private final POAuth auth = new POAuth();
    private final FolderApis folderApis = new FolderApis();
    private final PoligonPage poligonPage = new PoligonPage();

    @BeforeEach
    public void openBrowser() {
        Configuration.browserSize = "1920x1080";
        open("https://yandex.ru/");
        auth
                .openAuthPage()
                .selectViaMail()
                .setEmail()
                .setPassword();
        sleep(2000);
        open("https://yandex.ru/dev/disk/poligon/");
        sleep(4000);
        token = poligonPage.getToken();
        sleep(2000);
        //needs timeout when opening pages
    }


    @Test
    public void createFolderTest(){
        System.out.println(token);
        folderApis.createFolder(token, "/TestFolder/");
    }

    @AfterEach
    public void tearDown(){
        folderApis.deleteFolder(token, "/TestFolder/");
        poligonPage.logout();
    }

}
