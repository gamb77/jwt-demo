package fi.gamb77.jwtdemo.configs;

import fi.gamb77.jwtdemo.security.SecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditingConfigurations {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new SecurityAuditorAware();
    }

}
