package io.mobile.booking;

import io.mobile.booking.control.DeviceBookingController;
import io.mobile.booking.control.ManufacturerController;
import io.mobile.booking.control.MobilePhoneController;
import io.mobile.booking.control.TesterController;
import io.mobile.booking.model.MobilePhone;
import io.mobile.booking.model.data.InMemoryDatabase;
import io.mobile.booking.util.BusinessException;
import io.mobile.booking.util.ErrorMessages;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class DeviceBookingTest extends AppBaseTest {

    ManufacturerController manufacturerController = new ManufacturerController();
    MobilePhoneController mobilePhoneController = new MobilePhoneController();
    TesterController testerController = new TesterController();

    public DeviceBookingTest() {
        super();
    }

    @Test
    public void testBookDeviceBookings() {

        InMemoryDatabase.restartDatabase();

        setupInitData();

        DeviceBookingController deviceBookingController = new DeviceBookingController();


        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

            Assert.assertEquals(3, deviceBookingController.getAllBookings().size() );

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            deviceBookingController.bookPhone(iphone13, jack, new Date());
            fail();
        } catch (BusinessException e) {
            Assert.assertEquals(ErrorMessages.PHONE_ALREADY_BOOKED.getCode(), e.getCode());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testReturnDeviceBookingSuccess() {

        InMemoryDatabase.restartDatabase();

        setupInitData();

        DeviceBookingController deviceBookingController = new DeviceBookingController();


        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

            Assert.assertEquals(3, deviceBookingController.getAllBookings().size() );

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            deviceBookingController.returnPhone(iphone13, wozniak, new Date());
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void testReturnDeviceBookingErrorAlreadyAvailable() {

        InMemoryDatabase.restartDatabase();

        setupInitData();

        DeviceBookingController deviceBookingController = new DeviceBookingController();

        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

            Assert.assertEquals(3, deviceBookingController.getAllBookings().size() );

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            deviceBookingController.returnPhone(iphoneX, jobs, new Date());
            fail();
        } catch (BusinessException e) {
            Assert.assertEquals(ErrorMessages.PHONE_ALREADY_AVAILABLE.getCode(), e.getCode());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testReturnDeviceBookingErrorBookedAnotherTester() {

        InMemoryDatabase.restartDatabase();

        setupInitData();

        DeviceBookingController deviceBookingController = new DeviceBookingController();


        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

            Assert.assertEquals(3, deviceBookingController.getAllBookings().size() );

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            deviceBookingController.returnPhone(iphone13, jobs, new Date());
            fail();
        } catch (BusinessException e) {
            Assert.assertEquals(ErrorMessages.PHONE_WAS_BOOKED_ANOTHER_TESTER.getCode(), e.getCode());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testReturnDeviceAllAvailable() {

        InMemoryDatabase.restartDatabase();

        setupInitData();

        DeviceBookingController deviceBookingController = new DeviceBookingController();

        try {
            deviceBookingController.bookPhone(iphone11, wozniak, new Date());
            deviceBookingController.bookPhone(iphone13, wozniak, new Date());
            deviceBookingController.bookPhone(nexus6, jobs, new Date());

        } catch (BusinessException e) {
            System.out.println(e.getMessage());
            fail();
        }

        Set<MobilePhone> availableList = mobilePhoneController.getAllAvailable();

        Assert.assertEquals(1, availableList.size());

        assertEquals(availableList.iterator().next(), iphoneX);
    }

    private void setupInitData() {
        manufacturerController = new ManufacturerController();
        manufacturerController.add(apple);
        manufacturerController.add(motorola);

        mobilePhoneController = new MobilePhoneController();
        mobilePhoneController.add(iphone11);
        mobilePhoneController.add(iphone13);
        mobilePhoneController.add(nexus6);
        mobilePhoneController.add(iphoneX);

        testerController = new TesterController();
        testerController.add(wozniak);
        testerController.add(jobs);
    }
}
