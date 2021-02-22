package springboot_project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springboot_project.test.model.Departament;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        dep1.setNameDepartament("DEVOPS");
        dep1.setDescription("Departamenti per automatizimin e proceseve, ndertimin, testimin, ruajtjen ne cloud dhe monitorimin e aplikacioneve.");
        depRepo.put(dep2.getIdDepartament(), dep2);
    }

    @RequestMapping(value = "/Departament", method = RequestMethod.POST)
    public ResponseEntity<Object> createDepartament(@RequestBody Departament dep) {
        depRepo.put(dep.getIdDepartament(), dep);
        logger.info("Departament is created successfully");
        return new ResponseEntity<>("Departament is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Departament")
    public ResponseEntity<Object> getDepartament() {
        logger.info("Departament information is gotten successfully");
        return new ResponseEntity<>(depRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Departament/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateDepartament(@PathVariable("idDepartament") String id, @RequestBody Departament dep) {
        depRepo.remove(id);
        dep.setIdDepartament(id);
        depRepo.put(id, dep);
        logger.info("Departament is updated successfully");
        return new ResponseEntity<>("Departament is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/Departament/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDepartament(@PathVariable("idDepartament") String id) {
        depRepo.remove(id);
        logger.info("Departament is deleted successfully");
        return new ResponseEntity<>("Departament is deleted successsfully", HttpStatus.OK);
    }

}
