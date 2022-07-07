package ar.com.nicanormoyano.portfolio.controllers;

import ar.com.nicanormoyano.portfolio.models.Educaciones;
import ar.com.nicanormoyano.portfolio.services.IEducaciopnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EducacionesControllers {

    @Autowired
    private IEducaciopnesService iEducaciopnesService;

    @GetMapping("api/educaciones")
    public List<Educaciones> getEducaciones(){
        return iEducaciopnesService.getEducaciones();
    }
    @GetMapping("api/educacion/{id}")
    public Educaciones getEducacion(@PathVariable Integer id){
        return iEducaciopnesService.getEducacion(id);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("api/educacion")
    public void agregarEducacion(@RequestBody Educaciones educaciones){
        iEducaciopnesService.agregarEducacion(educaciones);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("api/educaciones/{id}")
    public void eliminarEducacion(@PathVariable Integer id){
        iEducaciopnesService.eliminarEducacion(id);
    }

}
