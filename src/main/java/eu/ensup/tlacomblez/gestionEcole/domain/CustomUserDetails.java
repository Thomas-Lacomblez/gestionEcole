package eu.ensup.tlacomblez.gestionEcole.domain;

import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class CustomUserDetails implements UserDetails {
 
    private Directeur directeur;
     
    public CustomUserDetails(Directeur directeur) {
        this.directeur = directeur;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return directeur.getPassword();
    }
 
    @Override
    public String getUsername() {
        return directeur.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    public String getFullName() {
        return directeur.getNom() + " " + directeur.getPrenom();
    }
 
}
