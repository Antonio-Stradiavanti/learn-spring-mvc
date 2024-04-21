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

}
