package io.mobile.booking.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Manufacturer implements UUIDIdentifiable {

    @EqualsAndHashCode.Include
    private UUID id;

    private String name;
    private Integer foundationYear;
    private String website;
}
