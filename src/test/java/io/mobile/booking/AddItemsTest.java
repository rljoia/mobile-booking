package io.mobile.booking;

import io.mobile.booking.control.ManufacturerController;
import io.mobile.booking.control.MobilePhoneController;
import io.mobile.booking.control.TesterController;
import io.mobile.booking.model.data.InMemoryDatabase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AddItemsTest extends AppBaseTest {

    public AddItemsTest() {
        super();
    }

    @Test
    public void testDummyInitialize() {
        assertNotNull(InMemoryDatabase.getInstance());
    }

    @Test
    public void testAddManufacturers() {

        InMemoryDatabase.restartDatabase();

        ManufacturerController manufacturerController = new ManufacturerController();

        Assert.assertEquals(0, manufacturerController.getAll().size());

        manufacturerController.add(apple);
        manufacturerController.add(samsung);
        manufacturerController.add(motorola);
        manufacturerController.add(nokia);
        manufacturerController.add(onePlus);

        Assert.assertEquals(5, manufacturerController.getAll().size() );
    }

    @Test
    public void testAddMobilePhones() {
        InMemoryDatabase.restartDatabase();

        MobilePhoneController mobilePhoneController = new MobilePhoneController();

        Assert.assertEquals(0, mobilePhoneController.getAll().size());

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

        Assert.assertEquals(10, mobilePhoneController.getAll().size());
    }

    @Test
    public void testAddTesters() {
        InMemoryDatabase.restartDatabase();

        TesterController testerController = new TesterController();

        Assert.assertEquals(0, testerController.getAll().size());

        testerController.add(wozniak);
        testerController.add(jobs);
        testerController.add(jack);

        Assert.assertEquals(3, testerController.getAll().size());
    }
}
