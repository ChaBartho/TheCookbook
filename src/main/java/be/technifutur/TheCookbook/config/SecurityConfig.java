package be.technifutur.TheCookbook.config;

import be.technifutur.TheCookbook.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * Les premiers matchers ont la priorité
     * anyRequest, s'il est mis, doit être le dernier matcher
     *
     * <h2>RequestMatchers:</h2>
     *
     *      <h3>Lambda RequestMatchers:</h3>
     *      <ul>
     *          <li>prend une HttpServletRequest en param, renvoi un boolean</li>
     *      </ul>
     *
     *      <h3>Method:</h3>
     *      <ul>
     *          <li>une valeur de l'enum HttpMethod</li>
     *      </ul>
     *
     *      <h3>Pattern: 1 ou pls chaine de carac. représentant des URIs</h3>
     *      <ul>
     *          <li>? : remplace une lettre</li>
     *          <li>* : n'importe quelles valeurs dans 1 segment</li>
     *          <li>{machin:regex} : n'imp. quelles valeurs correspondant au pattern regex pour 1 segment</li>
     *          <li>** : n'importe quelle valeur dans 0 à N segments (seulement en dernier segment)</li>
     *      </ul>
     *
     * <h2>Authorization:</h2>
     * <ul>
     *     <li>permitAll():          tout le monde passe</li>
     *     <li>denyAll():            personne ne passe</li>
     *     <li>authenticated():      les users authentifiés</li>
     *     <li>anonymous():          les users non authentifiés</li>
     *     <li>hasAuthority(?)</li>
     *     <li>hasAnyAuthority(...?)</li>
     *     <li>hasRole(?)</li>
     *     <li>hasAnyRole(...?)</li>
     * </ul>
     *
     * <p>
     *     Une Authority c'est un droit sous forme de String (plus un droit à une action)<br/>
     *     Un Role est une Authority qui commence par 'ROLE_' (qui est l'utilisateur pour mon app)
     * </p>
     *
     * <dl>
     *     <dt>auth: 'ROLE_TRUC' -></dt>
     *     <dd>role: 'TRUC'</dd>
     *     <dt>auth: 'MACHIN' -></dt>
     *     <dd>(/) role</dd>
     * </dl>
     *
     * @param http the builder for the SecurityFilterChain
     * @return a configured SecurityFilterChain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {

        http.csrf().disable();

        http.httpBasic().disable();
        http.addFilterBefore( jwtFilter, UsernamePasswordAuthenticationFilter.class );
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests( (authorize) -> {
            authorize
                    .requestMatchers(HttpMethod.POST, "/auth/*").anonymous()
                    // via lambda RequestMatchers
                    .requestMatchers(HttpMethod.POST, "/photos/*").anonymous()
                    .requestMatchers(HttpMethod.POST, "/post/*").anonymous()
                    .requestMatchers( request -> request.getRequestURI().length() > 50 ).hasRole("ADMIN")
                    // via mapping d'URI
                    .requestMatchers("/plane/all").anonymous()
                    .requestMatchers("/plane/add").authenticated()
                    .requestMatchers("/plane/{id:[0-9]+}/?pdate").hasRole("ADMIN")//.hasAuthority("ROLE_ADMIN")
                    // via HttpMethod
                    .requestMatchers( HttpMethod.POST ).hasRole("ADMIN")
                    .anyRequest().permitAll();
        });

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}