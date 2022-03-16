package eu.ensup.tlacomblez.gestionEcole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.tlacomblez.gestionEcole.dao.EtudiantDao;
import eu.ensup.tlacomblez.gestionEcole.domain.Etudiant;

@Service
public class EtudiantService {
    
    @Autowired
    EtudiantDao etudiantRepository;

    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }
}
