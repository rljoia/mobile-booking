package io.mobile.booking.model.dao;

import io.mobile.booking.model.UUIDIdentifiable;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface DAO {

    Optional<UUIDIdentifiable> get(UUID id);
    Collection<UUIDIdentifiable> getAll();
    UUID save(UUIDIdentifiable t);
    void update(UUIDIdentifiable t);
    void delete(UUIDIdentifiable t);
}
