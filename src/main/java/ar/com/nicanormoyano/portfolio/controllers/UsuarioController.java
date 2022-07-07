package ar.com.nicanormoyano.portfolio.controllers;

import ar.com.nicanormoyano.portfolio.models.Usuarios;
import ar.com.nicanormoyano.portfolio.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Secured("ROLE_ADMIN")
    @GetMapping("api/usuarios")
    public List<Usuarios> getUsuarios() {
        return iUsuarioService.getUsuarios();
    }


    @Secured("ROLE_ADMIN")
    @GetMapping("api/usuario/{id}")
    public Usuarios getUsuario(@PathVariable Integer id) {
        return iUsuarioService.getUsuario(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/usuario")
    public String agregarUsuario(@RequestBody Usuarios usuarios) {
        iUsuarioService.agregarUsuario(usuarios);
        return "perfecto";
    }



    @Secured("ROLE_ADMIN")
    @GetMapping("api/usuarioLog/{username}")
    public Integer personaLogeada(@PathVariable String username) {
        return iUsuarioService.personaLogeada(username);
    }
}
