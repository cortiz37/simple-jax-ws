package com.security;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SecurityUtil {

    public static final boolean SIMULATE_SECURITY = true;

    @Inject
    private UserService userService;

    public boolean hasPermissions(String user, String pass, String role) {
        if (!SIMULATE_SECURITY) {
            return true;
        }
        return userService.getByUserAndPass(user, pass)
            .map(u -> u.getRoles().contains(role))
            .orElse(false);
    }
}
