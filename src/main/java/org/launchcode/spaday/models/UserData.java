package org.launchcode.spaday.models;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserData {
    
    private static final Map<Integer, User> users = new LinkedHashMap<>();

    public static void add(User user) {
        users.put(user.getID(), user);
    }

    public static Collection<User> getAll() {
        return users.values();
    }

    public static User getById(int id)
    {
        return users.get(id);
    }

}