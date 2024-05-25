package ru.manannikov.learnMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnMvcApplication {

	public static void main(String[] args) {
		// Выполняем инициализацию контекста приложения
		// Передаем экз класса Class<LearnMvcApplication> для рефлексии, чтобы среда выполнения могла анализировать установленные метаданные.
		SpringApplication.run(LearnMvcApplication.class, args);
	}

	// Возвращаем реализацию функционального интерфейса command line runner, используется для отладки приложения, вызывается сразу после инициализации констекста приложения Spring
//	@Bean
//	CommandLineRunner runner(UserManagementRepository repository, PasswordEncoder encoder) {
//		return args -> {
//			repository.save(new UserEntity("manannikov", encoder.encode("pas"), List.of("ROLE_USER")));
//			repository.save(new UserEntity("admin", encoder.encode("admin"), List.of("ROLE_ADMIN, ROLE_USER")));
////			BeanFactory
//		};
//	}

}
