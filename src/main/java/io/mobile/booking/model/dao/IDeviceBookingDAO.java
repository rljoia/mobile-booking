package io.mobile.booking.model.dao;

import io.mobile.booking.model.Device;
import io.mobile.booking.model.Person;

public interface IDeviceBookingDAO<T> extends DAO {

    T getBooked(Device device, Person person);
}
