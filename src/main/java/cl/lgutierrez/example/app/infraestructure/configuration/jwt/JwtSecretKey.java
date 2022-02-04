package cl.lgutierrez.example.app.infraestructure.configuration.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtSecretKey {

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtSecretKey(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public Algorithm secretKey() {
        return Algorithm.HMAC256(jwtConfig.getSecretKey().getBytes());
    }
}
