package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Habilidades;

import java.util.List;

public interface IHabilidadesService {
    List<Habilidades> getHabilidades();

    Habilidades getHabilidad(Integer id);

    void agregarHabilidad(Habilidades habilidades);

    void eliminarHabilidad(Integer id);
}
