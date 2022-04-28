package eu.ensup.tlacomblez.gestionEcole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.tlacomblez.gestionEcole.dao.DirecteurDao;
import eu.ensup.tlacomblez.gestionEcole.domain.Directeur;

@Service
public class DirecteurService {
    
    @Autowired
    DirecteurDao directeurDao;

    public Directeur createDirecteur(Directeur directeur) {
        return directeurDao.save(directeur);
    }

    public List<Directeur> getAllDirecteur() {
        return directeurDao.findAll();
    }

    public Directeur getDirecteurByEmail(String email) {
        return directeurDao.findByEmail(email);
    }
}
