package com.jobassistant.login_signup.model;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@Data
@Document(collection = "users")
@AllArgsConstructor
public class User implements UserDetails{
    
    private @MongoId ObjectId id;

    @NonNull
    @Indexed
    private String Email;

    @NonNull
    private String Password;

    private String FirstName;

    private String LastName;

    private boolean Active;

    private Set<UserRole> userRoles;


    @Override
    public Collection<UserRole> getAuthorities() {
        return this.userRoles;
    }


    @Override
    public String getUsername() {
       return this.Email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.Active;
    }


    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }


    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
    }


    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }


    public User(String username, String password2, Set<GrantedAuthority> grantedAuthorities) {
        //TODO Auto-generated constructor stub
    } 

    

}
