package  com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
//premirerement il faut creer les tables suivants dans la base de donnees
//use actions ;
//CREATE TABLE `users` (
//        `id` INT NOT NULL AUTO_INCREMENT,
//    `username` VARCHAR(45) NOT NULL,
//    `password` VARCHAR(45) NOT NULL,
//    `enabled` INT NOT NULL,
//PRIMARY KEY (`id`)
//);
//
//CREATE TABLE `authorities` (
//        `id` INT NOT NULL AUTO_INCREMENT,
//    `username` VARCHAR(45) NOT NULL,
//    `authority` VARCHAR(45) NOT NULL,
//PRIMARY KEY (`id`)
//);
//
//INSERT IGNORE INTO `users` VALUES (NULL, 'xproce', '123456', '1');
//INSERT IGNORE INTO `authorities` VALUES (NULL, 'xproce', 'write');

@Configuration
public class ProjectSecurityConfigMysql {
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
