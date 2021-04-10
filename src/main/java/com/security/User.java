package com.security;

import java.util.Set;

public class User {

    private String user;
    private String pass;

    private Set<String> roles;

    public User() {
    }

    public User(String user, String pass, Set<String> roles) {
        this.user = user;
        this.pass = pass;
        this.roles = roles;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
