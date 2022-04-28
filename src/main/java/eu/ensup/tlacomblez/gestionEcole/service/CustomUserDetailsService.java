package eu.ensup.tlacomblez.gestionEcole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import eu.ensup.tlacomblez.gestionEcole.dao.DirecteurDao;
import eu.ensup.tlacomblez.gestionEcole.dao.ResponsableDao;
import eu.ensup.tlacomblez.gestionEcole.domain.CustomUserDetails;
import eu.ensup.tlacomblez.gestionEcole.domain.Directeur;
import eu.ensup.tlacomblez.gestionEcole.domain.Responsable;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private DirecteurDao directeurDao;
    
    @Autowired
    private ResponsableDao responsableDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Directeur userD = directeurDao.findByEmail(username);
        Responsable userR = responsableDao.findByEmail(username);
        if (userD != null) {
            
            return new CustomUserDetails(userD);
        }
        else if (userR != null) {
            return new CustomUserDetails(userR);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
        
    }
 
}