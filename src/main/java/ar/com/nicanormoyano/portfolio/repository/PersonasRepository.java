package ar.com.nicanormoyano.portfolio.repository;

import ar.com.nicanormoyano.portfolio.models.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Personas,Integer> {

}
