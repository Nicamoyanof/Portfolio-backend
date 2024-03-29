package ar.com.nicanormoyano.portfolio.controllers;

import ar.com.nicanormoyano.portfolio.models.Habilidades;
import ar.com.nicanormoyano.portfolio.services.IHabilidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HabilidadesControllers {

    @Autowired
    private IHabilidadesService iHabilidadesService;

    @GetMapping("api/habilidades")
    public List<Habilidades> getHabilidades(){
        return iHabilidadesService.getHabilidades();
    }

    @GetMapping("api/habilidad/{id}")
    public Habilidades getHabilidad(@PathVariable Integer id){
        return iHabilidadesService.getHabilidad(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/habilidad")
    public void agregarHabilidad(@RequestBody Habilidades habilidades){
        iHabilidadesService.agregarHabilidad(habilidades);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/habilidad/{id}")
    public void eliminarHabilidad(@PathVariable Integer id){
        iHabilidadesService.eliminarHabilidad(id);
    }

}
