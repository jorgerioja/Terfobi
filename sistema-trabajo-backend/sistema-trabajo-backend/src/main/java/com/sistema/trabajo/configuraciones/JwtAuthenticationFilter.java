package com.sistema.trabajo.configuraciones;

import com.sistema.trabajo.servicios.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
//import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    //un filtro intercepta todas las invocaciones al servidor, comprueba la
    //existencia del token, lo desencripta y valida
    //Si todo esta Ok autoriza la petición
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{
                username= this.jwtUtil.extractUsername(jwtToken);

            }catch (ExpiredJwtException exception){
                System.out.println("El token ha expirado");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Token inválido, no empieza con bearer string");
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        else{
                System.out.println("El token no es válido");
        }
        filterChain.doFilter(request, response);
    }
}
