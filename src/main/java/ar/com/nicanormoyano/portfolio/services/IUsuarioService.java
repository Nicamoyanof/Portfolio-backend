package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Usuarios;

import java.util.List;

public interface IUsuarioService {
    List<Usuarios> getUsuarios();


    Usuarios getUsuario(Integer id);

    Usuarios getUsuartioByUsername(String username);

    void agregarUsuario(Usuarios usuarios);

    Integer personaLogeada(String username);
}
