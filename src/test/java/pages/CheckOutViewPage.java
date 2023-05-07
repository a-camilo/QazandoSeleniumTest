package pages;

import org.openqa.selenium.By;
import support.Utils;

import java.time.Duration;

import static support.Commands.*;

public class CheckOutViewPage extends Utils {
    private final By fname = By.id("fname");
    private final By lname = By.id("lname");
    private final By companyName = By.id("cname");
    private final By emailAdress = By.id("email");
    private final By country = By.id("country");
    private final By stateCity = By.id("city");
    private final By zipCode = By.id("zip");
    private final By fullAdress = By.id("faddress");
    private final By addNotes = By.id("messages");
    private final By saveAdressCheckBox = By.id("materialUnchecked");
    private final By saveButton = By.xpath("//*[@id=\"checkout_one\"]/div/div/div[1]/div/button");
    private final By submenu = By.xpath("//*[@class='mega-menu-item'][2]//a[contains(text(),'Checkout View One')]");
    private final By mensagen = By.xpath("//div[@class='check-out-form']/h3");

    public static CheckOutViewPage action() {
        return new CheckOutViewPage();
    }

    public void submenu() {
        clickElement(submenu);
    }

    public void setFname(String firstName) {
        writeField(fname, firstName);
    }

    public void setLname(String lastName) {
        writeField(lname, lastName);
    }

    public void setCompanyName(String companyname) {
        writeField(companyName, companyname);
    }

    public void setEmailAdress(String email) {
        writeField(emailAdress, email);
    }

    public void setCountry(String countryName) {
        selectOptions(country, countryName);
    }

    public void setStateCity(String stateCityName) {
        scrollView(stateCity);
        selectOptions(stateCity, stateCityName);
    }

    public void setZipCode(String zip) {
        scrollView(zipCode);
        writeField(zipCode, zip);
    }

    public void setFullAdress(String adress) {
        writeField(fullAdress, adress);
    }

    public void setAddNotes(String notes) {
        writeField(addNotes, notes);
    }

    public void setSaveAdressCheckBox() throws InterruptedException {
        scrollView(saveAdressCheckBox);
        Thread.sleep(2000);
        clickElement(saveAdressCheckBox);
    }

    public void button() throws InterruptedException {
        scrollView(saveButton);
        clickElement(saveButton);
    }

    public CheckOutViewPage mensagem() {
        checkMessage("Billings Information registred with success!", mensagen);
        return this;
    }

    public CheckOutViewPage preencherAsInformações(String firtname, String lastname, String company, String email, String country, String state, String zip, String adress, String notes) throws InterruptedException {
        submenu();
        setFname(firtname);
        setLname(lastname);
        setCompanyName(company);
        setEmailAdress(email);
        setCountry(country);
        setStateCity(state);
        setZipCode(zip);
        setFullAdress(adress);
        setAddNotes(notes);
        setSaveAdressCheckBox();
        button();
        return this;
    }
}
