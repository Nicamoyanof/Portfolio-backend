package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Habilidades;
import ar.com.nicanormoyano.portfolio.models.Proyectos;
import ar.com.nicanormoyano.portfolio.utils.ModelHabPro;

import java.util.List;

public interface IProyectosService {
    List<Proyectos> getProyectos();

    Proyectos getProyecto(Integer id);

    Integer agregarProyecto(Proyectos proyectos);

    void eliminarProyecto(Integer id);

    void agregarHabilidadProyecto(ModelHabPro modelHabPro);

    List<Habilidades> getHabilidadesProyecto(Integer id);

    void eliminarHabilidadProyecto(Integer id);

    void eliminarProyectoHabilidad(Integer id);
}
