package cl.lgutierrez.example.app.infraestructure.auth.adapter;

import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;
import cl.lgutierrez.example.app.infraestructure.repository.jpa.UserJpaRepository;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginAdapterRepository implements UserDetailsService {

  private final UserJpaRepository repository;

  public LoginAdapterRepository(UserJpaRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UserEntity userEntity = repository.findByUsername(username);

    if (userEntity == null) {
      throw new UsernameNotFoundException("user no register into the database");
    }
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    return new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(),
        authorities);
  }
}
