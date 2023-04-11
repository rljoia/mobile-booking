package io.mobile.booking.model.dao;

import io.mobile.booking.model.UUIDIdentifiable;
import io.mobile.booking.model.data.InMemoryDatabase;

import java.util.*;

public abstract class BaseDAO<T> implements DAO {

    protected final Class<T> typeClass;

    protected BaseDAO(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    @Override
    public Optional<UUIDIdentifiable> get(UUID id) {

        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        UUIDIdentifiable uuidIdentifiable = list.get(id);

        return Optional.ofNullable(uuidIdentifiable);
    }

    @Override
    public Collection<UUIDIdentifiable> getAll() {

        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        return list.values();
    }

    @Override
    public UUID save(UUIDIdentifiable t) {
        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        if (t.getId() == null) {
            t.setId(UUID.randomUUID());
        }

        list.put(t.getId(), t);

        return t.getId();
    }

    @Override
    public void update(UUIDIdentifiable t) {
        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        list.put(t.getId(), t);
    }

    @Override
    public void delete(UUIDIdentifiable t) {
        Map<UUID, UUIDIdentifiable> list = InMemoryDatabase.getList(typeClass);

        list.remove(t.getId());
    }
}
