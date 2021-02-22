package springboot_project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import springboot_project.test.model.Departament;
import springboot_project.test.model.Punonjes;
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
public class PunonjesCRUD {

    private static final Logger logger = LoggerFactory.getLogger(PunonjesCRUD.class);

    private static Map<String, Punonjes> punonjesRepo = new HashMap<>();
    static {

        Departament dep = new Departament();

        DepartamentCRUD depCrud = new DepartamentCRUD();

        Punonjes p1 = new Punonjes();
        p1.setIdPunonjes("1");
        p1.setName("Alba");
        p1.setGender("Femer");
        p1.setEmail("alba@gmail.com");
        p1.setAddress("Adrese");
        p1.setDepartament((Departament) depCrud.getDepartament("1", dep));
        punonjesRepo.put(p1.getIdPunonjes(), p1);

        Punonjes p2 = new Punonjes();
        p2.setIdPunonjes("2");
        p2.setName("Punonjes 2");
        p2.setGender("Mashkull");
        p2.setEmail("punonjes2@gmail.com");
        p2.setAddress("Adresa 2");
        p1.setDepartament((Departament) depCrud.getDepartament("2", dep));
        punonjesRepo.put(p2.getIdPunonjes(), p2);
    }

    @RequestMapping(value = "/punonjes", method = RequestMethod.POST)
    public ResponseEntity<Object> createPunonjes(@RequestBody Punonjes pun) {
        punonjesRepo.put(pun.getIdPunonjes(), pun);
        logger.info("Punonjes is created successfully");
        return new ResponseEntity<>("Punonjes is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/punonjes")
    public ResponseEntity<Object> getPunonjes() {
        logger.info("Punonjes information is gotten successfully");
        return new ResponseEntity<>(punonjesRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePunonjes(@PathVariable("idPunonjes") String id, @RequestBody Punonjes pun) {
        if(!punonjesRepo.containsKey(id))throw new ExceptionController();
        punonjesRepo.remove(id);
        pun.setIdPunonjes(id);
        punonjesRepo.put(id, pun);
        logger.info("Punonjes is updated successsfully");
        return new ResponseEntity<>("Punonjes is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePunonjes(@PathVariable("idPunonjes") String id) {
        if(!punonjesRepo.containsKey(id))throw new ExceptionController();
        punonjesRepo.remove(id);
        logger.info("Punonjes is deleted successsfully");
        return new ResponseEntity<>("Punonjes is deleted successsfully", HttpStatus.OK);
    }

}
