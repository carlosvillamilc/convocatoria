package com.convocatorias.backend.service;

import com.convocatorias.backend.entity.Convocatoria;
import com.convocatorias.backend.repository.ConvocatoriaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ConvocatoriaService {
    @Autowired
    ConvocatoriaRepository convocatoriaRepository;

    public  List<Convocatoria> listaConvocatoria() {
        return convocatoriaRepository.findAll();
    }
    public  Optional<Convocatoria> getConvocatoria(int idConvocatoria) {
        return convocatoriaRepository.findById(idConvocatoria);
    }
    public  Optional<Convocatoria> getByNombreConvocatoria(String nombreConvocatoria){
        return convocatoriaRepository.findByNombre(nombreConvocatoria);
    }
    public Convocatoria saveConvocatoria(Convocatoria convocatoria){
        return convocatoriaRepository.save(convocatoria);
    }
     public void deleteConvocatoria(int idConvocatoria){
        convocatoriaRepository.deleteById((idConvocatoria));
    }
    public boolean existsByIdConvocatoria(int idConvocatoria){
        return convocatoriaRepository.existsById(idConvocatoria);
    }
    public boolean existsByNombreConvocatoria(String nombreConvocatoria){
        return convocatoriaRepository.existsByNombre(nombreConvocatoria);
    }
}
