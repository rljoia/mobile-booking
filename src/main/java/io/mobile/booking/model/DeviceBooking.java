package io.mobile.booking.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;


@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DeviceBooking implements UUIDIdentifiable {

    @EqualsAndHashCode.Include
    private UUID id;

    private Device device;
    private Person person;

    private Date bookedDate;
    private Date returnedDate;
}
