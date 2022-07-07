package ar.com.nicanormoyano.portfolio.repository;

import ar.com.nicanormoyano.portfolio.models.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyectos,Integer> {
}
