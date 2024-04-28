package ru.manannikov.learnMVC.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomNotFoundErrorDescription {
    private Integer statusCode;
    private String message;
}
