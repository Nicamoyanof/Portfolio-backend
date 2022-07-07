package ar.com.nicanormoyano.portfolio.controllers;

import ar.com.nicanormoyano.portfolio.models.Habilidades;
import ar.com.nicanormoyano.portfolio.models.Proyectos;
import ar.com.nicanormoyano.portfolio.services.IProyectosService;
import ar.com.nicanormoyano.portfolio.utils.ModelHabPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProyectosControllers {

    @Autowired
    private IProyectosService iProyectosService;

    @Secured("ROLE_ADMIN")
    @GetMapping("api/proyectos")
    public List<Proyectos> getProyectos(){
        return iProyectosService.getProyectos();
    }

    @GetMapping("api/proyecto/{id}")
    public Proyectos getProyecto(@PathVariable Integer id){
        return iProyectosService.getProyecto(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/proyecto")
    public Integer agregarProyecto(@RequestBody Proyectos proyectos){
        return iProyectosService.agregarProyecto(proyectos);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/proyecto/{id}")
    public void eliminarProyecto(@PathVariable Integer id){
        iProyectosService.eliminarProyecto(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/proyecto/habilidad")
    public void agregarHabilidadProyecto(@RequestBody ModelHabPro modelHabPro){
        iProyectosService.agregarHabilidadProyecto(modelHabPro);
    }

    @GetMapping("api/proyecto/{id}/habilidades")
    public List<Habilidades> getHabilidadesProyecto(@PathVariable Integer id){
        return iProyectosService.getHabilidadesProyecto(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/proyecto/habilidades/{id}")
    public void eliminarHabilidadProyecto(@PathVariable int id){
        iProyectosService.eliminarHabilidadProyecto(id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/proyecto/{id}/habilidades")
    public void eliminarProyectoHabilidad(@PathVariable Integer id){
        iProyectosService.eliminarProyectoHabilidad(id);
    }


}
