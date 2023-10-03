//package Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//
//import br.edu.iff.bsi.Pizzaria.service.*;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http.authorizeHttpRequests((requests) -> requests
//	            .requestMatchers("/", "/home", "/login").permitAll()
//	            .requestMatchers("/webjars/**", "/css/**", "/js/**").permitAll()
//	            .requestMatchers("cliente/cadastro", "cliente/listar", "cliente/editar",
//	                             "funcionario/cadastro", "funcionario/listar", "funcionario/editar",
//	                             "ingrediente/cadastro", "ingrediente/listar", "ingrediente/editar",
//	                             "pizza/cadastro", "pizza/editar")
//	            .hasRole("adm")
//	            .anyRequest().authenticated())
//	        .formLogin((form) -> form.permitAll())
//	        .logout((logout) -> logout.permitAll());
//
//	    return http.build();
//	}
//
//
////	@Bean
////	public UserDetailsService userDetailsService() {
////		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("p").roles("USER")
////				.build();
////		UserDetails adm = User.withDefaultPasswordEncoder().username("adm").password("p").roles("adm").build();
////
////		return new InMemoryUserDetailsManager(user, adm);
////	}
//
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http,PasswordEncoder passwordEncoder, UsuarioDetailsService userDetailsService) throws Exception {
//		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService).passwordEncoder(passwordEncoder).and().build();
//	}
//
//	@Bean
//    public SessionAuthenticationStrategy sessionAuthStrategy() {
//        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
//    }
//
//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean<?> servletListenerRegistrationBean() {
//        return new ServletListenerRegistrationBean<>( new HttpSessionEventPublisher() );
//    }
//
//}
