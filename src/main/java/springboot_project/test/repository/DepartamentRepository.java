package springboot_project.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot_project.test.model.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
