package eu.ensup.tlacomblez.gestionEcole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import eu.ensup.tlacomblez.gestionEcole.domain.Responsable;

public interface ResponsableDao extends JpaRepository<Responsable, Long>  {

    @Query(value = "SELECT * FROM personne p WHERE p.email = ?1 and p.dtype = 'Responsable'", nativeQuery = true)
    public Responsable findByEmail( String email);
}
