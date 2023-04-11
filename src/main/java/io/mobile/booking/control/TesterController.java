package io.mobile.booking.control;

import io.mobile.booking.model.Tester;
import io.mobile.booking.model.UUIDIdentifiable;
import io.mobile.booking.model.dao.BaseDAO;
import io.mobile.booking.model.dao.TesterDAO;

import java.util.Collection;
import java.util.UUID;

public class TesterController {

    private final BaseDAO<Tester> dao = new TesterDAO(Tester.class);

    public UUID add(Tester tester) {

        return dao.save(tester);
    }

    public Collection<UUIDIdentifiable> getAll() {
        return dao.getAll();
    }
}
