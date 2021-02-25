package springboot_project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_project.test.config.SecurityConfig;
import springboot_project.test.model.Departament;
import springboot_project.test.model.Punonjes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        //p1.setDepartament((Departament) depCrud.getDepartament("1", dep));
        punonjesRepo.put(p1.getIdPunonjes(), p1);

        Punonjes p2 = new Punonjes();
        p2.setIdPunonjes("2");
        p2.setName("Punonjes 2");
        p2.setGender("Mashkull");
        p2.setEmail("punonjes2@gmail.com");
        p2.setAddress("Adresa 2");
        //p2.setDepartament((Departament) depCrud.getDepartament("2", dep));
        punonjesRepo.put(p2.getIdPunonjes(), p2);
    }
    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;

    @RequestMapping(value = "/punonjes", method = RequestMethod.POST)
    @GetMapping("/createPunonjes")
    public ResponseEntity<Object> createPunonjes(HttpServletRequest request, @RequestBody Punonjes pun) throws ServletException {
        //request.login(username, password);
        request.getHeader("Authorization");
        punonjesRepo.put(pun.getIdPunonjes(), pun);
        logger.info("Punonjes is created successfully");
        return new ResponseEntity<>("Punonjes is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/punonjes", method = RequestMethod.GET)
    @GetMapping("/getPunonjes")
    public ResponseEntity<Object> getPunonjes(HttpServletRequest request) {
        request.getHeader("Authorization");
        logger.info("Punonjes information is gotten successfully");
        return new ResponseEntity<>(punonjesRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.PUT)
    @GetMapping("/updatePunonjes")
    public ResponseEntity<Object> updatePunonjes(HttpServletRequest request, @PathVariable("idPunonjes") String id, @RequestBody Punonjes pun) {
        request.getHeader("Authorization");
        if(!punonjesRepo.containsKey(id))throw new ExceptionController();
        punonjesRepo.remove(id);
        pun.setIdPunonjes(id);
        punonjesRepo.put(id, pun);
        logger.info("Punonjes is updated successsfully");
        return new ResponseEntity<>("Punonjes is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.DELETE)
    @GetMapping("/deletePunonjes")
    public ResponseEntity<Object> deletePunonjes(HttpServletRequest request, @PathVariable("idPunonjes") String id) {
        request.getHeader("Authorization");
        if(!punonjesRepo.containsKey(id))throw new ExceptionController();
        punonjesRepo.remove(id);
        logger.info("Punonjes is deleted successsfully");
        return new ResponseEntity<>("Punonjes is deleted successsfully", HttpStatus.OK);
    }

}
