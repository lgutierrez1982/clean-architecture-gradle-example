package cl.lgutierrez.example.app.infraestructure.auth.filter;

import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtConfig;
import cl.lgutierrez.example.app.infraestructure.configuration.jwt.JwtSecretKey;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;
    private final JwtSecretKey jwtSecretKey;

    public CustomAuthorizationFilter(JwtConfig jwtConfig,
                                     JwtSecretKey jwtSecretKey) {

        this.jwtConfig = jwtConfig;
        this.jwtSecretKey = jwtSecretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//       if(request.getServletPath().equals("/login")){//Implementar la ruta /login
//           filterChain.doFilter(request, response);
//       } else {
           String authorizationHeader = request.getHeader(AUTHORIZATION);
            if( authorizationHeader != null && authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
               try {
                   String token = authorizationHeader.substring(jwtConfig.getTokenPrefix().length());
                   Algorithm algorithm = this.jwtSecretKey.secretKey();
                   JWTVerifier verifier = JWT.require(algorithm).build();
                   DecodedJWT decodedJWT = verifier.verify(token);
                   String username = decodedJWT.getSubject();
                   String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                   Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                   stream(roles).forEach(role -> {
                       authorities.add(new SimpleGrantedAuthority(role));
                   });
                   UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                           username,
                           null,
                           authorities);
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                   filterChain.doFilter(request, response);
               } catch (Exception exception) {
                   response.setHeader("error", exception.getMessage());
                   response.setStatus(FORBIDDEN.value());
                   Map<String, String> error = new HashMap<>();
                   error.put("error_message", exception.getMessage());
                   response.setContentType(APPLICATION_JSON_VALUE);
                   new ObjectMapper().writeValue(response.getOutputStream(), error);
               }
           } else {
               filterChain.doFilter(request, response);
           }
       }
    //}
}
