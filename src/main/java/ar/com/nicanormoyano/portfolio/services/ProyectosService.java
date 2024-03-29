package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Habilidades;
import ar.com.nicanormoyano.portfolio.models.HabilidadesProyectos;
import ar.com.nicanormoyano.portfolio.models.Proyectos;
import ar.com.nicanormoyano.portfolio.repository.HabilidadesProyectosRepository;
import ar.com.nicanormoyano.portfolio.repository.ProyectoRepository;
import ar.com.nicanormoyano.portfolio.utils.ModelHabPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectosService implements IProyectosService{

    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private HabilidadesProyectosRepository habilidadesProyectosRepository;

    @Autowired
    private IHabilidadesService iHabilidadesService;

    @Override
    public List<Proyectos> getProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyectos getProyecto(Integer id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public Integer agregarProyecto(Proyectos proyectos) {

        proyectoRepository.save(proyectos);
        for (int i = 0; i < getProyectos().size(); i++) {

            if (getProyectos().get(i)==proyectos){
                return getProyectos().get(i).getIdProyecto();
            }

        }
        return  null;
    }

    @Override
    public void eliminarProyecto(Integer id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public void agregarHabilidadProyecto(ModelHabPro modelHabPro) {
        HabilidadesProyectos habilidadesProyectos = new HabilidadesProyectos();
        habilidadesProyectos.setProyectosByIdProyecto(getProyecto(modelHabPro.getProyectos()));
        habilidadesProyectos.setHabilidadesByIdHabilidad(iHabilidadesService.getHabilidad(modelHabPro.getHabilidades()));

        habilidadesProyectosRepository.save(habilidadesProyectos);

    }

    @Override
    public List<Habilidades> getHabilidadesProyecto(Integer id) {
        List<HabilidadesProyectos> listProyectos = habilidadesProyectosRepository.findAll();
        List<Habilidades> listaFinal = new ArrayList<>();
        for (Integer i=0; i<listProyectos.size();i++) {
            if(listProyectos.get(i).getProyectosByIdProyecto().getIdProyecto()==id){
                listaFinal.add(listProyectos.get(i).getHabilidadesByIdHabilidad());
            }
        }
        return listaFinal;
    }

    @Override
    public void eliminarHabilidadProyecto(Integer id) {
        habilidadesProyectosRepository.deleteById(id);
    }

    @Override
    public void eliminarProyectoHabilidad(Integer id) {
        List<HabilidadesProyectos> listProyectos = habilidadesProyectosRepository.findAll();
        for(Integer i=0;i<listProyectos.size();i++) {
            if(listProyectos.get(i).getProyectosByIdProyecto().getIdProyecto()==id){
                habilidadesProyectosRepository.deleteById(listProyectos.get(i).getIdHabPro());
            }
        }
    }

}
