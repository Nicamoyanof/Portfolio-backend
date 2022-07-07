package ar.com.nicanormoyano.portfolio.repository;

import ar.com.nicanormoyano.portfolio.models.HabilidadesProyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesProyectosRepository extends JpaRepository<HabilidadesProyectos,Integer> {
}
