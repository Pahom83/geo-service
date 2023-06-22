package ru.netology.sender;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import ru.netology.entity.*;
import ru.netology.geo.*;
import ru.netology.i18n.*;
import java.util.*;

class MessageSenderImplTest {
    private LocalizationService localizationService;
    private GeoService geoService;
    private MessageSender messageSender;
    private Map<String, String> headers;
    @BeforeEach
    void setting (){
        localizationService = Mockito.mock(LocalizationServiceImpl.class);
        geoService = Mockito.mock(GeoServiceImpl.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
        headers = new HashMap<>();
    }

    @Test
    void messageSenderRusTest(){
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(actual, expected);
        Mockito.verify(geoService, Mockito.times(1)).byIp("172.");
        Mockito.verify(geoService, Mockito.never()).byIp("96.");
    }
    @Test
    void messageSenderUsaTest(){
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location("New York", Country.USA, null,  0));
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        String actual = messageSender.send(headers);
        String expected = "Welcome";

        Assertions.assertEquals(actual, expected);
        Mockito.verify(geoService, Mockito.times(1)).byIp("96.");
        Mockito.verify(geoService, Mockito.never()).byIp("172.");
    }

}