package ar.com.nicanormoyano.portfolio.repository;

import ar.com.nicanormoyano.portfolio.models.PersonasHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasHabilidadesRepository  extends JpaRepository<PersonasHabilidades,Integer> {
}
