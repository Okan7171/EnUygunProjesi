package com.enuygun.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UcusListesi extends BasePage{

    @FindBy(xpath = "//div[text()='Lütfen Gidiş Uçuşunuzu Seçin']")
    public WebElement gidisUcusunuzuSeçin;

    @FindBy (xpath = "//button[.='Seç']")
    public List<WebElement> gidisUcusListesiSec;

    @FindBy (xpath = "//div[.='Lütfen Dönüş Uçuşunuzu Seçin']" +
            "/ancestor::div[@class='flight-list flight-list-return domesticList']//span[.='Seç']")
    public List<WebElement> donusUcuslarınıSec;


}
