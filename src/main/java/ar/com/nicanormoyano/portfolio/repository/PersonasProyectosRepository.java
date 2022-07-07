package ar.com.nicanormoyano.portfolio.repository;

import ar.com.nicanormoyano.portfolio.models.PersonasProyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasProyectosRepository extends JpaRepository<PersonasProyectos, Integer> {
}
