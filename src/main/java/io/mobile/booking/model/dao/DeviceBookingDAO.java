package io.mobile.booking.model.dao;

import io.mobile.booking.model.Device;
import io.mobile.booking.model.DeviceBooking;
import io.mobile.booking.model.Person;
import io.mobile.booking.model.UUIDIdentifiable;
import io.mobile.booking.model.data.InMemoryDatabase;

import java.util.*;

public class DeviceBookingDAO extends BaseDAO<DeviceBooking> implements IDeviceBookingDAO<DeviceBooking> {

    public DeviceBookingDAO(Class<DeviceBooking> typeParameterClass) {
        super(typeParameterClass);
    }

    public DeviceBooking getBooked(Device device, Person person) {
        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        Collection<UUIDIdentifiable> deviceBookingList = list.values();

        for (UUIDIdentifiable item : deviceBookingList) {

            DeviceBooking deviceBooking = (DeviceBooking) item;

            if (deviceBooking.getPerson().equals(person) &&
                deviceBooking.getDevice().equals(device) &&
                !deviceBooking.getDevice().isAvailable()) {

                return deviceBooking;
            }
        }

        return null;
    }
}
