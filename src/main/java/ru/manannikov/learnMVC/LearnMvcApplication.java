package ru.manannikov.learnMVC;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.manannikov.learnMVC.user.UserAccountEntity;
import ru.manannikov.learnMVC.user.UserManagementRepository;

@SpringBootApplication
public class LearnMvcApplication {

	public static void main(String[] args) {
		// Выполняем инициализацию контекста приложения
		// Передаем экз класса Class<LearnMvcApplication> для рефлексии, чтобы среда выполнения могла анализировать установленные метаданные.
		SpringApplication.run(LearnMvcApplication.class, args);
	}

	// Возвращаем реализацию функционального интерфейса command line runner, используется для отладки приложения, вызывается сразу после инициализации констекста приложения Spring
//	@Bean
//	CommandLineRunner runner(UserManagementRepository repository) {
//		return args -> {
//			repository.save(new UserAccountEntity("manannikov", "p@ssword", "ROLE_USER"));
//			repository.save(new UserAccountEntity("admin", "ad$min", "ROLE_ADMIN"));
//		};
//	}

}
