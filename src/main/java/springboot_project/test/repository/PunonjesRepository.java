package springboot_project.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springboot_project.test.model.Punonjes;

import javax.transaction.Transactional;


public interface PunonjesRepository extends JpaRepository<Punonjes, String> {

    @Modifying
    @Transactional
    @Query("DELETE FROM punonjes p WHERE p.idDepartament = :i")
    void deleteByDepartamentId(String idDepartament);
}
