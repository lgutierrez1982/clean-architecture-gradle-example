package cl.lgutierrez.example.app.infraestructure.repository.jpa;

import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

  UserEntity findByUsername(String username);
}
