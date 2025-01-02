package  com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/addOrganisateur","/addDon","/addaction").authenticated().
                        requestMatchers("/index","/organisateurs","/actions").permitAll())
                .formLogin(formlogin->{
                    formlogin.defaultSuccessUrl("/index",true);
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
