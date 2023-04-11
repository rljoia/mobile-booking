package io.mobile.booking.control;

import io.mobile.booking.model.MobilePhone;
import io.mobile.booking.model.UUIDIdentifiable;
import io.mobile.booking.model.dao.BaseDAO;
import io.mobile.booking.model.dao.MobilePhoneDAO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MobilePhoneController {

    private final BaseDAO<MobilePhone> dao = new MobilePhoneDAO(MobilePhone.class);

    public UUID add(MobilePhone mobilePhone) {
        return dao.save(mobilePhone);
    }

    public Collection<UUIDIdentifiable> getAll() {
        return dao.getAll();
    }

    public Set<MobilePhone> getAllAvailable() {

        Collection<UUIDIdentifiable> mobilePhoneList = getAll();

        Set<MobilePhone> result = new HashSet<>();
        for (UUIDIdentifiable item : mobilePhoneList) {

            MobilePhone mobilePhone = (MobilePhone) item;

            if (mobilePhone.isAvailable()) {
                result.add(mobilePhone);
            }
        }

        return result;
    }
}
