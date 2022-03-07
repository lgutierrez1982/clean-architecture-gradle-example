package cl.lgutierrez.example.app.infraestructure.repository.jpa;

import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findByUsername(String username);
}
