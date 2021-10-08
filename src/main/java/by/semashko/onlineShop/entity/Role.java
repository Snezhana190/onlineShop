package by.semashko.onlineShop.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN ("Admin"), User ("User");

    private String name;
    Role (String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
