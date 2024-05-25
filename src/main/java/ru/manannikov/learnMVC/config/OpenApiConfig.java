package ru.manannikov.learnMVC.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

// Кастомизируем GUI документацию к API
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Мананников Атон ПИ-22-2",
                        url = "https://github.com/Antonio-Stradiavanti"
                ),
                title = "Документация OpenApi",
                description = "Документация к RESTful API, созданному в рамках лаб работ по предмету СПРПО в семестре В24"
        )
//        ,
//        security = {
//                @SecurityRequirement(name = "basicAuth")
//        }
)
//@SecurityScheme(
//        name = "basicAuth",
//        description = "Введите имя пользователя и пароль",
//        scheme = "basic",
//        type = SecuritySchemeType.HTTP,
//        in = SecuritySchemeIn.HEADER
//)
public class OpenApiConfig {
}
