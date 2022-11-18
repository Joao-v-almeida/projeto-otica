package br.com.oticanewlook.oticanewlook.services.autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptor())
        .excludePathPatterns(
          "/",
          "/logar",
          "/css/**",
          "/image/**",
          "/js/**"
        );
  }
}
