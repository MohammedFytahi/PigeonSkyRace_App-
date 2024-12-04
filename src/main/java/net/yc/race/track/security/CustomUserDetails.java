package net.yc.race.track.security;

import net.yc.race.track.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
        // You can add roles or permissions here
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // Assuming password is already encoded
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // You can add more logic here if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // You can add more logic here if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // You can add more logic here if needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // You can add more logic here if needed
    }

    public User getUser() {
        return this.user;
    }
}
