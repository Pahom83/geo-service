package ru.netology.i18;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.geo.*;
import ru.netology.i18n.*;

public class GeoTest {

    LocalizationService test = new LocalizationServiceImpl();
    GeoService geo = new GeoServiceImpl();
    @Test

    void localizationServiceRusTest(){
        String expectedRus = "Добро пожаловать";
        String actualRus = test.locale(Country.RUSSIA);
        String actualUsa = test.locale(Country.USA);
        //test
        Assertions.assertEquals(expectedRus, actualRus);
        Assertions.assertNotEquals(expectedRus, actualUsa);
    }

    @Test
    void localizationServiceOtherTest() {
        String expectedOther = "Welcome";
        String actualUsa = test.locale(Country.USA);
        String actualGermany = test.locale(Country.GERMANY);
        String actualBrazil = test.locale(Country.BRAZIL);
        //test
        Assertions.assertEquals(expectedOther, actualGermany);
        Assertions.assertEquals(expectedOther, actualUsa);
        Assertions.assertEquals(expectedOther, actualBrazil);
    }
    @Test
    void geoServiceImplRusTest(){
        Country expectedRus = Country.RUSSIA;

        Country actualRus = geo.byIp("172.").getCountry();

        Assertions.assertEquals(expectedRus, actualRus);
    }

    @Test
    void geoServiceImplUsaTest(){
        Country expectedUsa = Country.USA;

        Country actualUsa = geo.byIp("96.").getCountry();

        Assertions.assertEquals(expectedUsa, actualUsa);
    }

}
