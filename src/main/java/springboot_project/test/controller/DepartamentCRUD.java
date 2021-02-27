package springboot_project.test.controller;

import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springboot_project.test.model.Departament;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springboot_project.test.repository.DepartamentRepository;
import springboot_project.test.repository.PunonjesRepository;

import javax.validation.Valid;

@RestController
public class DepartamentCRUD {

    private static final Logger logger = LoggerFactory.getLogger(DepartamentCRUD.class);


    private final PunonjesRepository punonjesRepository;
    private final DepartamentRepository departamentRepository;

    @Autowired
    public DepartamentCRUD(PunonjesRepository punonjesRepository, DepartamentRepository departamentRepository) {
        this.punonjesRepository = punonjesRepository;
        this.departamentRepository = departamentRepository;
    }


    @RequestMapping(value = "/departament", method = RequestMethod.POST)
    @PostMapping("/createDepartament")
    public ResponseEntity<Departament> createDepartament(@Valid @RequestBody Departament dep) {
        Departament savedDep = departamentRepository.save(dep);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedDep.getIdDepartament()).toUri();

        return ResponseEntity.created(location).body(savedDep);
    }


    @RequestMapping(value = "/departament/{id}", method = RequestMethod.PUT)
    @PutMapping("/updateDepartament")
    public ResponseEntity<Departament> updateDepartament(@PathVariable Integer id, @Valid @RequestBody Departament dep) {
        Optional<Departament> depart = departamentRepository.findById(id);
        if (!depart.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        dep.setIdDepartament(depart.get().getIdDepartament());
        departamentRepository.save(dep);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/deleteDepartament")
    @DeleteMapping("/{id}")
    public ResponseEntity<Departament> deleteDepartament(@PathVariable Integer id) {
        Optional<Departament> depart = departamentRepository.findById(id);
        if (!depart.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        punonjesRepository.deleteByDepartamentId(depart.get().getIdDepartament());
        departamentRepository.delete(depart.get());

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.GET)
    @GetMapping("/getDepartament")
    //@GetMapping("/{id}")
    public ResponseEntity<Departament> getById(@PathVariable Integer id) {
        Optional<Departament> optionalDepartament = departamentRepository.findById(id);
        if (!optionalDepartament.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalDepartament.get());
    }


/*

    @RequestMapping(value = "/departament", method = RequestMethod.POST)
    @PostMapping("/createDepartament")
    public ResponseEntity<Object> createDepartament(@RequestBody Departament dep) {
        depRepo.put(dep.getIdDepartament(), dep);
        logger.info("Departament is created successfully");
        return new ResponseEntity<>("Departament is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/departament", method = RequestMethod.GET)
    @GetMapping("/getDepartamentList")
    public ResponseEntity<Object> getDepartaments() {
        logger.info("Departament information is gotten successfully");
        return new ResponseEntity<>(depRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.GET)
    @GetMapping("/getDepartament")
    public Object getDepartament(@PathVariable("idDepartament") String id, @RequestBody Departament dep) {
        if(!depRepo.containsKey(id))throw new ExceptionController();
        dep.setIdDepartament(id);
        depRepo.get(dep);
        logger.info("Departament information is gotten successfully");
        return new ResponseEntity<>(depRepo.get(dep), HttpStatus.OK);
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.PUT)
    @PutMapping("/updateDepartament")
    public ResponseEntity<Object> updateDepartament(@PathVariable("idDepartament") String id, @RequestBody Departament dep) {
        if(!depRepo.containsKey(id))throw new ExceptionController();
        depRepo.remove(id);
        dep.setIdDepartament(id);
        depRepo.put(id, dep);
        logger.info("Departament is updated successfully");
        return new ResponseEntity<>("Departament is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/deleteDepartament")
    public ResponseEntity<Object> deleteDepartament(@PathVariable("idDepartament") String id) {
        if(!depRepo.containsKey(id))throw new ExceptionController();
        depRepo.remove(id);
        logger.info("Departament is deleted successfully");
        return new ResponseEntity<>("Departament is deleted successsfully", HttpStatus.OK);
    }
*/
}
