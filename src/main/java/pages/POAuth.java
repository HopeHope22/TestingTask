package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class POAuth {

    //locators
    private final SelenideElement loginbutton = $x("(//a[contains(@class, 'desk-notif-card__login-new-item')]/div[2])[1]");
    private final SelenideElement mailbutton = $x("(//div[@class=\"AuthLoginInputToggle-type\"])[1]");
    private final SelenideElement loginoremailfield = $("#passp-field-login");
    private final SelenideElement passwordfield = $("#passp-field-passwd");
    private final SelenideElement loginbuttonconfirm = $x("//button[@id=\"passp:sign-in\"]");
    private final SelenideElement confirmButton = $x("//button[contains(@class, 'oauth-authorize')]");

    //const
    //+19853463689 - account number
    private final String email = "yodafo4992@altpano.com";
    private final String password = "testforsimbirsoft";

    public POAuth openAuthPage(){
        loginbutton.click();
        return this;
    }

    public POAuth selectViaMail(){
        mailbutton.shouldBe(visible).click();
        return this;
    }

    public POAuth setEmail(){
        loginoremailfield.shouldBe(visible).setValue(email);
        loginbuttonconfirm.click();
        return this;
    }

    public POAuth setPassword(){
        passwordfield.shouldBe(visible).setValue(password);
        loginbuttonconfirm.click();
        return this;
    }

    public void confirmLogin(){
        confirmButton.shouldBe(exist, visible).click();
    }
}


