package io.mobile.booking.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder(toBuilder = true)
public abstract class Device implements UUIDIdentifiable {

    @EqualsAndHashCode.Include
    private UUID id;

    private String serialNumber;
    private Manufacturer manufacturer;

    @Builder.Default
    private boolean isAvailable = true;
}
