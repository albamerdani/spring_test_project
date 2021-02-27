package springboot_project.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springboot_project.test.model.Punonjes;

import javax.transaction.Transactional;

@Repository
public interface PunonjesRepository extends JpaRepository<Punonjes, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM punonjes p WHERE p.id_departament = :idDepartament")
    void deleteByDepartamentId(Integer idDepartament);
}
