package springboot_project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springboot_project.test.model.Departament;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class DepartamentCRUD {

    private static final Logger logger = LoggerFactory.getLogger(DepartamentCRUD.class);

    private static Map<String, Departament> depRepo = new HashMap<>();
    static {
        Departament dep1 = new Departament();
        dep1.setIdDepartament("1");
        dep1.setNameDepartament("JAVA");
        dep1.setDescription("Departamenti per krijimin e softwareve desktop, web, android, microserviseve.");
        depRepo.put(dep1.getIdDepartament(), dep1);

        Departament dep2 = new Departament();
        dep2.setIdDepartament("2");
        dep2.setNameDepartament("DEVOPS");
        dep2.setDescription("Departamenti per automatizimin e proceseve, ndertimin, testimin, ruajtjen ne cloud dhe monitorimin e aplikacioneve.");
        depRepo.put(dep2.getIdDepartament(), dep2);
    }

    @RequestMapping(value = "/departament", method = RequestMethod.POST)
    @GetMapping("/createDepartament")
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
    @GetMapping("/updateDepartament")
    public ResponseEntity<Object> updateDepartament(@PathVariable("idDepartament") String id, @RequestBody Departament dep) {
        if(!depRepo.containsKey(id))throw new ExceptionController();
        depRepo.remove(id);
        dep.setIdDepartament(id);
        depRepo.put(id, dep);
        logger.info("Departament is updated successfully");
        return new ResponseEntity<>("Departament is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/departament/{id}", method = RequestMethod.DELETE)
    @GetMapping("/deleteDepartament")
    public ResponseEntity<Object> deleteDepartament(@PathVariable("idDepartament") String id) {
        if(!depRepo.containsKey(id))throw new ExceptionController();
        depRepo.remove(id);
        logger.info("Departament is deleted successfully");
        return new ResponseEntity<>("Departament is deleted successsfully", HttpStatus.OK);
    }

}
