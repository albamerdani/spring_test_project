package springboot_project.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springboot_project.test.model.Departament;
import springboot_project.test.model.Punonjes;
import springboot_project.test.repository.DepartamentRepository;
import springboot_project.test.repository.PunonjesRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class PunonjesCRUD {

    private static final Logger logger = LoggerFactory.getLogger(PunonjesCRUD.class);

    private final PunonjesRepository punonjesRepository;
    private final DepartamentRepository departamentRepository;

    @Autowired
    public PunonjesCRUD(PunonjesRepository punonjesRepository, DepartamentRepository departamentRepository) {
        this.punonjesRepository = punonjesRepository;
        this.departamentRepository = departamentRepository;
    }
/*

    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;
*/


    @RequestMapping(value = "/punonjes", method = RequestMethod.POST)
    @PostMapping("/createPunonjes")
    public ResponseEntity<Punonjes> create(@RequestBody @Valid Punonjes p) {
        logger.info("Starting to create employee");
        Optional<Departament> optDep = departamentRepository.findById(p.getDepartament().getIdDepartament());
        if (!optDep.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        p.setDepartament(optDep.get());

        Punonjes savedPunonjes= punonjesRepository.save(p);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPunonjes.getIdPunonjes()).toUri();
        logger.info("Employee is created");

        return ResponseEntity.created(location).body(savedPunonjes);
    }



    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.PUT)
    //@PutMapping("/updatePunonjes")
    @PutMapping("/{id}")
    public ResponseEntity<Punonjes> update(@RequestBody @Valid Punonjes p, @PathVariable Integer id) {
        logger.info("Starting to update employee");
        Optional<Departament> optDep = departamentRepository.findById(p.getDepartament().getIdDepartament());
        if (!optDep.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Punonjes> optPun = punonjesRepository.findById(id);
        if (!optPun.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        p.setDepartament(optDep.get());
        p.setIdPunonjes(optPun.get().getIdPunonjes());
        punonjesRepository.save(p);

        logger.info("Employee is updated");

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/deletePunonjes")
    @DeleteMapping("/{id}")
    public ResponseEntity<Punonjes> delete(@PathVariable Integer id) {
        logger.info("Starting to delete employee");
        Optional<Punonjes> optionalPunonjes = punonjesRepository.findById(id);
        if (!optionalPunonjes.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        punonjesRepository.delete(optionalPunonjes.get());
        logger.info("Employee is deleted");

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/punonjes/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<Punonjes> getById(@PathVariable Integer id) {
        logger.info("Starting to get employee details");
        Optional<Punonjes> optionalPunonjes = punonjesRepository.findById(id);
        if (!optionalPunonjes.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalPunonjes.get());
    }

    /*
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
    @PutMapping("/updatePunonjes")
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
    @DeleteMapping("/deletePunonjes")
    public ResponseEntity<Object> deletePunonjes(HttpServletRequest request, @PathVariable("idPunonjes") String id) {
        request.getHeader("Authorization");
        if(!punonjesRepo.containsKey(id))throw new ExceptionController();
        punonjesRepo.remove(id);
        logger.info("Punonjes is deleted successsfully");
        return new ResponseEntity<>("Punonjes is deleted successsfully", HttpStatus.OK);
    }
*/

}
