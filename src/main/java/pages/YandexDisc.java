package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class YandexDisc {

    // Открыть страницу http://yandex.ru
//        ? Авторизоваться
//        ? Открыть Яндекс.Диск
//        ? Создать новую папку и назвать её
//        ? Скопировать файл “Файл для копирования” в новую папку
//        ? Открыть папку
//        ? Проверить наличие скопированного файла и его название
//        Ожидаемый результат:
//        ? Скопированный файл находится в папке

    Random random = new Random();
    //locators
    private SelenideElement createbutton = $x("//button");
    private SelenideElement createpackage = $x("//button[@aria-label=\"Папку\"]");
    private SelenideElement packagenameinput = $x("//input[@value=\"Новая папка\"]");
    private SelenideElement savenewpackage = $x("//button[@class=\"Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit \"]");
    private SelenideElement mountainsjpg = $x("//span[.='Горы.jpg']//ancestor::div[contains(@class,'listing-item_theme_tile')]");
    private SelenideElement copymenubutton = $x("//span[.='Копировать']");
    private SelenideElement deletemenubutton = $x("//span[.='Удалить']");
    private SelenideElement firstpackagelist = $x("//div[contains(text(),'Test Package')]");
    private SelenideElement copybutton = $x("//button[@class=\"Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit \"]");
    private SelenideElement firstPackage  = $x("//span[.='Test Package']");
    private SelenideElement backbutton =$x("//button[@id=\"/disk\"]");

    //variables
    private String packagename = "Test Package";
        //+ random.nextInt();

    public YandexDisc createPackage(){
        createbutton.shouldBe(visible).click();
        createpackage.shouldBe(visible).click();
        actions().doubleClick().sendKeys(Keys.BACK_SPACE).build();
        sleep(1500);
        packagenameinput.sendKeys(packagename);
        savenewpackage.click();
        return this;
    }

    public YandexDisc copyFileToFolder(){
        sleep(1500);
        mountainsjpg.contextClick();
        copymenubutton.shouldBe(visible).click();
        firstpackagelist.shouldBe(visible).click();
        copybutton.shouldBe(visible).click();
        return this;
    }

    public YandexDisc openFolder(){
        sleep(2000);
        firstPackage.doubleClick();
        sleep(1500);
        return this;
    }

    public YandexDisc returnToMainDiskPage(){
        backbutton.click();
        return this;
    }

    public YandexDisc removeFolder(){
        firstPackage.contextClick();
        deletemenubutton.click();
        return this;
    }
}
