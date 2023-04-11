package io.mobile.booking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
public abstract class Person implements UUIDIdentifiable {

    @EqualsAndHashCode.Include
    private UUID id;

    private String name;
    private String phoneNumber;
    private String email;
}
