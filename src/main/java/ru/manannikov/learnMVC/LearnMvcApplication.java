package ru.manannikov.learnMVC;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class LearnMvcApplication {

	public static void main(String[] args) {
		// Выполняем инициализацию контекста приложения
		// Передаем экз класса Class<LearnMvcApplication> для рефлексии, чтобы среда выполнения могла анализировать установленные метаданные.
		SpringApplication.run(LearnMvcApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
