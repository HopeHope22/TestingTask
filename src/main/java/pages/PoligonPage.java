package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PoligonPage {

    private static final SelenideElement getTokenButton = $x("//a[contains(@href,'oauth')]");
    private static final SelenideElement tokenInput = $x("//input[@class='Textinput-Control']");
    private static final SelenideElement avatarImg = $x("(//div[contains(@class,'user-account__pic')])[1]");
    private static final SelenideElement logoutButton = $x("(//span[@class='menu__text' and .='Выйти'])[1]");


    public String getToken() {
        WebDriverRunner.getWebDriver().switchTo().frame("2a43cc95-a6f3-4483-a5e9-cd92847fe725");
        getTokenButton.shouldBe(exist, visible).click();
//        WebDriverRunner.getWebDriver().switchTo().defaultContent();
//        new POAuth().confirmLogin();
        WebDriverRunner.getWebDriver().switchTo().frame("2a43cc95-a6f3-4483-a5e9-cd92847fe725");
        String token = tokenInput.shouldBe(exist, visible).getValue();
        WebDriverRunner.getWebDriver().switchTo().parentFrame();
        return token;
    }

    public void logout() {
        avatarImg.shouldBe(visible).click();
        logoutButton.shouldBe(visible).click();
    }
}
