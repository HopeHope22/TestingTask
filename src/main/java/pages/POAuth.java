package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class POAuth {

    //locators
    private SelenideElement loginbutton = $x("(//a[contains(@class, 'desk-notif-card__login-new-item')]/div[2])[1]");
    private SelenideElement mailbutton = $x("(//div[@class=\"AuthLoginInputToggle-type\"])[1]");
    private SelenideElement loginoremailfield = $("#passp-field-login");
    private SelenideElement passwordfield = $("#passp-field-passwd");
    private SelenideElement loginbuttonconfirm = $x("//button[@id=\"passp:sign-in\"]");

    //const
    //+19853463689 - account number
    private String email = "yodafo4992@altpano.com";
    private String password = "testforsimbirsoft";

    public POAuth openAuthPage(){
        loginbutton.click();
        return this;
    }

    public POAuth selectViaMail(){
        mailbutton.shouldBe(Condition.visible).click();
        return this;
    }

    public POAuth setEmail(){
        loginoremailfield.setValue(email);
        loginbuttonconfirm.click();
        return this;
    }

    public POAuth setPassword(){
        passwordfield.setValue(password);
        loginbuttonconfirm.click();
        return this;
    }
}


