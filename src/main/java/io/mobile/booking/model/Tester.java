package io.mobile.booking.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class Tester extends Person {

    private List<String> skills;
}
