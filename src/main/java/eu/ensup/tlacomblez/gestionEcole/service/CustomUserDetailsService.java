package eu.ensup.tlacomblez.gestionEcole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import eu.ensup.tlacomblez.gestionEcole.dao.DirecteurDao;
import eu.ensup.tlacomblez.gestionEcole.domain.CustomUserDetails;
import eu.ensup.tlacomblez.gestionEcole.domain.Directeur;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private DirecteurDao directeurDao;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Directeur user = directeurDao.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
 
}