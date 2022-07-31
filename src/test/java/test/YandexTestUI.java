package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.POAuth;
import pages.YandexDisc;

import static com.codeborne.selenide.Selenide.*;

public class YandexTestUI {
    POAuth Auth = new POAuth();
    YandexDisc TestSteps = new YandexDisc();

    @BeforeEach
    void openBrowser() {
        Configuration.browserSize = "1920x1080";
        open("https://yandex.ru/");

    }

    @AfterEach
    void closeBrowser() {
        TestSteps
                .returnToMainDiskPage()
                .removeFolder();
        closeWebDriver();
    }

    @Test
    void discTest(){
        Auth
                .openAuthPage()
                .selectViaMail()
                .setEmail()
                .setPassword();
        sleep(2000);
        open("https://disk.yandex.ru/client/disk?source=domik-main");
        TestSteps
                .createPackage()
                .copyFileToFolder()
                .openFolder();
        $("div.listing-item__title.listing-item__title_overflow_clamp").shouldHave(Condition.attribute("aria-label", "Горы.jpg"));
    }
}