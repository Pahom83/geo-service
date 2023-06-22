package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {
    GeoService geo = new GeoServiceImpl();
    @Test
    void geoServiceImplRusByIpTest() {
        Country expectedRus = Country.RUSSIA;

        Country actualRus = geo.byIp("172.").getCountry();

        Assertions.assertEquals(expectedRus, actualRus);
    }

    @Test
    void geoServiceImplUsaByIpTest(){
        Country expectedUsa = Country.USA;

        Country actualUsa = geo.byIp("96.").getCountry();

        Assertions.assertEquals(expectedUsa, actualUsa);
    }
}