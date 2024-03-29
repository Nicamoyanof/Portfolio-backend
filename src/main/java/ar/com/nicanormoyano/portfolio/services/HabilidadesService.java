package ar.com.nicanormoyano.portfolio.services;

import ar.com.nicanormoyano.portfolio.models.Habilidades;
import ar.com.nicanormoyano.portfolio.repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadesService implements IHabilidadesService{

    @Autowired
    private HabilidadesRepository habilidadesRepository;

    @Override
    public List<Habilidades> getHabilidades() {
        return habilidadesRepository.findAll();
    }

    @Override
    public Habilidades getHabilidad(Integer id) {
        return habilidadesRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarHabilidad(Habilidades habilidades) {
        habilidadesRepository.save(habilidades);
    }

    @Override
    public void eliminarHabilidad(Integer id) {
        habilidadesRepository.deleteById(id);
    }
}
