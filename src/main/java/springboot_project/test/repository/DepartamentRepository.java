package springboot_project.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_project.test.model.Departament;

public interface DepartamentRepository extends JpaRepository<Departament, String> {
}
