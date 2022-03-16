package eu.ensup.tlacomblez.gestionEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.ensup.tlacomblez.gestionEcole.domain.Responsable;

public interface ResponsableDao extends JpaRepository<Responsable, Long>  {

    
}
