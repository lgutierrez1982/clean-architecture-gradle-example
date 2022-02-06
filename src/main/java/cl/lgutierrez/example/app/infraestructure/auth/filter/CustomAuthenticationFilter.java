package cl.lgutierrez.example.app.infraestructure.auth.filter;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import cl.lgutierrez.example.app.infraestructure.auth.UsernameAndPasswordAuthenticationRequest;
import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtConfig;
import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtSecretKey;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final JwtConfig jwtConfig;
  private final JwtSecretKey jwtSecretKey;

  public CustomAuthenticationFilter(AuthenticationManager authenticationManager,
                                    JwtConfig jwtConfig,
                                    JwtSecretKey jwtSecretKey) {

    this.authenticationManager = authenticationManager;
    this.jwtConfig = jwtConfig;
    this.jwtSecretKey = jwtSecretKey;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    try {
      UsernameAndPasswordAuthenticationRequest authenticationRequest =
          new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
      Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
          authenticationRequest.getUsername(),
          authenticationRequest.getPassword()
      );
      Authentication authenticate = authenticationManager.authenticate(authenticationToken);
      return authenticate;

    } catch (IOException e) {
      throw new RuntimeException();
    }

  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult) throws IOException, ServletException {
    User user = (User) authResult.getPrincipal();
    Algorithm algorithm = this.jwtSecretKey.secretKey();
    System.out.println(new Date(System.currentTimeMillis()));
    String accessToken = JWT.create()
        .withSubject(user.getUsername())
        .withExpiresAt(Date.from(Instant.now().plus(jwtConfig.getTokenExpirationAfterHours(), ChronoUnit.HOURS)))
        .withIssuer(request.getRequestURL().toString())
        .withClaim("roles",
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .sign(algorithm);

    String refreshToken = JWT.create()
        .withSubject(user.getUsername())
        .withExpiresAt(Date.from(Instant.now().plus(jwtConfig.getRefreshTokenExpirationAfterHours(), ChronoUnit.HOURS)))
        .withIssuer(request.getRequestURL().toString())
        .sign(algorithm);

    Map<String, String> tokens = new HashMap<>();
    tokens.put("access_token", accessToken);
    tokens.put("refresh_token", refreshToken);
    response.setContentType(APPLICATION_JSON_VALUE);
    new ObjectMapper().writeValue(response.getOutputStream(), tokens);

  }
}
