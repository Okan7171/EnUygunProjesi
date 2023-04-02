package com.enuygun.pages;

import com.enuygun.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "OriginInput")
    public WebElement nereden;

    @FindBy (id = "DestinationInput")
    public WebElement nereye;

    @FindBy (id = "DepartureDate")
    public WebElement gidisTarihi;

    @FindBy (id = "ReturnDate")
    public WebElement dönusTarihi;

    @FindBy (xpath = "//button[@data-testid='passengerSelectButtonMulti']")
    public WebElement yolcuSayisi;

    @FindBy (xpath = "//button[@aria-label='Submit Button']")
    public WebElement aramaButonu;

    public void gunSec(String ay, String gün){
        Driver.get().findElement(By.xpath("(//div[@class=\"CalendarMonth_caption CalendarMonth_caption_1\"]" +
                "[.=\""+ay+" 2023\"])//ancestor::div[@class=\"CalendarMonth CalendarMonth_1\"]//div[.="+gün+"]")).click();

    }
    public void gidisRotasi(String il){
        nereden.sendKeys(il);
        nereden.click();
        Driver.get().findElement(By.xpath("//div[@class='suggestion_item']")).click();

    }
    public void donusRotasi(String il){
        nereye.sendKeys(il);
        nereye.click();
        Driver.get().findElement(By.xpath("//div[@class='suggestion_item']")).click();
    }
    public void yolcuSayisiSecme(int yetiskinSay, int cocukSay, int bebekSay, int yasli, int ogrenci){
        yolcuSayisi.click();
        if(yetiskinSay==0){
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountDecrease-0']")).click();
        }
        else{
        for (int i = 1; i < yetiskinSay; i++) {
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountIncrease-0']")).click();
        }
        }
        for (int i = 0; i < cocukSay; i++) {
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountIncrease-1']")).click();
        }
        for (int i = 0; i < bebekSay; i++) {
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountIncrease-2']")).click();
        }
        for (int i = 0; i < yasli; i++) {
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountIncrease-3']")).click();
        }
        for (int i = 0; i < ogrenci; i++) {
            Driver.get().findElement(By.xpath("//button[@data-testid='passengerCountIncrease-4']")).click();
        }
        Driver.get().findElement(By.xpath("//button[text()='Tamam']")).click();

    }
}
