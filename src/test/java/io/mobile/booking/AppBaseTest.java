package io.mobile.booking;

import io.mobile.booking.model.Manufacturer;
import io.mobile.booking.model.MobilePhone;
import io.mobile.booking.model.Tester;

import java.util.Arrays;

public class AppBaseTest {

    protected Manufacturer apple;
    protected Manufacturer samsung;
    protected Manufacturer motorola;
    protected Manufacturer nokia;
    protected Manufacturer onePlus;

    protected MobilePhone galaxyS9;
    protected MobilePhone galaxyS8;
    protected MobilePhone galaxyS8Second;
    protected MobilePhone nexus6;
    protected MobilePhone onePlusMobile;
    protected MobilePhone iphone13;
    protected MobilePhone iphone12;
    protected MobilePhone iphone11;
    protected MobilePhone iphoneX;
    protected MobilePhone nokia3310;

    protected Tester wozniak;
    protected Tester jobs;
    protected Tester jack;

    public AppBaseTest() {

        fillData();
    }

    private void fillData() {

        apple = Manufacturer.builder()
            .name("Apple")
            .foundationYear(1976)
            .website("www.apple.com")
            .build();

        samsung = Manufacturer.builder()
            .name("Samsung")
            .foundationYear(1938)
            .website("www.samsung.com")
            .build();

        motorola = Manufacturer.builder()
            .name("Motorola")
            .foundationYear(1928)
            .website("www.motorola.com")
            .build();

        nokia = Manufacturer.builder()
            .name("Nokia")
            .foundationYear(1865)
            .website("www.nokia.com")
            .build();

        onePlus = Manufacturer.builder()
            .name("Nokia")
            .foundationYear(2013)
            .website("www.oneplus.com")
            .build();

        galaxyS9 = MobilePhone.builder()
            .serialNumber("1410110058")
            .model("Galaxy")
            .version("S9")
            .manufacturer(samsung)
            .build();

        galaxyS8 = MobilePhone.builder()
            .serialNumber("1410110406")
            .model("Galaxy")
            .version("S8")
            .manufacturer(samsung)
            .build();

        galaxyS8Second = MobilePhone.builder()
            .serialNumber("1310110148")
            .model("Galaxy")
            .version("S8")
            .manufacturer(samsung)
            .build();

        nexus6 = MobilePhone.builder()
            .serialNumber("1410110463")
            .model("Nexus")
            .version("6")
            .manufacturer(motorola)
            .build();

        onePlusMobile = MobilePhone.builder()
            .serialNumber("1310110344")
            .model("Oneplus")
            .version("9")
            .manufacturer(onePlus)
            .build();

        iphone13 = MobilePhone.builder()
            .serialNumber("1410110117")
            .model("iPhone")
            .version("13")
            .manufacturer(apple)
            .build();

        iphone12 = MobilePhone.builder()
            .serialNumber("1310110111")
            .model("iPhone")
            .version("12")
            .manufacturer(apple)
            .build();

        iphone11 = MobilePhone.builder()
            .serialNumber("1410110074")
            .model("iPhone")
            .version("11")
            .manufacturer(apple)
            .build();

        iphoneX = MobilePhone.builder()
            .serialNumber("1310110085")
            .model("iPhone")
            .version("X")
            .manufacturer(apple)
            .build();

        nokia3310 = MobilePhone.builder()
            .serialNumber("1410110220")
            .model("nokia")
            .version("3310")
            .manufacturer(nokia)
            .build();

        wozniak = Tester.builder()
            .name("Steve Wozniak")
            .email("steve@apple.com")
            .phoneNumber("+1224855100")
            .skills(Arrays.asList("linux", "leapWork", "appLoader") )
            .build();

        jobs = Tester.builder()
            .name("Steve Jobs")
            .email("jobs@apple.com")
            .phoneNumber("+1224855101")
            .skills(Arrays.asList("teamCity", "testRail") )
            .build();

        jack = Tester.builder()
            .name("Jack Ma")
            .email("jack@ma.com")
            .phoneNumber("+122555101")
            .skills(Arrays.asList("cerberus", "Buildkite") )
            .build();
    }
}
