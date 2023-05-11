package com.convocatorias.backend.controller;

import com.convocatorias.backend.dto.Mensaje;
import com.convocatorias.backend.dto.ConvocatoriaDTO;
import com.convocatorias.backend.entity.Convocatoria;
import com.convocatorias.backend.service.ConvocatoriaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/convocatorias")
@CrossOrigin(origins = "http://localhost:4200")
public class ConvocatoriaController {

    @Autowired
    ConvocatoriaService convocatoriaService;
    @GetMapping("/lista")
    public ResponseEntity<List<Convocatoria>> listaConvocatorias(){

        List<Convocatoria> convocatorias = convocatoriaService.listaConvocatoria();
        return new ResponseEntity<List<Convocatoria>>(convocatorias, HttpStatus.OK);
    }

    @GetMapping("/Id/{idConvocatoria}")
    public ResponseEntity<Convocatoria> convocatoriaById(@PathVariable("idConvocatoria") int idConvocatoria){

        if (!convocatoriaService.existsByIdConvocatoria(idConvocatoria))
            return new ResponseEntity(new Mensaje("No existe la convocatoria"), HttpStatus.NOT_FOUND);

        Convocatoria convocatoria = convocatoriaService.getConvocatoria(idConvocatoria).get();
        return new ResponseEntity(convocatoria, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombreConvocatoria}")
    public ResponseEntity<Convocatoria> convocatoriaByNombre(@PathVariable("nombreConvocatoria") String nombreConvocatoria){

        if (!convocatoriaService.existsByNombreConvocatoria(nombreConvocatoria))
            return new ResponseEntity(new Mensaje("No existe la convocatoria"), HttpStatus.NOT_FOUND);

        Convocatoria convocatoria = convocatoriaService.getByNombreConvocatoria(nombreConvocatoria).get();
        return new ResponseEntity(convocatoria, HttpStatus.OK);
    }

    //Con el ? le decimos que no devulve ningún tipo de dato
    //El body va a ser un JSON
    //Aqui se usa el apache commons lang
    // El import de StringUtils es import org.apache.commons.lang3.StringUtils;
    @PostMapping("/crear")
    public ResponseEntity<?> creaConvocatoria(@RequestBody ConvocatoriaDTO convocatoriaDTO){

        if(StringUtils.isBlank(convocatoriaDTO.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if(convocatoriaService.existsByNombreConvocatoria(convocatoriaDTO.getNombre()))
            return new ResponseEntity(new Mensaje("Ya existe una convocatoria con ese nombre"), HttpStatus.BAD_REQUEST);

        Convocatoria convocatoria = new Convocatoria(convocatoriaDTO.getNombre(),
                convocatoriaDTO.getFechaPublicacion(),
                convocatoriaDTO.getDescripcion(),
                convocatoriaDTO.getEstado(),
                convocatoriaDTO.getPerfil());
        convocatoriaService.saveConvocatoria(convocatoria);
        return new ResponseEntity(new Mensaje("Convocatoria creada"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{idConvocatoria}")
    public ResponseEntity<?> actualizarConvocatoria(@PathVariable("idConvocatoria") int idConvocatoria, @RequestBody ConvocatoriaDTO convocatoriaDTO){

        if (!convocatoriaService.existsByIdConvocatoria(idConvocatoria))
            return new ResponseEntity(new Mensaje("No existe la convocatoria"), HttpStatus.NOT_FOUND);

        if (convocatoriaService.existsByNombreConvocatoria(convocatoriaDTO.getNombre())
                && convocatoriaService.getByNombreConvocatoria(convocatoriaDTO.getNombre()).get().getId() != idConvocatoria)
            return new ResponseEntity(new Mensaje("El nombre de la convocatoria ya existe"), HttpStatus.NOT_FOUND);

        if(StringUtils.isBlank(convocatoriaDTO.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);


        Convocatoria convocatoria = convocatoriaService.getConvocatoria(idConvocatoria).get();
        convocatoria.setNombre(convocatoriaDTO.getNombre());
        convocatoria.setFechaPublicacion(convocatoriaDTO.getFechaPublicacion());
        convocatoria.setDescripcion(convocatoriaDTO.getDescripcion());
        convocatoria.setPerfil(convocatoriaDTO.getPerfil());
        convocatoria.setEstado(convocatoriaDTO.getEstado());
        convocatoriaService.saveConvocatoria(convocatoria);
        return new ResponseEntity(new Mensaje("Convocatoria actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{idConvocatoria}")
    public ResponseEntity<?> borrarConvocatoria(@PathVariable("idConvocatoria") int idConvocatoria){
        if (!convocatoriaService.existsByIdConvocatoria(idConvocatoria))
            return new ResponseEntity(new Mensaje("No existe la convocatoria"), HttpStatus.NOT_FOUND);
        convocatoriaService.deleteConvocatoria(idConvocatoria);
        return new ResponseEntity(new Mensaje("Convocatoria eliminada"), HttpStatus.OK);
    }

}
