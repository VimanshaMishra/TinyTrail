package com.tini.trail.services;

import com.tini.trail.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.spec.PSource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetailImp implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority > authorities;

    public UserDetailImp(Long id, String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }
    public static UserDetailImp build (User user) {
        GrantedAuthority auhtority= new SimpleGrantedAuthority("ROLE_USER");
        return new UserDetailImp(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                Collections.singletonList(auhtority)
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println("Username: " + username);
        System.out.println("test"  + username);
        System.out.println("test2"  + username);
        return username  ;

    }
}
