package com.enuygun.tests;

import com.enuygun.pages.UcusListesi;
import com.enuygun.utilities.BrowserUtils;
import com.enuygun.utilities.ConfigurationReader;
import com.enuygun.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EnUygunTest extends TestBase {

    @Test
    public void test(){
        UcusListesi ucusListesi=new UcusListesi();

        extentLogger= report.createTest("en uygun test");
        extentLogger.info("navigate to www.enuygun.com");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("choose to from where");
        ucusListesi.gidisRotasi("Ankara");

        extentLogger.info("choose to where to go");
        ucusListesi.donusRotasi("İstanbul");

        extentLogger.info("choose departure day");
        ucusListesi.gidisTarihi.click();
        ucusListesi.gunSec("Nisan", "5");
        BrowserUtils.waitFor(2);

        extentLogger.info("choose arrival day");
        ucusListesi.dönusTarihi.click();
        ucusListesi.gunSec("Nisan", "6");
        BrowserUtils.waitFor(2);

        extentLogger.info("choose person numbers");
        ucusListesi.yolcuSayisiSecme(2,1,0,0,0);
        BrowserUtils.waitFor(3);
        extentLogger.info("click search button");
        ucusListesi.aramaButonu.click();
        BrowserUtils.waitForVisibility(ucusListesi.gidisUcusunuzuSeçin, 20);
        extentLogger.info("choose to departure flight");
        ucusListesi.gidisUcusListesiSec.get(0).click();
        BrowserUtils.waitFor(4);
        ucusListesi.donusUcuslarınıSec.get(0).click();

    }
}
