package io.mobile.booking.control;

import io.mobile.booking.model.*;
import io.mobile.booking.model.dao.IDeviceBookingDAO;
import io.mobile.booking.model.dao.DeviceBookingDAO;
import io.mobile.booking.util.BusinessException;
import io.mobile.booking.util.ErrorMessages;

import java.util.Collection;
import java.util.Date;

public class DeviceBookingController {

    private final IDeviceBookingDAO<DeviceBooking> dao = new DeviceBookingDAO(DeviceBooking.class);

    public void bookPhone(MobilePhone phone, Tester tester, Date bookedDate) throws BusinessException {

        if (phone.isAvailable()) {
            DeviceBooking deviceBooking = DeviceBooking.builder()
                .device(phone)
                .person(tester)
                .bookedDate(bookedDate)
                .build();

            phone.setAvailable(false);
            dao.save(deviceBooking);

            System.out.println("bookPhone: " + deviceBooking);

        } else {

            throw new BusinessException(ErrorMessages.PHONE_ALREADY_BOOKED,
                phone.getId(), phone.getModel(), phone.getVersion());
        }
    }

    public void returnPhone(MobilePhone phone, Tester tester, Date returnDate) throws BusinessException {

        if (!phone.isAvailable()) {
            DeviceBooking deviceBooking = dao.getBooked(phone, tester);

            if (deviceBooking == null) {
                throw new BusinessException(ErrorMessages.PHONE_WAS_BOOKED_ANOTHER_TESTER, phone.getId(), phone.getModel(), phone.getVersion());
            }

            deviceBooking.setReturnedDate(returnDate);
            phone.setAvailable(true);

            dao.save(deviceBooking);

            System.out.println("returnPhone: " + deviceBooking);

        } else {
            throw new BusinessException(ErrorMessages.PHONE_ALREADY_AVAILABLE, phone.getId(), phone.getModel(), phone.getVersion());
        }
    }

    public Collection<UUIDIdentifiable> getAllBookings() {
        return dao.getAll();
    }

}
