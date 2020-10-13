package br.com.codificando.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.codificando.security.CodificandoDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CodificandoDetailsService codificandoDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			//Habilitar ou desabilitar páginas
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/funcionario/**").hasRole("padrao")
			.antMatchers("/projeto/**").hasRole("padrao")
			.antMatchers("/usuario/**").hasRole("padrao")
			//Habilitar os statics
			.antMatchers("/bootstrap-4.5.2/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/fontawesome-5.14.0/**").permitAll()
			.antMatchers("/js/**").permitAll()
			//Outras autenticações
			.anyRequest().authenticated()
			.and()
			//Definir página de login
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/projetos/list", true)
				.permitAll()
			.and()
			//Relembrar usuário logado
			.rememberMe();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception{
		
		builder
			.userDetailsService(codificandoDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	public static void main(String[]args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
}
