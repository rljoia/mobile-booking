package io.mobile.booking;


import io.mobile.booking.control.DeviceBookingController;
import io.mobile.booking.control.ManufacturerController;
import io.mobile.booking.control.MobilePhoneController;
import io.mobile.booking.control.TesterController;
import io.mobile.booking.model.Manufacturer;
import io.mobile.booking.model.MobilePhone;
import io.mobile.booking.model.Tester;
import io.mobile.booking.util.BusinessException;

import java.util.Arrays;
import java.util.Date;

public class App {

    static ManufacturerController manufacturerController = new ManufacturerController();
    static TesterController testerController = new TesterController();
    static MobilePhoneController mobilePhoneController = new MobilePhoneController();
    static DeviceBookingController deviceBookingController = new DeviceBookingController();

    public static void main( String[] args ) throws InterruptedException {

        fillDatabaseAndCheck();
    }

    private static void fillDatabaseAndCheck() throws InterruptedException {

        Manufacturer apple = Manufacturer.builder()
            .name("Apple")
            .foundationYear(1976)
            .website("www.apple.com")
            .build();

        Manufacturer samsung = Manufacturer.builder()
            .name("Samsung")
            .foundationYear(1938)
            .website("www.samsung.com")
            .build();

        Manufacturer motorola = Manufacturer.builder()
            .name("Motorola")
            .foundationYear(1928)
            .website("www.motorola.com")
            .build();

        Manufacturer nokia = Manufacturer.builder()
            .name("Nokia")
            .foundationYear(1865)
            .website("www.nokia.com")
            .build();

        Manufacturer onePlus = Manufacturer.builder()
            .name("Nokia")
            .foundationYear(2013)
            .website("www.oneplus.com")
            .build();

        manufacturerController.add(apple);
        manufacturerController.add(samsung);
        manufacturerController.add(motorola);
        manufacturerController.add(nokia);
        manufacturerController.add(onePlus);

        MobilePhone galaxyS9 = MobilePhone.builder()
            .serialNumber("1410110058")
            .model("Galaxy")
            .version("S9")
            .manufacturer(samsung)
            .build();

        MobilePhone galaxyS8 = MobilePhone.builder()
            .serialNumber("1410110406")
            .model("Galaxy")
            .version("S8")
            .manufacturer(samsung)
            .build();

        MobilePhone galaxyS8Second = MobilePhone.builder()
            .serialNumber("1310110148")
            .model("Galaxy")
            .version("S8")
            .manufacturer(samsung)
            .build();

        MobilePhone nexus6 = MobilePhone.builder()
            .serialNumber("1410110463")
            .model("Nexus")
            .version("6")
            .manufacturer(motorola)
            .build();

        MobilePhone onePlusMobile = MobilePhone.builder()
            .serialNumber("1310110344")
            .model("Oneplus")
            .version("9")
            .manufacturer(onePlus)
            .build();

        MobilePhone iphone13 = MobilePhone.builder()
            .serialNumber("1410110117")
            .model("iPhone")
            .version("13")
            .manufacturer(apple)
            .build();

        MobilePhone iphone12 = MobilePhone.builder()
            .serialNumber("1310110111")
            .model("iPhone")
            .version("12")
            .manufacturer(apple)
            .build();

        MobilePhone iphone11 = MobilePhone.builder()
            .serialNumber("1410110074")
            .model("iPhone")
            .version("11")
            .manufacturer(apple)
            .build();

        MobilePhone iphoneX = MobilePhone.builder()
            .serialNumber("1310110085")
            .model("iPhone")
            .version("X")
            .manufacturer(apple)
            .build();

        MobilePhone nokia3310 = MobilePhone.builder()
            .serialNumber("1410110220")
            .model("nokia")
            .version("3310")
            .manufacturer(nokia)
            .build();

        mobilePhoneController.add(galaxyS9);
        mobilePhoneController.add(galaxyS8);
        mobilePhoneController.add(galaxyS8Second);
        mobilePhoneController.add(nexus6);
        mobilePhoneController.add(onePlusMobile);
        mobilePhoneController.add(iphone13);
        mobilePhoneController.add(iphone12);
        mobilePhoneController.add(iphone11);
        mobilePhoneController.add(iphoneX);
        mobilePhoneController.add(nokia3310);


        Tester wozniak = Tester.builder()
            .name("Steve Wozniak")
            .email("steve@apple.com")
            .phoneNumber("+1224855100")
            .skills(Arrays.asList("linux", "leapWork", "appLoader") )
            .build();

        Tester jobs = Tester.builder()
            .name("Steve Jobs")
            .email("jobs@apple.com")
            .phoneNumber("+1224855101")
            .skills(Arrays.asList("teamCity", "testRail") )
            .build();

        Tester jack = Tester.builder()
            .name("Jack Ma")
            .email("jack@ma.com")
            .phoneNumber("+122555101")
            .skills(Arrays.asList("cerberus", "Buildkite") )
            .build();

        testerController.add(wozniak);
        testerController.add(jobs);
        testerController.add(jack);

        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

            deviceBookingController.bookPhone(iphone13, jack, new Date());

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(2000);

        try {
            deviceBookingController.returnPhone(iphone13, jobs, new Date());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        try {
            deviceBookingController.returnPhone(iphone13, wozniak, new Date());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        System.out.println( "GetAllBookings: " + deviceBookingController.getAllBookings() );
    }
}
