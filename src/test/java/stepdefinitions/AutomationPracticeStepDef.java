package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationPracticeCreatAccountPage;
import pages.AutomationPracticeHomePage;
import utilities.Driver;

public class AutomationPracticeStepDef {
    AutomationPracticeHomePage apHomePage = new AutomationPracticeHomePage();
    AutomationPracticeCreatAccountPage apCreatAccountPage = new AutomationPracticeCreatAccountPage();

    @Given("user web sayfasinda")
    public void user_web_sayfasinda() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
    }

    @Given("user sign in linkine tiklar")
    public void user_sign_in_linkine_tiklar() {
        apHomePage.signInButton.click();
    }

    @Given("user Create an account bolumune  email adresi girer")
    public void user_Create_an_account_bolumune_email_adresi_girer() {
        apHomePage.emailBox.sendKeys("fzlkzhn46@gmail.com");
    }

    @Given("Create an Account butonuna basar")
    public void create_an_Account_butonuna_basar() {
        apHomePage.createButton.click();
    }

    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {
        apCreatAccountPage.gender.click();
        apCreatAccountPage.firstname.sendKeys("Fazli");
        apCreatAccountPage.lastname.sendKeys("Kuzhan");
        apCreatAccountPage.password.sendKeys("omerceyda38");
        Select birtDay = new Select(apCreatAccountPage.day);
        birtDay.selectByIndex(20);
        Select birtMonth = new Select(apCreatAccountPage.month);
        birtMonth.selectByIndex(12);
        Select birtYear = new Select(apCreatAccountPage.year);
        birtYear.selectByIndex(36);
        apCreatAccountPage.address1.sendKeys("16 SORLYN AVE");
        apCreatAccountPage.city.sendKeys("TORONTO");
        Select state = new Select(apCreatAccountPage.state);
        state.selectByIndex(4);
        apCreatAccountPage.zipcode.sendKeys("12345");
        Select country = new Select(apCreatAccountPage.country);
        country.selectByIndex(1);
        apCreatAccountPage.phone.sendKeys("6476457676");
        apCreatAccountPage.aliasAddress.sendKeys("NORTH YORK");
    }

    @Given("user Register butonuna basar")
    public void user_Register_butonuna_basar() {
        apCreatAccountPage.registerButton.click();
    }

    @Then("hesap olusturuldugunu dogrulayin")
    public void hesap_olusturuldugunu_dogrulayin() {
        Assert.assertTrue(apCreatAccountPage.myAccount.isDisplayed());
    }

    @Given("email kutusuna gecersiz email ve password yazar ve sign in butonuna  tiklar")
    public void email_kutusuna_gecersiz_email_ve_password_yazar_ve_sign_in_butonuna_tiklar() {
        apHomePage.emailBox2.sendKeys("testtest@gmail.com");
        apHomePage.pass.sendKeys("111222333");
        apHomePage.signinButton.click();
    }

    @Then("error mesajinin  Authentication failed. oldugunu dogrulayin")
    public void error_mesajinin_Authentication_failed_oldugunu_dogrulayin() {
        Assert.assertTrue(apHomePage.errorMessage.isDisplayed());
    }

    @Given("imleci Women linkinin uzerine ve daha sonra Tshirts'e tiklayin")
    public void imleci_Women_linkinin_uzerine_ve_daha_sonra_Tshirts_e_tiklayin() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(apHomePage.womenLink).moveToElement(apHomePage.tshirts).click().perform();
    }

    @Given("sayfada gorunen ilk urunun textini alin")
    public void sayfada_gorunen_ilk_urunun_textini_alin() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String productName = apHomePage.productFirst.getText();

    }

    @Given("sayfada ustte bulunan arama cubuguna ayni urun ismini girin ve search butonuna basin")
    public void sayfada_ustte_bulunan_arama_cubuguna_ayni_urun_ismini_girin_ve_search_butonuna_basin() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();

        apHomePage.searchBox.sendKeys(apHomePage.productFirst.getText());
        apHomePage.search.click();
    }

    @Then("acilan sayfada cikan urunun T-Shirt sayfasinda goruntulenen urunle ayni oldugunu dogrulayin")
    public void acilan_sayfada_cikan_urunun_T_Shirt_sayfasinda_goruntulenen_urunle_ayni_oldugunu_dogrulayin() {
        Assert.assertTrue(apHomePage.productSecond.equals(apHomePage.productFirst));

    }
}