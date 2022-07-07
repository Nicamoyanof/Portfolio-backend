package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Educaciones;

import java.util.List;

public interface IEducaciopnesService {
    List<Educaciones> getEducaciones();

    Educaciones getEducacion(Integer id);

    void agregarEducacion(Educaciones educaciones);

    void eliminarEducacion(Integer id);
}
