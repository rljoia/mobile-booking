package io.mobile.booking.control;

import io.mobile.booking.model.Manufacturer;
import io.mobile.booking.model.UUIDIdentifiable;
import io.mobile.booking.model.dao.BaseDAO;
import io.mobile.booking.model.dao.ManufacturerDAO;

import java.util.Collection;
import java.util.UUID;

public class ManufacturerController {

    private final BaseDAO<Manufacturer> dao = new ManufacturerDAO(Manufacturer.class);

    public UUID add(Manufacturer manufacturer) {
        return dao.save(manufacturer);
    }

    public Collection<UUIDIdentifiable> getAll() {
        return dao.getAll();
    }
}
