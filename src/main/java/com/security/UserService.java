package com.security;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * In memory 'database'
 */
@ApplicationScoped
public class UserService {

    private final static List<User> database = new ArrayList<>();

    static {
        database.add(new User("user", "user", Collections.singleton("USER")));
        database.add(new User("admin", "admin", Collections.singleton("ADMIN")));
    }

    public Optional<User> getByUserAndPass(String user, String pass) {
        return database.stream()
            .filter(u -> u.getUser().equals(user))
            .filter(u -> u.getPass().equals(pass))
            .findFirst();
    }
}