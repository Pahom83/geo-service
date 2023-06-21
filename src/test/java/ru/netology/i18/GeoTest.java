package ru.netology.i18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class GeoTest {

    LocalizationService test = new LocalizationServiceImpl();
    GeoService geo = new GeoServiceImpl();
    @Test

    void localizationServiceTest(){
        String expectedRus = "Добро пожаловать";
        String expectedOther = "Welcome";
        String testRus = test.locale(Country.RUSSIA);
        String testUsa = test.locale(Country.USA);
        String testGermany = test.locale(Country.GERMANY);
        String testBrazil = test.locale(Country.BRAZIL);
        //test
        Assertions.assertEquals(expectedRus, testRus);
        Assertions.assertEquals(expectedOther, testGermany);
        Assertions.assertEquals(expectedOther, testUsa);
        Assertions.assertEquals(expectedOther, testBrazil);
        Assertions.assertNotEquals(expectedOther, testRus);
    }

    @Test
    void geoServiceImplTest(){
        Country expectedRus= Country.RUSSIA;
        Country expectedUsa = Country.USA;

        Country actualUsa = geo.byIp("96.").getCountry();
        Country actualRus = geo.byIp("172.").getCountry();

        Assertions.assertEquals(expectedRus, actualRus);
        Assertions.assertEquals(expectedUsa, actualUsa);
    }
}
