package ru.manannikov.learnMVC;

import org.springframework.boot.CommandLineRunner;
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
//	CommandLineRunner runner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
//		return args -> {
//			if (roleRepository.findByAuthority("USER").isPresent()) return;
//
//			RoleEntity userRole = roleRepository.save(new RoleEntity("USER"));
//			RoleEntity adminRole = roleRepository.save(new RoleEntity("ADMIN"));
//
//			userRepository.save(new UserEntity("manannikov", encoder.encode("pass"), Set.of(userRole)));
//			userRepository.save(new UserEntity("admin", encoder.encode("pass"), Set.of(userRole, adminRole)));
//		};
//	}

}
