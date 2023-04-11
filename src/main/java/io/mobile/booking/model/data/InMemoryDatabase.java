package io.mobile.booking.model.data;

import io.mobile.booking.model.*;

import java.util.*;

public class InMemoryDatabase {

    private static InMemoryDatabase instance;

    private static Map<Class, Map<UUID, UUIDIdentifiable>> database = new HashMap<>();

    private InMemoryDatabase() {
        initDatabase();
    }

    public static InMemoryDatabase getInstance() {

        if (instance == null) {
            instance = new InMemoryDatabase();
        }

        return instance;
    }

    public static Map<UUID, UUIDIdentifiable> getList(Class clazz) {

        getInstance();

        return database.get(clazz);
    }

    private static void initDatabase() {
        database = new HashMap<>();

        database.put(MobilePhone.class, new HashMap<>());
        database.put(Tester.class, new HashMap<>());
        database.put(Manufacturer.class, new HashMap<>());
        database.put(DeviceBooking.class, new HashMap<>());

    }

    public static void restartDatabase() {
        getInstance();
        initDatabase();
    }
}
