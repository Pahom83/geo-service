package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    LocalizationService test = new LocalizationServiceImpl();
    @Test
    void localizationServiceRusTest() {
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
}