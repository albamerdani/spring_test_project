package springbootproject.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootproject.test.model.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
