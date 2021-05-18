package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
